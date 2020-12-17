package com.microservicio.covid.adapter;

import com.microservicio.covid.model.dto.NewsDTO;
import com.microservicio.covid.model.entity.News;
import com.microservicio.covid.model.entity.NewsWrapper;
import com.microservicio.covid.service.NewsDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Qualifier(value = "web_hose_adapter")
public class NewsAdapterImpl implements NewsAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(NewsAdapterImpl.class);
    private static final String REQUEST_PARAMETER = "coronavirus casos positivos  language:spanish thread.country:AR thread.site_type:news thread.site:telefenoticias.com.ar thread.title:Coronavirus en Argentina";
    private static final String SORT = "crawled";
    private static final String HEADER_APPLICATION_JSON = "application/json";
    private static final String HEADER_CONTENT_TYPE = "Content-Type";
    @Value("${news.default.url}")
    private String newsApiUrl;
    @Value("${news.default.token}")
    private String newsToken;
    @Autowired
    private NewsDao newsDao;

    @Override
    public NewsWrapper getNews(NewsDTO newsDTO) {

        NewsWrapper newsList = new NewsWrapper();

        List<News> news = newsDao.findByPublished(newsDTO.getPublished());
        if (!CollectionUtils.isEmpty(news)) {
            newsList.setPosts(newsDao.findByPublished(newsDTO.getPublished()));
            LOGGER.info("Existed news for the date {} consulting.", newsDTO.getPublished());
            return newsList;
        }

        //Headers
        MultiValueMap<String, String> headersMap = new LinkedMultiValueMap<>();
        headersMap.add(HEADER_CONTENT_TYPE, HEADER_APPLICATION_JSON);

        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("q", REQUEST_PARAMETER);

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(newsApiUrl)
                .queryParam("token", newsToken)
                .queryParam("format", "json")
                .queryParam("sort", SORT)
                .encode();

        LOGGER.info("log request headers");
        String uri = uriBuilder.buildAndExpand(urlParams).toUriString();
        LOGGER.info(uri);
        HttpEntity<String> newsRequestEntity = new HttpEntity<>(headersMap);

        RestTemplate restTemplate = createRestTemplate();
        ResponseEntity<NewsWrapper> newsResponseEntity;

        try {
            LOGGER.info("Request = {}", newsRequestEntity);
            newsResponseEntity = restTemplate.exchange(uriBuilder.buildAndExpand(urlParams).toUri(), HttpMethod.GET, newsRequestEntity, NewsWrapper.class);
            if (StringUtils.isEmpty(newsResponseEntity.getBody())) {
                LOGGER.error("News information are missing in the response.");
                throw new NullPointerException("News information are missing in the response.");
            }
                newsList = newsResponseEntity.getBody();
                newsDao.saveAll(newsList.getPosts());
                return newsList;
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public NewsWrapper getNewsBySource(NewsDTO newsDto) {

        NewsWrapper newsBySource = new NewsWrapper();
        LOGGER.info("Obtain news information for a given source.");
        newsBySource.setPosts(newsDao.findBySource(newsDto.getSite()));
        return newsBySource;
    }

    public RestTemplate createRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        return restTemplate;
    }
}

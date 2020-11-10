package com.microservicio.covid.adapter;

import com.microservicio.covid.controller.NewsController;
import com.microservicio.covid.model.dto.NewsDTO;
import com.microservicio.covid.model.entity.News;
import com.microservicio.covid.model.entity.NewsWrapper;
import com.microservicio.covid.service.NewsServiceDao;
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
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@Component
@Qualifier(value = "webhoseAdapter")
public class NewsAdapterImpl implements NewsAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(NewsController.class);

    @Value("${news.default.url}")
    private String newsApiUrl;
    @Value("${news.default.token}")
    private String newsToken;
    private static final String  REQUEST_PARAMETER = "coronavirus casos positivos  language:spanish thread.country:AR thread.site_type:news thread.site:telefenoticias.com.ar thread.title:Coronavirus en Argentina";
    private static final String  SORT = "crawled";

    private static final String HEADER_APPLICATION_JSON = "application/json";
    private static final String HEADER_CONTENT_TYPE = "Content-Type";

    @Autowired
    private NewsServiceDao newsServiceDao;

    @Override
    public NewsWrapper getNews(NewsDTO newsDTO) {

        NewsWrapper newsList = new NewsWrapper();
        newsList = (NewsWrapper) newsServiceDao.findByPublished(newsDTO.getPublished());

        if (newsList != null){
            LOGGER.info("Existed news for the date {} consulting.", newsDTO.getPublished());
            return newsList;
        }

        //Headers
        MultiValueMap headersMap = new LinkedMultiValueMap();
        headersMap.add(HEADER_CONTENT_TYPE, HEADER_APPLICATION_JSON);

        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("q", REQUEST_PARAMETER);

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(newsApiUrl)
                .queryParam("token", newsToken)
                .queryParam( "format", "json")
                .queryParam( "sort", SORT)
                .encode();

        LOGGER.info("log request headers");
        LOGGER.info(headersMap.toString());

        LOGGER.info("log request ");
        LOGGER.info(uriBuilder.buildAndExpand(urlParams).toUriString());
        HttpEntity newsRequestEntity = new HttpEntity(headersMap);

        RestTemplate restTemplate = createRestTemplate();
        ResponseEntity newsResponseEntity;

        try {
            LOGGER.info("Request =");
            LOGGER.info(uriBuilder.toString() + HttpMethod.GET.toString() + newsRequestEntity.toString() );
            newsResponseEntity = restTemplate.exchange(uriBuilder.buildAndExpand(urlParams).toUri(), HttpMethod.GET, newsRequestEntity, NewsWrapper.class);
            if (newsResponseEntity == null || newsResponseEntity.getBody() == null) {
                LOGGER.error("News information are missing in the response.");
                throw new Exception("News information are missing in the response.");
            }
            newsList = (NewsWrapper) newsResponseEntity.getBody();
            for (News news: newsList.getPosts()) {

                newsServiceDao.save(news);
            }
            return newsList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public RestTemplate createRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        return restTemplate;
    }
}
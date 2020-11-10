package com.microservicio.covid.service;

import com.microservicio.covid.adapter.AdapterFactory;
import com.microservicio.covid.adapter.NewsAdapter;
import com.microservicio.covid.model.dto.NewsDTO;
import com.microservicio.covid.model.entity.NewsWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class NewsServiceImpl implements NewsService{

    private NewsAdapter adapter;

    @Value("${news.default.adapter}")
    private String defaultAdapter;
    private static final Logger LOGGER = LoggerFactory.getLogger(NewsServiceImpl.class);

    @Autowired
    private AdapterFactory adapterFactory;

    @Override
    public NewsWrapper getNewsWrapperData(NewsDTO newsDto) throws Exception {

        LOGGER.info("Get news service. Default adapter: {}.", defaultAdapter);

        try {
            initAdapter();
            NewsWrapper bunchesNewResponse = adapter.getNews(newsDto);
            return bunchesNewResponse;

        } catch (Exception e) {
            LOGGER.error("Error retrieving News from adapter.");

            throw e;
        }
    }

    protected void initAdapter() throws Exception {
        if(adapter == null) {
            adapter = adapterFactory.getAdapter(defaultAdapter);
        }
    }
}

package com.microservicio.covid.service;

import com.microservicio.covid.model.entity.NewsWrapper;

public interface NewsService {

    NewsWrapper getNewsWrapperData(String published) throws Exception;

    NewsWrapper getNewsBySource(String source) throws Exception;
}

package com.microservicio.covid.service;

import com.microservicio.covid.model.dto.NewsDTO;
import com.microservicio.covid.model.entity.NewsWrapper;

public interface NewsService {

    public NewsWrapper getNewsWrapperData(NewsDTO newsDto) throws Exception;

    public NewsWrapper getNewsBySource(NewsDTO newsDto) throws Exception;
}

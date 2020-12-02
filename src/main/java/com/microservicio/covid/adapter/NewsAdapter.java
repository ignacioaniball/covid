package com.microservicio.covid.adapter;

import com.microservicio.covid.model.dto.NewsDTO;
import com.microservicio.covid.model.entity.NewsWrapper;

public interface NewsAdapter {

    NewsWrapper getNews(NewsDTO newsDTOd);

    NewsWrapper getNewsBySource(NewsDTO newsDto);

}

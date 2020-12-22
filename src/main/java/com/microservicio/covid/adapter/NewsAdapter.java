package com.microservicio.covid.adapter;

import com.microservicio.covid.model.entity.NewsWrapper;

import java.util.Date;

public interface NewsAdapter {

    NewsWrapper getNews(Date published);

    NewsWrapper getNewsBySource(String webSite);

}

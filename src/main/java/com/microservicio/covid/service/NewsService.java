package com.microservicio.covid.service;

import com.microservicio.covid.model.entity.News;

import java.util.List;

public interface NewsService {

    public List<News> findAll();

    public void save(News news);

    public News findOne(Long id);

    public void delete(Long id);
}

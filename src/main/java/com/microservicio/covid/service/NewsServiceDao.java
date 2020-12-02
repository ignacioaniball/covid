package com.microservicio.covid.service;

import com.microservicio.covid.model.entity.News;

import java.util.Date;
import java.util.List;

public interface NewsServiceDao {

    public List<News> findAll();

    public void save(News post);

    public News findOne(Long id);

    public void delete(Long id);

    List<News> findByPublished(Date published);

    List<News> findBySource(String source);
}

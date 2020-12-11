package com.microservicio.covid.service;

import com.microservicio.covid.model.entity.News;

import java.util.Date;
import java.util.List;

public interface NewsDao {

     List<News> findAll();

     void save(News post);

     News findOne(Long id);

     void delete(Long id);

    List<News> findByPublished(Date published);

    List<News> findBySource(String source);
}

package com.microservicio.covid.service;

import com.microservicio.covid.model.dao.NewsDao;
import com.microservicio.covid.model.entity.News;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class NewsServiceImpl implements NewsService{

    @Autowired
    private NewsDao newsDao;

    @Override
    public List<News> findAll() {
        return (List<News>) newsDao.findAll();
    }

    @Override
    public void save(News news) {

        newsDao.save(news);
    }

    @Override
    public News findOne(Long id) {
        return newsDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {

        newsDao.deleteById(id);
    }
}

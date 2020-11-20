package com.microservicio.covid.service;

import com.microservicio.covid.model.dao.NewsDao;
import com.microservicio.covid.model.dao.NewsJdbcDao;
import com.microservicio.covid.model.entity.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NewsServiceDaoImpl implements NewsServiceDao {

    @Autowired
    private NewsDao newsDao;

    @Autowired
    private NewsJdbcDao newsJdbcDao;

    @Override
    public List<News> findAll() {
        return (List<News>) newsDao.findAll();
    }

    @Override
    public void save(News post) {

        newsDao.save(post);
    }

    @Override
    public News findOne(Long id) {
        return newsDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {

        newsDao.deleteById(id);
    }

    @Override
    @Query
    public List<News> findByPublished(Date published) {
        return newsJdbcDao.findByDate(published);
    }
}

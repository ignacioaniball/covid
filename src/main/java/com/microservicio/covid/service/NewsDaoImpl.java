package com.microservicio.covid.service;

import com.microservicio.covid.model.dao.NewsDaoJdk;
import com.microservicio.covid.model.dao.NewsDaoJdbc;
import com.microservicio.covid.model.entity.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NewsDaoImpl implements NewsDao {

    @Autowired
    private NewsDaoJdk newsDao;

    @Autowired
    private NewsDaoJdbc newsJdbcDao;

    @Override
    public List<News> findAll() {
        return (List<News>) newsDao.findAll();
    }

    @Override
    public void save(News post) {

        newsDao.save(post);
    }

    @Override
    public void saveAll(List<News> newsList){
        newsDao.saveAll(newsList);
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

    @Override
    public List<News> findBySource(String source) {
        return newsJdbcDao.findBySource(source);
    }
}

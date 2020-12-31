package com.microservicio.covid.model.dao;

import com.microservicio.covid.model.entity.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository("jpa")
public class NewsDaoJpa implements NewsDao {

    @Autowired
    private NewsDaoJdk newsDao;

    @Autowired
    private NewsDaoJdbc newsDaoJdbc;

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
/*
    TODO Hay que realizar la implematación con JPA de los metodos findByPublished y findBySite porque estan llamando
    a la implementacion hecha en JDBC.
 */
    @Override
    @Query
    public List<News> findByPublished(Date published) {
        return newsDaoJdbc.findByDate(published);
    }

    @Override
    public List<News> findBySite(String site) {
        return newsDaoJdbc.findBySite(site);
    }
}

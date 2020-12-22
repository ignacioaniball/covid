package com.microservicio.covid.model.dao;

import com.microservicio.covid.model.entity.News;
import com.microservicio.covid.util.NewsMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository("jdbc")
public class NewsDaoJdbc implements NewsDao{

    @Autowired
    public JdbcTemplate jdbcTemplate;
    public static final Logger LOGGER = LoggerFactory.getLogger(NewsDaoJdbc.class);

    public List<News> findByDate(Date published) {
        if (published == null) {
            throw new NullPointerException("The published date can not be empty.");
        }
        String newsDateQuery = "SELECT * FROM news WHERE create_at = ?";
        List<News> newsList = jdbcTemplate.query(newsDateQuery, new NewsMapper(), published);
        LOGGER.info("The query executed was: {}\n", newsDateQuery);
        return newsList;
    }

    public List<News> findByWebSite(String webSite) {
        if (webSite.isEmpty()) {
            throw new NullPointerException("The webSite variable can not be empty.");
        }
        String newsSourceQuery = "SELECT * FROM news WHERE site_full = ? ";
        String findBySourceRequest = webSite.toLowerCase();
        List<News> newsBySource = jdbcTemplate.query(newsSourceQuery, new NewsMapper(), findBySourceRequest);
        LOGGER.info("The query executed was: {}\n", newsSourceQuery);
        return newsBySource;
    }

    @Override
    public List<News> findAll() {
        return null;
    }

    @Override
    public void save(News post) {

    }

    @Override
    public void saveAll(List<News> newsList) {

    }

    @Override
    public News findOne(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<News> findByPublished(Date published) {
        return null;
    }
}

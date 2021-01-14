package com.microservicio.covid.model.dao;

import com.microservicio.covid.model.entity.News;
import com.microservicio.covid.util.NewsMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

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

    public List<News> findBySite(String site) {
        if (StringUtils.isEmpty(site)) {
            throw new NullPointerException("The site variable can not be empty.");
        }
        String newsSiteQuery = "SELECT * FROM news WHERE site_full = ? ";
        String findBySiteRequest = site.toLowerCase();
        List<News> newsBySite = jdbcTemplate.query(newsSiteQuery, new NewsMapper(), findBySiteRequest);
        LOGGER.info("The query executed was: {}\n", newsSiteQuery);
        return newsBySite;
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

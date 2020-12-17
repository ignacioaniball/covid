package com.microservicio.covid.model.dao;

import com.microservicio.covid.model.entity.News;
import com.microservicio.covid.util.NewsMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NewsDaoJdbc {

    @Autowired
    public JdbcTemplate jdbcTemplate;
    public static final Logger LOGGER = LoggerFactory.getLogger(NewsDaoJdbc.class);

    public List<News> findByDate(Date published) {
        String newsDateQuery = "SELECT * FROM news WHERE create_at = ? ";
        String publishedDateRequest = published.toInstant().toString().split("T")[0];
        List<News> newsList = jdbcTemplate.query(newsDateQuery, new NewsMapper(), publishedDateRequest);
        LOGGER.info("The query executed was: {}\n", newsDateQuery);
        LOGGER.info("Obtain news with given source: {}", newsList);
        return newsList;
    }

    public List<News> findBySource(String source) {
        String newsSourceQuery = "SELECT * FROM news WHERE site_full = ? ";
        String findBySourceRequest = source.toLowerCase();
        List<News> newsBySource = jdbcTemplate.query(newsSourceQuery, new NewsMapper(), findBySourceRequest);
        LOGGER.info("The query executed was: {}\n", newsSourceQuery);
        LOGGER.info("Obtain news with given source: {}", newsBySource);
        return newsBySource;
    }
}

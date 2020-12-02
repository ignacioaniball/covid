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
public class NewsJdbcDao {

    private Logger LOGGER = LoggerFactory.getLogger(NewsJdbcDao.class);

    @Autowired
    public JdbcTemplate jdbcTemplate;

    public List<News> findByDate(Date published){
        String newsDateQuery = "SELECT * FROM midas.news WHERE create_at = ? ";
        LOGGER.info("The query executed was: {}\n",newsDateQuery );
        String publishedDateRequest = published.toInstant().toString().split("T")[0];
        List newsList = jdbcTemplate.query(newsDateQuery, new NewsMapper(), publishedDateRequest);
        LOGGER.info("Obtain news with given source: {}", newsList);
        return newsList;
    }

    public List<News> findBySource(String source){
        String newsSourceQuery = "SELECT * FROM midas.news WHERE site_full = ? ";
        LOGGER.info("The query executed was: {}\n",newsSourceQuery );
        String findBySourceRequest = source.toLowerCase();
        List newsBySource = jdbcTemplate.query(newsSourceQuery,new NewsMapper(), findBySourceRequest);
        LOGGER.info("Obtain news with given source: {}", newsBySource);
        return null;
    }
}

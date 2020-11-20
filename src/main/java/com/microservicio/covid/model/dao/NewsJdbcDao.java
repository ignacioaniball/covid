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
        String findByDate = "SELECT * FROM midas.news WHERE create_at = ? ";
        LOGGER.info("The query using is: {}",findByDate );
        String publishedDateRequest = published.toInstant().toString().split("T")[0];
        List newsList = jdbcTemplate.query(findByDate, new NewsMapper(), publishedDateRequest);
        return newsList;
    }
}

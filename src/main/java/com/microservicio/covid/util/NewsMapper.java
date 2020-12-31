package com.microservicio.covid.util;

import com.microservicio.covid.model.entity.News;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NewsMapper implements RowMapper<News> {

    private static final Logger LOGGER = LoggerFactory.getLogger(NewsMapper.class);

    @Override
    public News mapRow(ResultSet rs, int rowNum) throws SQLException {
        try {
            News news = new News();
            news.setId(rs.getInt("id"));
            news.setPublished(rs.getDate("create_at"));
            news.setLanguage(rs.getString("language"));
            //news.setNewsDetail(rs.getObject("news_detail_id", NewsDetail.class));
            return news;
        } catch (SQLException e) {
            LOGGER.error("Can be Mapper the news. ", e.getCause());
            throw e;
        }
    }
}

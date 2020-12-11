package com.microservicio.covid.util;

import com.microservicio.covid.model.entity.News;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NewsMapper implements RowMapper<News> {

    @Override
    public News mapRow(ResultSet rs, int rowNum) throws SQLException {
        News news = new News();
        news.setId(rs.getInt("id"));
        news.setPublished(rs.getDate("create_at"));
        news.setAuthor(rs.getString("news_author"));
        news.setTitle(rs.getString("news_title"));
        news.setUrl(rs.getString("news_url"));
        news.setUuid(rs.getString("news_uuid"));
        //news.(rs.getString("site_full"));
        return news;
    }
}

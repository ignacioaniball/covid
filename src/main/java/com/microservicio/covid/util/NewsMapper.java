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
        news.setAuthor(rs.getString("author"));
        news.setTitle(rs.getString("title"));
        news.setUrl(rs.getString("url"));
        news.setUuid(rs.getString("uuid"));
        return news;
    }
}

package com.microservicio.covid.adapter;

import com.microservicio.covid.model.dto.NewsDTO;
import com.microservicio.covid.model.entity.News;

public interface WebhoseAdapter {

    News getNews(NewsDTO newsDTO);
}

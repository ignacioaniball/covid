package com.microservicio.covid.model.dao;

import com.microservicio.covid.model.entity.News;
import org.springframework.data.repository.CrudRepository;

public interface NewsDaoJdk extends CrudRepository<News, Long> {

}

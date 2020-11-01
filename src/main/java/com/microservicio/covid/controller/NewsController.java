package com.microservicio.covid.controller;

import com.microservicio.covid.model.entity.BunchesNew;
import com.microservicio.covid.model.entity.News;
import com.microservicio.covid.service.NewsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class NewsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(NewsController.class);

    @Autowired
    private NewsService newsService;

    @GetMapping(value = "/news", produces = "application/json")
    @ApiOperation(value = "Retrieve News information from provider.",
            notes = "News form Argentinian country.", response = News.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
    public ResponseEntity getNews(BunchesNew bunchesNew){

        return new ResponseEntity(HttpStatus.OK);
    }

}

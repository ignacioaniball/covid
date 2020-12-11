package com.microservicio.covid.controller;

import com.microservicio.covid.model.dto.NewsDTO;
import com.microservicio.covid.model.entity.News;
import com.microservicio.covid.model.entity.NewsWrapper;
import com.microservicio.covid.service.NewsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class NewsController {

    public NewsWrapper newsWrapper = new NewsWrapper();
    private static final Logger LOGGER = LoggerFactory.getLogger(NewsController.class);
    @Autowired
    private NewsService service;

    @GetMapping(value = "/news", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Retrieve News information from provider.",
            notes = "News form Argentinian country.", response = News.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
    public ResponseEntity getNews(
            @ApiParam(name = "published", value = "Date published of news.", required = true) @RequestParam(required = true) String published) throws Exception {
            newsWrapper = service.getNewsWrapperData(published);
            return new ResponseEntity<>(newsWrapper, HttpStatus.OK);
    }

    @GetMapping(value = "/news/filter/source", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Retrieve News information from provider with the filter sending",
            notes = "News from Argentinian country.", response = News.class)
    public ResponseEntity getNewsFilter(
            @ApiParam(name = "source", value = "source of news.", required = true) @RequestParam(required = true) String source,
            @ApiParam(name = "title", value = "title of news.", required = false) @RequestParam(required = false) String title,
            @ApiParam(name = "published", value = "Date published of news.", required = false) @RequestParam(required = false) String published) {
        try {
            NewsDTO newsDTO = new NewsDTO();
            newsDTO.setSite(source);
            newsWrapper = service.getNewsBySource(newsDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(newsWrapper, HttpStatus.OK);
    }

}

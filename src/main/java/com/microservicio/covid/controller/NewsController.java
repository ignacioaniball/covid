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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

@RestController
@RequestMapping("/v1")
public class NewsController {

    public Logger LOGGER = LoggerFactory.getLogger(NewsController.class);
    private String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
    @Autowired
    private NewsService service;

    @GetMapping(value = "/news", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Retrieve News information from provider.",
            notes = "News form Argentinian country.", response = News.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
    public ResponseEntity getNews(
            @ApiParam(name = "published", value = "Date published of news.", required = true) @RequestParam(required = true) String published) throws Exception {

        NewsWrapper weatherInformation;

        try {
            DateFormat format = new SimpleDateFormat(DATE_FORMAT, Locale.UK);
            format.setTimeZone(TimeZone.getTimeZone("Africa/Addis_Ababa"));
            NewsDTO newsDTO = new NewsDTO();
            newsDTO.setPublished(format.parse(String.valueOf(published)));
            weatherInformation = service.getNewsWrapperData(newsDTO);
            return new ResponseEntity<>(weatherInformation, HttpStatus.OK);
        } catch (ParseException  e) {
            LOGGER.error("Error parsing {} variable.", published);
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);

        } catch (NullPointerException e) {
            LOGGER.error("The variable {} can not be null", published);
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch ( IllegalArgumentException e) {
            LOGGER.error("The variable {} can not be null", published);
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

package com.microservicio.covid.model.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "news")
public class News implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    @Column(name = "news_uuid")
    private String uuid;

    @NotEmpty
    @Column(name = "news_url")
    private String url;

    @NotEmpty
    @Column(name = "news_title")
    private String title;

    @NotEmpty
    @Column(name = "news_content")
    private String text;

    @NotEmpty
    @Column(name = "news_author")
    private String author;

    @NotEmpty
    @Column
    private String site;

    @NotNull
    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date published;

    private static final long serialVersionUID = 1L;
}

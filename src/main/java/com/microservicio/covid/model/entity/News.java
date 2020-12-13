package com.microservicio.covid.model.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "news")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "uuid",
        "url",
        "thread",
        "parent_url",
        "author",
        "published",
        "title",
        "text",
        "language"
})
public class News implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    @Column(name = "uuid")
    @JsonProperty("news_uuid")
    private String uuid;

    @NotEmpty
    @Column(name = "url")
    @JsonProperty("news_url")
    private String url;

    @NotEmpty
    @OneToOne(cascade = {CascadeType.ALL})
    @JsonProperty("thread")
    private NewsDetail newsDetail;

    @NotEmpty
    @Column(name = "title")
    @JsonProperty("news_title")
    private String title;

    @NotEmpty
    @Column(name = "author")
    @JsonProperty("news_author")
    private String author;

    @NotEmpty
    @Column
    @JsonProperty("language")
    private String language;

    @NotNull
    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonProperty("published")
    private Date published;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublished() {
        return published;
    }

    public void setPublished(Date published) {
        this.published = published;
    }

    public NewsDetail getNewsDetail() {
        return newsDetail;
    }

    public void setNewsDetail(NewsDetail newsDetail) {
        this.newsDetail = newsDetail;
    }
}

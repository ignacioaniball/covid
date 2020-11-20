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
        "parent_url",
        "author",
        "published",
        "title",
        "text",
        "language"
})
public class News implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    @Column(name = "news_uuid")
    @JsonProperty("news_uuid")
    private String uuid;

    @NotEmpty
    @Column(name = "news_url")
    @JsonProperty("news_url")
    private String url;

    @NotEmpty
    @Column(name = "news_title")
    @JsonProperty("news_title")
    private String title;

    @NotEmpty
    @Column(name = "news_author")
    @JsonProperty("news_author")
    private String author;

    @NotEmpty
    @Column
    private String site;

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

    private static final long serialVersionUID = 1L;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @JsonProperty("uuid")
    public String getUuid() {
        return uuid;
    }

    @JsonProperty("uuid")
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("author")
    public String getAuthor() {
        return author;
    }

    @JsonProperty("author")
    public void setAuthor(String author) {
        this.author = author;
    }

    @JsonProperty("site")
    public String getSite() {
        return site;
    }

    @JsonProperty("site")
    public void setSite(String site) {
        this.site = site;
    }

    @JsonProperty("published")
    public Date getPublished() {
        return published;
    }

    @JsonProperty("published")
    public void setPublished(Date published) {
        this.published = published;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}

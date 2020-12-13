package com.microservicio.covid.model.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "uuid",
        "url",
        "site_full",
        "site",
        "site_section",
        "site_categories",
        "section_title",
        "title",
        "title_full",
        "published",
        "replies_count",
        "participants_count",
        "site_type",
        "country",
        "spam_score",
        "main_image",
        "performance_score",
        "domain_rank",
        "social"
})
@Entity
@Table(name = "news_detail")
public class NewsDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @JsonProperty("uuid")
    private String uuid;

    @JsonProperty("url")
    private String url;

    @NotEmpty
    @Column(name = "source")
    @JsonProperty("site_full")
    private String siteFull;

    @JsonProperty("site")
    private String site;

    @JsonProperty("site_section")
    private String siteSection;

    @JsonProperty("section_title")
    private String sectionTitle;

    @JsonProperty("title")
    private String title;

    @JsonProperty("title_full")
    private String titleFull;

    @JsonProperty("published")
    private String published;

    @JsonProperty("replies_count")
    private Integer repliesCount;

    @JsonProperty("participants_count")
    private Integer participantsCount;

    @JsonProperty("site_type")
    private String siteType;

    @JsonProperty("country")
    private String country;

    @JsonProperty("spam_score")
    private Double spamScore;

    @JsonProperty("main_image")
    private String mainImage;

    @JsonProperty("performance_score")
    private Integer performanceScore;

    @JsonProperty("domain_rank")
    private Integer domainRank;

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public String getSiteFull() {
        return siteFull;
    }

    public void setSiteFull(String siteFull) {
        this.siteFull = siteFull;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getSiteSection() {
        return siteSection;
    }

    public void setSiteSection(String siteSection) {
        this.siteSection = siteSection;
    }

    public String getSectionTitle() {
        return sectionTitle;
    }

    public void setSectionTitle(String sectionTitle) {
        this.sectionTitle = sectionTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleFull() {
        return titleFull;
    }

    public void setTitleFull(String titleFull) {
        this.titleFull = titleFull;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public Integer getRepliesCount() {
        return repliesCount;
    }

    public void setRepliesCount(Integer repliesCount) {
        this.repliesCount = repliesCount;
    }

    public Integer getParticipantsCount() {
        return participantsCount;
    }

    public void setParticipantsCount(Integer participantsCount) {
        this.participantsCount = participantsCount;
    }

    public String getSiteType() {
        return siteType;
    }

    public void setSiteType(String siteType) {
        this.siteType = siteType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getSpamScore() {
        return spamScore;
    }

    public void setSpamScore(Double spamScore) {
        this.spamScore = spamScore;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public Integer getPerformanceScore() {
        return performanceScore;
    }

    public void setPerformanceScore(Integer performanceScore) {
        this.performanceScore = performanceScore;
    }

    public Integer getDomainRank() {
        return domainRank;
    }

    public void setDomainRank(Integer domainRank) {
        this.domainRank = domainRank;
    }

}

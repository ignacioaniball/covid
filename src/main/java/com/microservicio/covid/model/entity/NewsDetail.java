
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

    private static final long serialVersionUID = 1L;

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

    @JsonProperty("site_full")
    public String getSiteFull() {
        return siteFull;
    }

    @JsonProperty("site_full")
    public void setSiteFull(String siteFull) {
        this.siteFull = siteFull;
    }

    @JsonProperty("site")
    public String getSite() {
        return site;
    }

    @JsonProperty("site")
    public void setSite(String site) {
        this.site = site;
    }

    @JsonProperty("site_section")
    public String getSiteSection() {
        return siteSection;
    }

    @JsonProperty("site_section")
    public void setSiteSection(String siteSection) {
        this.siteSection = siteSection;
    }

    @JsonProperty("section_title")
    public String getSectionTitle() {
        return sectionTitle;
    }

    @JsonProperty("section_title")
    public void setSectionTitle(String sectionTitle) {
        this.sectionTitle = sectionTitle;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("title_full")
    public String getTitleFull() {
        return titleFull;
    }

    @JsonProperty("title_full")
    public void setTitleFull(String titleFull) {
        this.titleFull = titleFull;
    }

    @JsonProperty("published")
    public String getPublished() {
        return published;
    }

    @JsonProperty("published")
    public void setPublished(String published) {
        this.published = published;
    }

    @JsonProperty("replies_count")
    public Integer getRepliesCount() {
        return repliesCount;
    }

    @JsonProperty("replies_count")
    public void setRepliesCount(Integer repliesCount) {
        this.repliesCount = repliesCount;
    }

    @JsonProperty("participants_count")
    public Integer getParticipantsCount() {
        return participantsCount;
    }

    @JsonProperty("participants_count")
    public void setParticipantsCount(Integer participantsCount) {
        this.participantsCount = participantsCount;
    }

    @JsonProperty("site_type")
    public String getSiteType() {
        return siteType;
    }

    @JsonProperty("site_type")
    public void setSiteType(String siteType) {
        this.siteType = siteType;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("spam_score")
    public Double getSpamScore() {
        return spamScore;
    }

    @JsonProperty("spam_score")
    public void setSpamScore(Double spamScore) {
        this.spamScore = spamScore;
    }

    @JsonProperty("main_image")
    public String getMainImage() {
        return mainImage;
    }

    @JsonProperty("main_image")
    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    @JsonProperty("performance_score")
    public Integer getPerformanceScore() {
        return performanceScore;
    }

    @JsonProperty("performance_score")
    public void setPerformanceScore(Integer performanceScore) {
        this.performanceScore = performanceScore;
    }

    @JsonProperty("domain_rank")
    public Integer getDomainRank() {
        return domainRank;
    }

    @JsonProperty("domain_rank")
    public void setDomainRank(Integer domainRank) {
        this.domainRank = domainRank;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

}

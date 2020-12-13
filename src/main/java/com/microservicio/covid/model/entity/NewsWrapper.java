package com.microservicio.covid.model.entity;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "posts"
})
public class NewsWrapper {

    @JsonProperty("posts")
    private List<News> news;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("posts")
    public List<News> getPosts() {
        return news;
    }

    @JsonProperty("posts")
    public void setPosts(List<News> news) {
        this.news = news;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

package com.microservicio.covid.unitTest;

import com.microservicio.covid.adapter.NewsAdapterImpl;
import com.microservicio.covid.model.dao.NewsDaoJpa;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@ExtendWith({MockitoExtension.class})
@ContextConfiguration(classes = NewsAdapterImpl.class)
@TestPropertySource(locations ="classpath:tests.properties")
public class NewsAdapterImplTest {

    @Value("${news.default.url}")
    private String newsApiUrl;

    @InjectMocks
    NewsAdapterImpl newsAdapter = new NewsAdapterImpl();

    @Mock
    NewsDaoJpa newsDaoJpa;

    @Test
    @Disabled
    void getNewsWithValidValueReturnNewsTest() {
        Date actualDate = Date.from(Instant.now());
        List listNews = null;
        Mockito.when(newsDaoJpa.findByPublished(actualDate)).thenReturn(listNews);
        newsAdapter.getNews(actualDate);
    }
}

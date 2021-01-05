package com.microservicio.covid.unitTest;

import com.microservicio.covid.adapter.NewsAdapterImpl;
import com.microservicio.covid.model.dao.NewsDaoJpa;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.Instant;
import java.util.Date;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestPropertySource(locations ="classpath:newsAdapterImplTest.properties")
@ActiveProfiles("Test")
public class NewsAdapterImplTest {

    @Autowired
    @InjectMocks
    NewsAdapterImpl newsAdapter;

    @Mock
    NewsDaoJpa newsDaoJpa;

    @Test
    @Disabled
    void getNewsWithValidValueReturnNewsTest() {
        Date actualDate = Date.from(Instant.now());
        Mockito.when(newsDaoJpa.findByPublished(actualDate)).thenReturn(null);
        Mockito.when(newsAdapter.getNews(actualDate)).thenReturn(null);
        newsAdapter.getNews(actualDate);
    }
}

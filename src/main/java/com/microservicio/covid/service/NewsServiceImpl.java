package com.microservicio.covid.service;

import com.microservicio.covid.adapter.AdapterFactory;
import com.microservicio.covid.adapter.NewsAdapter;
import com.microservicio.covid.model.entity.NewsWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Service
public class NewsServiceImpl implements NewsService {

    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final Logger LOGGER = LoggerFactory.getLogger(NewsServiceImpl.class);
    private NewsAdapter adapter;
    @Value("${news.default.adapter}")
    private String defaultAdapter;
    @Autowired
    private AdapterFactory adapterFactory;

    @Override
    public NewsWrapper getNewsWrapperData(String published) {
        initAdapter();
        LOGGER.info("Get news service. Default adapter: {}.", defaultAdapter);
        return adapter.getNews(publishedParse(published));
    }

    @Override
    public NewsWrapper getNewsBySite(String site){
        initAdapter();
        LOGGER.info("Obtaining news information for a given site: {}.", site);
        return adapter.getNewsBySite(site);
    }

    private void initAdapter(){
        try {
            if (adapter == null) {
                adapter = adapterFactory.getAdapter(defaultAdapter);
            }
        } catch (NullPointerException e) {
            LOGGER.error("Adapter variable is Empty.");
        }
    }

    private Date publishedParse(String published) {
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT, Locale.getDefault());
        Date publishedParse = null;
        try {
            if (StringUtils.isEmpty(published)){
                throw new NullPointerException("The published date can not be empty.");
            }
            publishedParse = format.parse(String.valueOf(published));
        } catch (ParseException e) {
            LOGGER.error("Error parsing {} variable.", published);
        } catch (NullPointerException e) {
            LOGGER.error("The variable {} can not be null", published);
        }
        return publishedParse;
    }
}


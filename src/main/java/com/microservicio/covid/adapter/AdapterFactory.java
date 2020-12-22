package com.microservicio.covid.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class AdapterFactory {

    @Autowired
    @Qualifier("web_hose_adapter")
    private NewsAdapter newsAdapter;

    public NewsAdapter getAdapter(String adapterName) {
        NewsAdapterEnum newsAdapterEnum = NewsAdapterEnum.valueOf(adapterName.toUpperCase(Locale.getDefault()));
        if (newsAdapterEnum.name().equalsIgnoreCase("WEB_HOSE_ADAPTER")) {
            return newsAdapter;
        } else
            throw new NullPointerException("Error to obtaining adapter, adapter name should not be null.");
    }
}


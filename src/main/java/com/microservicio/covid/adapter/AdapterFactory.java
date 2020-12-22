package com.microservicio.covid.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class AdapterFactory {

    @Autowired
    @Qualifier("web_hose_adapter")
    private NewsAdapter newsAdapter;

    public NewsAdapter getAdapter(String adapterName) {
        if (NewsAdapterEnum.WEB_HOSE_ADAPTER.name().equalsIgnoreCase(adapterName)) {
            return newsAdapter;
        } else
            throw new NullPointerException("Error to obtain adapter, adapter name should not be null.");
    }
}


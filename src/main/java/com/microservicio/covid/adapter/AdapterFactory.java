package com.microservicio.covid.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class AdapterFactory {

    @Autowired
    @Qualifier("web_hose_adapter")
    private NewsAdapter newsAdapter;

    public NewsAdapter getAdapter(String adapterName) {
        NewsAdapterEnum newsAdapterEnum = NewsAdapterEnum.valueOf(adapterName.toUpperCase(Locale.getDefault()));
        switch(newsAdapterEnum){
            case WEB_HOSE_ADAPTER:
                return newsAdapter;

            default:
                throw new NullPointerException("Error to obtaining adapter, adapter name should not be null.");

        }
    }
}

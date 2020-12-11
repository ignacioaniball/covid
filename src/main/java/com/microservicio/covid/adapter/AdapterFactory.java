package com.microservicio.covid.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class AdapterFactory {

    @Autowired
    @Qualifier("webhoseAdapter")
    public NewsAdapter newsAdapter;

    public NewsAdapter getAdapter(String adapterName) throws Exception {
        NewsAdapterEnum newsAdapterEnum = NewsAdapterEnum.valueOf(adapterName.toUpperCase(Locale.getDefault()));
        switch (newsAdapterEnum) {
            case WEBHOSEADAPTER:
                return newsAdapter;

            default:
                throw new Exception("Error to obtaining adapter, adapter name should not be null.");

        }
    }
}

package com.microservicio.covid.unitTest;

import com.microservicio.covid.adapter.AdapterFactory;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertThrows;

class AdapterFactoryTest {

    @InjectMocks
    @Autowired
    private AdapterFactory adapterFactory;

    @Test
    void testGetAdapterWithValidAdapter() {
        adapterFactory.getAdapter("WEB_HOSE_ADAPTER");
    }

    @Test
    void testGetAdapterWithNullArgument() {
        Exception exception = assertThrows(NullPointerException.class, () ->
                adapterFactory.getAdapter(null));
        exception.getMessage();
    }

    @Test
    void testGetAdapterWithInvalidArgument() {
        Exception exception = assertThrows(NullPointerException.class, () ->
                adapterFactory.getAdapter("Invalid_Adapter"));
    }
}

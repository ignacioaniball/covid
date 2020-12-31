package com.microservicio.covid.unitTest;

import com.microservicio.covid.adapter.AdapterFactory;
import com.microservicio.covid.adapter.NewsAdapter;
import com.microservicio.covid.adapter.NewsAdapterImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class AdapterFactoryTest {

    //Al usar @InjectMocks, mockito se encarga de instanciar el AdapterFactory, por lo que no hay que usar new.
    //Tambien injecta las variables anotadas con @Mock.
    @InjectMocks
    private AdapterFactory adapterFactory;

    @Mock
    private NewsAdapterImpl adapter;

//    Esta forma de inicializar los @Mock para luego ser injectados por @InjectMock funciona tanto para junit4/5.
//   @BeforeEach
//    public void init() {
//        MockitoAnnotations.initMocks(this);
//    }

    @Test
    void testGetAdapterWithValidArgumentShouldReturnAdapterTest() {
        NewsAdapter newsAdapter = adapterFactory.getAdapter("WEB_HOSE_ADAPTER");
        assertNotNull(newsAdapter);
    }

    @Test
    void testGetAdapterWithNullArgumentShouldThrowExceptionTest() {
        Exception exception = assertThrows(NullPointerException.class, () ->
                adapterFactory.getAdapter(null));
        assertNotNull(adapterFactory);
        assertEquals("Error to obtain adapter, adapter name should not be null.", exception.getMessage() );
    }

    @Test
    void testGetAdapterWithInvalidArgumentShouldThrowExceptionTest() {
        Exception exception = assertThrows(NullPointerException.class, () ->
                adapterFactory.getAdapter("Invalid_Adapter"));
        assertNotNull(adapterFactory);
        assertEquals("Error to obtain adapter, adapter name should not be null.", exception.getMessage() );
    }
}

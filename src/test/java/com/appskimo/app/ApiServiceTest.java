package com.appskimo.app;

import com.appskimo.app.service.ApiService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.request.async.DeferredResult;

import javax.inject.Inject;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static org.junit.Assert.assertNotNull;

//import static org.hamcrest.CoreMatchers.is;

//import static org.junit.Assert.assertThat;
//import static org.junit.Assert.assertTrue;
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertEquals;

@Slf4j
@ContextConfiguration(locations = "/test-api-service.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ApiServiceTest {

    @Inject private ApiService apiService;

    @Before
    public void setup() {
        assertNotNull(apiService);
    }

    @Test
    public void test() {
        CompletableFuture<Map.Entry<String, String>> data1 = apiService.getSampleData1();
        DeferredResult<Map.Entry<String, String>> data2 = apiService.getSampleData2();

        try {
            display(data1.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

        display(data2.getResult());
    }

    private void display(Object obj) {
        log.info("\n{}", obj.toString());
    }

}

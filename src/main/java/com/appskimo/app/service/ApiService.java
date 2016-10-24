package com.appskimo.app.service;

import org.springframework.web.context.request.async.DeferredResult;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Created by dominic.lee on 2016. 10. 18..
 */
public interface ApiService {

    Object findData();

    CompletableFuture<Map.Entry<String, String>> getSampleData1();

    DeferredResult<Map.Entry<String, String>> getSampleData2();

}

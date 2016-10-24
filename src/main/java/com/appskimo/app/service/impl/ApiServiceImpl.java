package com.appskimo.app.service.impl;

import com.appskimo.app.annotation.AspectTestAnnotation;
import com.appskimo.app.service.ApiService;
import com.google.common.collect.Maps;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Created by dominic.lee on 2016. 10. 18..
 */
@Component
public class ApiServiceImpl implements ApiService {

    @Override
    @AspectTestAnnotation(isNotIgnore = false)
    public Map.Entry<String, String> findData() {
        return Maps.immutableEntry("data", "sample");
    }

    @Override
    @AspectTestAnnotation
    public CompletableFuture<Map.Entry<String, String>> getSampleData1() {
        return CompletableFuture.supplyAsync(() -> findData());
    }

    @Override
    @SneakyThrows
    public DeferredResult<Map.Entry<String, String>> getSampleData2() {
        DeferredResult<Map.Entry<String, String>> result = new DeferredResult<>();
        getSampleData1().whenComplete((res, ex) -> {
            if(ex != null) {
                result.setErrorResult(ex);
            }
            result.setResult(res);
        });

        return result;
    }

}

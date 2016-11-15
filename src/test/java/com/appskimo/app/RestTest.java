package com.appskimo.app;

import com.appskimo.app.domain.SampleData;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.inject.Inject;

/**
 * Created by dominic.lee on 2016. 11. 15..
 */
@Slf4j
@ContextConfiguration(locations = "/test-rest.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class RestTest {

    @Inject
    private RestTemplate restTemplate;

    @Before
    public void before() {
        Assert.assertNotNull(restTemplate);
    }

    @Test
    public void testUriComponents() {
        UriComponents uriComponents = UriComponentsBuilder.fromUriString("http://localhost:8080/api?lang=kr&type=temp").build();

        log.info("{}", uriComponents.toUriString());
        log.info("{}", uriComponents.getHost());
        log.info("{}", uriComponents.getPort());
        log.info("{}", uriComponents.getPath());
        log.info("{}", uriComponents.getQueryParams());

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("lang", "kr");
        params.add("type", "temp");
        UriComponents uriComponents2 = UriComponentsBuilder.newInstance().scheme("http").host("localhost").port(8080).path("/api").queryParams(params).build();

        log.info("{}", uriComponents2.toUriString());
        log.info("{}", uriComponents2.getHost());
        log.info("{}", uriComponents2.getPort());
        log.info("{}", uriComponents2.getPath());
        log.info("{}", uriComponents2.getQueryParams());

        Assert.assertEquals("toUriString()", uriComponents.toUriString(), uriComponents2.toUriString());
        Assert.assertEquals("getHost()", uriComponents.getHost(), uriComponents2.getHost());
        Assert.assertEquals("getPort()", uriComponents.getPort(), uriComponents2.getPort());
        Assert.assertEquals("getPath()", uriComponents.getPath(), uriComponents2.getPath());
        Assert.assertEquals("getQueryParams()", uriComponents.getQueryParams(), uriComponents2.getQueryParams());
    }

    @Test
    public void testRest() {
        UriComponents uriComponents = UriComponentsBuilder.fromUriString("http://localhost:8080/api/sample1").build();
        ResponseEntity<SampleData> responseEntity = restTemplate.getForEntity(uriComponents.toUri(), SampleData.class);

        log.info("statusCode: {}", responseEntity.getStatusCode());

        HttpHeaders headers = responseEntity.getHeaders();
        log.info("{}", headers.getAccept());
        log.info("{}", headers.getContentType());

        SampleData sampleData = responseEntity.getBody();
        log.info("{}", sampleData);
        log.info("{}", sampleData.getData());
    }

}

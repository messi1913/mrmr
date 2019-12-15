package com.ddastudio.mrmr.util;

import java.util.Optional;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import static java.util.Optional.ofNullable;

@Component
public class CommonUtils implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext( ApplicationContext context) throws BeansException {
        applicationContext = context;
    }

    public static <T> Optional<T> getBeanAsOptional(Class<T> tClass) {
        return ofNullable(getBean(tClass));
    }

    public static <T> T getBean(Class<T> tClass) {
        if (applicationContext == null) {
            return null;
        }

        return applicationContext.getBean(tClass);
    }

    public static <T> T getBean(String name, Class<T> tClass) {
        return applicationContext.getBean(name, tClass);
    }

    public static String executeHttpMethod(HttpMethod httpMethod, String url, MultiValueMap<String, String> headers, String body) throws Exception {
        RestTemplate restTemplate = getBean(RestTemplate.class);
        HttpHeaders httpHeaders = new HttpHeaders(headers);
        HttpEntity httpEntity = new HttpEntity(body, httpHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, httpMethod, httpEntity, String.class);
        HttpStatus statusCode = responseEntity.getStatusCode();
        if(statusCode.is2xxSuccessful()) {
            return responseEntity.getBody();
        }
        throw new Exception("");
    }

}

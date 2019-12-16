package com.ddastudio.mrmr.config;

import com.ddastudio.mrmr.measure.model.*;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

/**
 * @author messi1913@gmail.com
 * @Github http://github.com/messi1913
 * @since 2019/11/27
 */
@Configuration
public class BeanConfig {

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.createTypeMap(Bmi.class, MeasureDTO.class)
                .addMappings(mapping -> {  // 한번에 여러개 매핑.
                    mapping.map(source -> source.getId().getPublishYear(), MeasureDTO::setPublishYear);
                    mapping.map(source -> source.getId().getAge(), MeasureDTO::setAge);
                    mapping.map(source -> source.getId().getGender(), MeasureDTO::setGender);
                    mapping.map(source -> source.getId().getMonth(), MeasureDTO::setMonth);
                });
        modelMapper.createTypeMap(Height.class, MeasureDTO.class)
                .addMappings(mapping -> {  // 한번에 여러개 매핑.
                    mapping.map(source -> source.getId().getPublishYear(), MeasureDTO::setPublishYear);
                    mapping.map(source -> source.getId().getAge(), MeasureDTO::setAge);
                    mapping.map(source -> source.getId().getGender(), MeasureDTO::setGender);
                    mapping.map(source -> source.getId().getMonth(), MeasureDTO::setMonth);
                });
        modelMapper.createTypeMap(Weight.class, MeasureDTO.class)
                .addMappings(mapping -> {  // 한번에 여러개 매핑.
                    mapping.map(source -> source.getId().getPublishYear(), MeasureDTO::setPublishYear);
                    mapping.map(source -> source.getId().getAge(), MeasureDTO::setAge);
                    mapping.map(source -> source.getId().getGender(), MeasureDTO::setGender);
                    mapping.map(source -> source.getId().getMonth(), MeasureDTO::setMonth);
                });
        modelMapper.createTypeMap(HeadCircumference.class, MeasureDTO.class)
                .addMappings(mapping -> {  // 한번에 여러개 매핑.
                    mapping.map(source -> source.getId().getPublishYear(), MeasureDTO::setPublishYear);
                    mapping.map(source -> source.getId().getAge(), MeasureDTO::setAge);
                    mapping.map(source -> source.getId().getGender(), MeasureDTO::setGender);
                    mapping.map(source -> source.getId().getMonth(), MeasureDTO::setMonth);
                });
        modelMapper.createTypeMap(WeightByHeight.class, MeasureDTO.class)
                .addMappings(mapping -> {  // 한번에 여러개 매핑.
                    mapping.map(source -> source.getId().getPublishYear(), MeasureDTO::setPublishYear);
                    mapping.map(source -> source.getId().getGender(), MeasureDTO::setGender);
                    mapping.map(source -> source.getId().getFromMonth(), MeasureDTO::setFromMonth);
                    mapping.map(source -> source.getId().getToMonth(), MeasureDTO::setToMonth);
                    mapping.map(source -> source.getId().getHeight(), MeasureDTO::setHeight);
                });
        return modelMapper;
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Bean
    public JPAQueryFactory jpaQueryFactory() {
        return new JPAQueryFactory(entityManager);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public RestTemplate restTemplate()  throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
        TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;

        SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom()
                .loadTrustMaterial(null, acceptingTrustStrategy)
                .build();

        CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLSocketFactory(new SSLConnectionSocketFactory(sslContext))
                .build();

        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(httpClient);
        return new RestTemplate(requestFactory);
    }
}


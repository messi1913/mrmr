package com.ddastudio.mrmr.config;

import com.ddastudio.mrmr.measure.model.*;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
}


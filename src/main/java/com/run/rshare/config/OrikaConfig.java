package com.run.rshare.config;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName OrikaConfig
 * @Description: 用于entity ->vo的转换
 * @Author xsd
 * @Date 2023/8/31
 * @Version V1.0
 **/
@Configuration
public class OrikaConfig {

    @Bean
    public MapperFactory mapperFactory() {
        return new DefaultMapperFactory.Builder().build();
    }

    @Bean
    public MapperFacade mapperFacade() {
        return mapperFactory().getMapperFacade();
    }
}

package com.run.rshare;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Properties;

@MapperScan("com.run.rshare.dao")
@SpringBootApplication
public class RShareCommonApplication {

    public static void main(String[] args) {
        Properties properties = System.getProperties();
        properties.setProperty("druid.mysql.usePingMethod", "false");
        SpringApplication.run(RShareCommonApplication.class, args);
    }

}

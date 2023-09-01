package com.run.rshare;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.run.rshare.dao")
@SpringBootApplication
public class RShareCommonApplication {

    public static void main(String[] args) {
        SpringApplication.run(RShareCommonApplication.class, args);
    }

}

package com.allen.sb_01_mybatisplus.config.a.b;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {


    @Bean
    public String StringBean() {
        return "outer class inject";
    }
}

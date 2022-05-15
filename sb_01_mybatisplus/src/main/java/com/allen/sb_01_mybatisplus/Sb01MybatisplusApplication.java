package com.allen.sb_01_mybatisplus;

import com.allen.sb_01_mybatisplus.bean.BookCase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Sb01MybatisplusApplication {

    public static void main(String[] args) {
//        System.setProperty("spring.devtools.restart.enabled", "false");
        ConfigurableApplicationContext context = SpringApplication.run(Sb01MybatisplusApplication.class, args);
        BookCase BookCase = context.getBean(BookCase.class);
        System.out.println(BookCase);
    }

}

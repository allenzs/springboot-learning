package com.allen.sb_01_mybatisplus;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Sb01MybatisplusApplicationTests {

    @Autowired
    private String StringBean;

    @Test
    void contextLoads() {
        System.out.println(StringBean);
    }

}

package com.allen.sb_00_demo;

import com.allen.sb_00_demo.dao.BootDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Sb00DemoApplicationTests {

    @Autowired
    private BootDao bootDao;


    @Test
    void contextLoads() {
        bootDao.save();
    }

}

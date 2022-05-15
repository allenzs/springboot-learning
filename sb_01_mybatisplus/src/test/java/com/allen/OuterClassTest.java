package com.allen;

import com.allen.sb_01_mybatisplus.Sb01MybatisplusApplication;
import com.allen.sb_01_mybatisplus.config.a.b.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest(classes = Sb01MybatisplusApplication.class)
@Import({TestConfig.class})
public class OuterClassTest {

    @Autowired
    private String StringBean;

    @Test
    void testConfiguration() {
        System.out.println(StringBean);
    }
}

package com.allen.sb_01_mybatisplus.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "testcase.book")
@Data
public class BookCase {
    private int id;
    private String name;
    private String uuid;
    private long publishTime;

}

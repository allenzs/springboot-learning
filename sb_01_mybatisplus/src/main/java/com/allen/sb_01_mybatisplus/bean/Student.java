package com.allen.sb_01_mybatisplus.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "of")
public class Student {
    private int id;
    private String name;
    private int age;
}

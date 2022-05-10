package com.allen.sb_00_demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author allen
 * @create 2022/5/10 17:47
 */
@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class User  {
    private String name;
    private int age;
    private String sex;
}

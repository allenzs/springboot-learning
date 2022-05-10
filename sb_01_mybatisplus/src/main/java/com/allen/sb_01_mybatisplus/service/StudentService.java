package com.allen.sb_01_mybatisplus.service;

import com.allen.sb_01_mybatisplus.bean.Student;
import com.baomidou.mybatisplus.extension.service.IService;


public interface StudentService extends IService<Student> {

    boolean delete(Integer id);
}

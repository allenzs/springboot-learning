package com.allen.sb_01_mybatisplus.service;

import com.allen.sb_01_mybatisplus.Sb01MybatisplusApplication;
import com.allen.sb_01_mybatisplus.bean.Student;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = Sb01MybatisplusApplication.class)
class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void getByIdTest(){
        Student student = studentService.getById(1);
        System.out.println(student);
    }

    @Test
    public void deleteTest(){
        boolean b = studentService.removeById(1);
        System.out.println(b);
    }
    
    @Test
    public void getAllTest(){
        List<Student> students = studentService.list();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void getPageTest(){
        Page<Student> page = new Page<>(2, 10);
        studentService.page(page);
        List<Student> records = page.getRecords();
        for (Student record : records) {
            System.out.println(record);
        }
    }


}
package com.allen.sb_01_mybatisplus.service.impl;

import com.allen.sb_01_mybatisplus.bean.Student;
import com.allen.sb_01_mybatisplus.dao.StudentDao;
import com.allen.sb_01_mybatisplus.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentDao, Student> implements StudentService {

    @Autowired
    private StudentDao studentDao;

    /**
     * 不包含的方法，在service接口中自己定义，在 serviceImpl 中自己实现
     *
     * @param id
     * @return
     */
    @Override
    public boolean delete(Integer id) {
        return studentDao.deleteById(id) > 0;
    }
}

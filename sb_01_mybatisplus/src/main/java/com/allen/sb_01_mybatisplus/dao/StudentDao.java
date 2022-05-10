package com.allen.sb_01_mybatisplus.dao;

import com.allen.sb_01_mybatisplus.bean.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentDao extends BaseMapper<Student> {
}

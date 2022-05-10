package com.allen.sb_01_mybatisplus.dao;

import com.allen.sb_01_mybatisplus.bean.Book;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookDao extends BaseMapper<Book> {
}

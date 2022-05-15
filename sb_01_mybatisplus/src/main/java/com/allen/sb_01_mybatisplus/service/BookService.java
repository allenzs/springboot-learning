package com.allen.sb_01_mybatisplus.service;

import com.allen.sb_01_mybatisplus.bean.Book;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * @author allen
 * @create 2022/5/11 0:06
 */
public interface BookService {

    Boolean save(Book book);

    Boolean update(Book book);

    Boolean delete(Integer id);

    Book getById(Integer id);

    List<Book> getAll();

    IPage<Book> getPage(Integer pageNum, Integer pageSize);

    IPage<Book> getPage(Integer pageNum, Integer pageSize, Book book);
}

package com.allen.sb_01_mybatisplus.service.impl;

import com.allen.sb_01_mybatisplus.bean.Book;
import com.allen.sb_01_mybatisplus.dao.BookDao;
import com.allen.sb_01_mybatisplus.service.BookService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public Boolean save(Book book) {
        return bookDao.insert(book) > 0;
    }

    @Override
    public Boolean update(Book book) {
        return bookDao.updateById(book) > 0;
    }

    @Override
    public Boolean delete(Integer id) {
        return bookDao.deleteById(id)>0;
    }

    @Override
    public Book getById(Integer id) {
        return bookDao.selectById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookDao.selectList(null);
    }

    @Override
    public IPage<Book> getPage(Integer pageNum, Integer pageSize) {
        Page<Book> page = new Page<>(pageNum, pageSize);
        bookDao.selectPage(page, null);
        return page;
    }
    @Override
    public IPage<Book> getPage(Integer pageNum, Integer pageSize, Book book) {
        LambdaQueryWrapper<Book> wrapper = new LambdaQueryWrapper<Book>();
        wrapper.like(Strings.isNotEmpty(book.getType()), Book::getType, book.getType());
        wrapper.like(Strings.isNotEmpty(book.getName()), Book::getName, book.getName());
        wrapper.like(Strings.isNotEmpty(book.getDescription()), Book::getDescription, book.getDescription());
        Page<Book> page = new Page<>(pageNum, pageSize);
        bookDao.selectPage(page, wrapper);
        return page;
    }
}

package com.allen.sb_01_mybatisplus.dao;

import com.allen.sb_01_mybatisplus.bean.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookDaoTest {

    @Autowired
    private BookDao bookDao;

    @Test
    void selectAll() {
        List<Book> books = bookDao.selectList(null);
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    void bT() {
        Book book = bookDao.selectById(2);
    }
}
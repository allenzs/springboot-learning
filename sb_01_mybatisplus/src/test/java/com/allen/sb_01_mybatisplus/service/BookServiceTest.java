package com.allen.sb_01_mybatisplus.service;

import com.allen.sb_01_mybatisplus.Sb01MybatisplusApplication;
import com.allen.sb_01_mybatisplus.bean.Book;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = Sb01MybatisplusApplication.class)
class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    void save() {
        Boolean save = bookService.save(Book.of(1, "文学", "西游记", "hh"));
        System.out.println(save);
    }

    @Test
    void update() {
        Boolean update = bookService.update(Book.of(1, "wenxue", "xiyouji", "hh"));
        System.out.println(update);
    }

    @Test
    void delete() {
        Boolean delete = bookService.delete(1);
        System.out.println(delete);
    }

    @Test
    void getById() {
        Book book = bookService.getById(2);
        System.out.println(book);
    }

    @Test
    void getAll() {
        List<Book> books = bookService.getAll();
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    public void getPage(){
        Book book = new Book();
        book.setId(1);
        book.setName("allen");

        IPage<Book> page = bookService.getPage(2, 4, book);
        List<Book> records = page.getRecords();
        for (Book record : records) {
            System.out.println(record);
        }
    }
}
package com.allen;

import com.allen.sb_00_demo.Sb00DemoApplication;
import com.allen.sb_00_demo.bean.Book;
import com.allen.sb_00_demo.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Sb00DemoApplication.class)
// 两种方法都可以
//@SpringBootTest
//@ContextConfiguration(classes = Sb00DemoApplication.class)
public class Test {

    @Autowired
    private BookDao bookDao;

    @org.junit.jupiter.api.Test
    public void test() {
        Book book = bookDao.getById(1);
        System.out.println(book);
    }
}

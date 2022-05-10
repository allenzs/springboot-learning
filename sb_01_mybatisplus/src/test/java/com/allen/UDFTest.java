package com.allen;

import com.allen.sb_01_mybatisplus.Sb01MybatisplusApplication;
import com.allen.sb_01_mybatisplus.bean.Book;
import com.allen.sb_01_mybatisplus.dao.BookDao;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = Sb01MybatisplusApplication.class)
public class UDFTest {

    @Autowired
    private BookDao bookDao;

    @Test
    public void test() {
        Book book = bookDao.selectById(1);
        System.out.println(book);
    }

    @Test
    public void insertTest(){
        for (int i = 0; i < 10; i++) {
            Book book = Book.of((i + 1), "click_" + i, "allen_" + i, "click_log_" + i);
            bookDao.insert(book);
        }
    }

    @Test
    public void queryByConditionTest(){
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
//        queryWrapper.like("name","allen");
//        queryWrapper.eq("type","click_4");

        String name = "allen";
        queryWrapper.like(true, "name", name);
        List<Book> books = bookDao.selectList(queryWrapper);


        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    public void testPage(){
        Page<Book> page = new Page<>(1,5);
        bookDao.selectPage(page, null);
        List<Book> records = page.getRecords();
        for (Book record : records) {
            System.out.println(record);
        }
    }
}

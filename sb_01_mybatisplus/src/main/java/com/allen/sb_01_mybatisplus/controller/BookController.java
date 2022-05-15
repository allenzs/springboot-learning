package com.allen.sb_01_mybatisplus.controller;

import com.allen.sb_01_mybatisplus.bean.Book;
import com.allen.sb_01_mybatisplus.controller.util.ResultVO;
import com.allen.sb_01_mybatisplus.service.BookService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public ResultVO getAll() {
        return new ResultVO(true, bookService.getAll());
    }

    @PostMapping
    public ResultVO save(@RequestBody Book book) {
        if (book.getName().length() <= 2) {
            throw new IllegalArgumentException("book name length should be more than tw0!");
        }
        Boolean b = bookService.save(book);
        return new ResultVO(b, b ? "添加成功^_^" : "添加失败^_^!");
    }

    @PutMapping
    public ResultVO update(@RequestBody Book book) {
        return new ResultVO(bookService.update(book));
    }

    @DeleteMapping("{id}")
    public ResultVO delete(@PathVariable Integer id) {
        return new ResultVO(bookService.delete(id));
    }

    @GetMapping("{id}")
    public ResultVO getById(@PathVariable Integer id) {
        return new ResultVO(true, bookService.getById(id));
    }

    @GetMapping("{currentPage}/{perPageSize}")
    public ResultVO getPage(@PathVariable int currentPage, @PathVariable int perPageSize, String name, Book book) {
        System.out.println("===>>> name:"+name);
        System.out.println("===>>> book:"+book);
        IPage<Book> page = bookService.getPage(currentPage, perPageSize,book);
        if (currentPage > page.getPages()) {
            page = bookService.getPage((int) page.getPages(), perPageSize,book);
        }
        return new ResultVO(true, page);
    }
}

package com.zh.test;

import com.zh.pojo.Book;
import com.zh.pojo.Page;
import com.zh.service.BookService;
import com.zh.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-08-16 18:47
 */
public class BookServiceTest {

    private BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(null, "张三的心酸史", "张三", new BigDecimal(12.900), 90, 1000, null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(23);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(22, "张三的心酸史", "张三", new BigDecimal(120.900), 90, 1000, null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(22));
    }

    @Test
    public void queryBooks() {
        for (Book book: bookService.queryBooks()) {
            System.out.println(book);
        }
    }

    @Test
    public void page() {
        System.out.println(bookService.page(1,Page.PAGE_SIZE));
    }

    @Test
    public void pageByPrice() {
        System.out.println(bookService.pageByPrice(1,Page.PAGE_SIZE,10, 50));
    }
}
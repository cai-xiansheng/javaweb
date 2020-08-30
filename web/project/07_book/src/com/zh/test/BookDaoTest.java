package com.zh.test;

import com.zh.dao.BookDao;
import com.zh.dao.impl.BookDaoImpl;
import com.zh.pojo.Book;
import com.zh.pojo.Page;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-08-16 14:13
 */
public class BookDaoTest {

    private BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        bookDao.addBook(new Book(null, "张三的心酸史", "张三", new BigDecimal(12.900), 90, 1000, null));
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(21);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(21, "张三的心酸史", "张三", new BigDecimal(120.900), 90, 1000, null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(21));
    }

    @Test
    public void queryBooks() {
        for (Book book: bookDao.queryBooks()) {
            System.out.println(book);
        }
    }

    @Test
    public void queryForPageTotalCount() {
        System.out.println(bookDao.queryForPageTotalCount());
    }

    @Test
    public void queryForPageItems() {
        for (Book book : bookDao.queryForPageItems(8, 4)) {
            System.out.println(book);
        }
    }

    @Test
    public void queryForPageTotalCountByPrice() {
        Integer integer = bookDao.queryForPageTotalCountByPrice(10, 100);
        System.out.println(integer);
    }

    @Test
    public void queryForPageItemsByPrice() {
        List<Book> books = bookDao.queryForPageItemsByPrice(0, Page.PAGE_SIZE, 10, 100);
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
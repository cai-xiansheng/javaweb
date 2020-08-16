package com.zh.service.impl;

import com.zh.dao.BookDao;
import com.zh.dao.impl.BookDaoImpl;
import com.zh.pojo.Book;
import com.zh.service.BookService;

import java.util.List;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-08-16 18:44
 */
public class BookServiceImpl implements BookService {

    private BookDao bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }
}

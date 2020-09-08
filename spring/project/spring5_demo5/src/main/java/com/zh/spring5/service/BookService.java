package com.zh.spring5.service;

import com.zh.spring5.dao.BookDao;
import com.zh.spring5.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-09-07 20:58
 */

@Service
public class BookService {

    // 注入dao
    @Autowired
    private BookDao bookDao;


    // 添加的方法
    public void addBook(Book book) {
        bookDao.add(book);
    }

    // 修改的方法
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    public void deleteBook(String id) {
        bookDao.deleteBook(id);
    }

    public int findCount() {
        int i = bookDao.selectBook();
        return i;
    }


    public Book findBookInfo(String id) {
        return bookDao.findBookInfo(id);
    }

    public List<Book> findAllBook() {
        return bookDao.findAllBook();
    }

    public void batchAddBook(List<Object[]> objects) {
        bookDao.batchAddBook(objects);
    }

    public void batchUpdateBook(List<Object[]> batchArgs) {
        bookDao.batchUpdateBook(batchArgs);
    }

    public void batchDeleteBook(List<Object[]> batchArgs) {
        bookDao.batchDeleteBook(batchArgs);
    }



}

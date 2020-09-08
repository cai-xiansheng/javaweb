package com.zh.spring5.dao;

import com.zh.spring5.entity.Book;

import java.util.List;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-09-07 20:59
 */
public interface BookDao {

    public void add(Book book);

    public void updateBook(Book book);

    public void deleteBook(String id);

    public int selectBook();

    public Book findBookInfo(String id);

    public List<Book> findAllBook();

    public void batchAddBook(List<Object[]> batchArgs);

    public void batchUpdateBook(List<Object[]> batchArgs);

    public void batchDeleteBook(List<Object[]> batchArgs);

}

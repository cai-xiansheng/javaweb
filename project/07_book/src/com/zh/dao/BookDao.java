package com.zh.dao;

import com.zh.pojo.Book;

import java.util.List;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-08-16 13:49
 */
public interface BookDao {

    public int addBook(Book book);

    public int deleteBookById(Integer id);

    public int updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

}

package com.zh.service;

import com.zh.pojo.Book;
import com.zh.pojo.Page;

import java.util.List;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-08-16 18:41
 */
public interface BookService {

    public void addBook(Book book);

    public void deleteBookById(Integer id);

    public void updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    Page page(int pageNo, int pageSize);

    Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);
}

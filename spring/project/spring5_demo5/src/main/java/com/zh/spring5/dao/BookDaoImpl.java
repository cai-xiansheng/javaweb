package com.zh.spring5.dao;

import com.zh.spring5.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-09-07 20:59
 */
@Repository
public class BookDaoImpl implements BookDao {

    // 注入JdbcTemplate对象
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void add(Book book) {
        // 1. 创建sql语句
        String sql = "insert into t_book values(?, ?, ?)";
        // 2. 调用方法实现
        Object[] args = {book.getUserId(), book.getUsername(), book.getUstatus()};
        int update = jdbcTemplate.update(sql, args);
        System.out.println(update);
    }


    public void updateBook(Book book) {
        String sql = "update t_book set username = ?, ustatus = ? where user_id = ?";
        Object[] args = {book.getUsername(), book.getUstatus(), book.getUserId()};
        int update = jdbcTemplate.update(sql, args);
        System.out.println(update);
    }

    public void deleteBook(String id) {
        String sql = "delete from t_book where user_id = ?";
        int update = jdbcTemplate.update(sql, id);
        System.out.println(update);
    }


    @Override
    public int selectBook() {
        String sql = "select count(*) from t_book";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;
    }

    @Override
    public Book findBookInfo(String id) {
        String sql = "select * from t_book where user_id = ?";
        Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class), id);
        return book;
    }


    @Override
    public List<Book> findAllBook() {
        String sql = "select * from t_book";
        List<Book> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
        return query;
    }

    @Override
    public void batchAddBook(List<Object[]> batchArgs) {
        String sql = "insert into t_book value(?, ?, ?)";
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(ints));
    }

    @Override
    public void batchUpdateBook(List<Object[]> batchArgs) {
        String sql = "update t_book set username = ?, ustatus = ? where user_id = ?";
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(ints));
    }

    @Override
    public void batchDeleteBook(List<Object[]> batchArgs) {
        String sql = "delete from t_book where user_id = ?";
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(ints));
    }
}

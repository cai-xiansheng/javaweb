package com.zh.spring5;

import com.zh.spring5.entity.Book;
import com.zh.spring5.service.BookService;
import jdk.nashorn.internal.ir.BaseNode;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-09-08 10:08
 */
public class Test {

    @org.junit.Test
    public void testJdbcTemplate() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        Book book = new Book();
        book.setUserId("2");
        book.setUsername("javaEE");
        book.setUstatus("b");
        bookService.addBook(book);
    }

    @org.junit.Test
    public void updateBookTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        Book book = new Book();
        book.setUserId("3");
        book.setUsername("javaE");
        book.setUstatus("s");
        bookService.updateBook(book);
    }

    @org.junit.Test
    public void deleteBookTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        //bookService.deleteBook("1");

        //System.out.println(bookService.findCount());

        //System.out.println(bookService.findBookInfo("2"));

        //List<Book> allBook = bookService.findAllBook();
        //for (Book book : allBook) {
        //    System.out.println(book);
        //}


        //List<Object[]> batchArgs = new ArrayList<>();
        //Object[] o1 = {"4", "java", "b"};
        //Object[] o2 = {"5", "java", "c"};
        //Object[] o3 = {"6", "java", "d"};
        //batchArgs.add(o1);
        //batchArgs.add(o2);
        //batchArgs.add(o3);
        //bookService.batchAddBook(batchArgs);


        //List<Object[]> batchArgs = new ArrayList<>();
        //Object[] o1 = {"java0909", "b1", "4"};
        //Object[] o2 = {"java0909", "c1", "5"};
        //Object[] o3 = {"java0909", "d1", "6"};
        //batchArgs.add(o1);
        //batchArgs.add(o2);
        //batchArgs.add(o3);
        //bookService.batchUpdateBook(batchArgs);


        List<Object[]> batchArgs = new ArrayList<>();
        Object[] o1 = {"3"};
        Object[] o2 = {"4"};
        batchArgs.add(o1);
        batchArgs.add(o2);
        bookService.batchDeleteBook(batchArgs);


    }

}

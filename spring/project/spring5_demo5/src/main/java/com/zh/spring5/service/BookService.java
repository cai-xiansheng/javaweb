package com.zh.spring5.service;

import com.zh.spring5.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}

package com.zh.test;

import com.zh.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-08-13 15:12
 */
public class JdbcUtilsTest {

    @Test
    public void testJdbcUtils() {
        for (int i = 0; i < 100; i++) {
            Connection connection = JdbcUtils.getConnection();
            System.out.println(connection);
            JdbcUtils.close(connection);
        }
    }
}

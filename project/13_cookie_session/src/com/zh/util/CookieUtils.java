package com.zh.util;

import javax.servlet.http.Cookie;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-08-20 15:52
 */
public class CookieUtils {

    /**
     * 查找指定名称的Cookie对象
     * @param name
     * @param cookies
     * @return
     */
    public static Cookie finCookie(String name,Cookie[] cookies) {
        if (name == null || cookies == null || cookies.length == 0) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if (name.equals(cookie.getName())) {
                return cookie;
            }
        }
        return null;
    }

}

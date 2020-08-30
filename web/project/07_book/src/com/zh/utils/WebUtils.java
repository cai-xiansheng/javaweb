package com.zh.utils;

import com.zh.pojo.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-08-16 12:38
 */
public class WebUtils {

    /**
     * 把map中的值注入到对应的JavaBean中
     *
     * @param value
     * @param bean
     */
    public static <T> T copyParamToBean(Map value, T bean) {
        try {
            /**
             * 把所有请求的参数都注入user对象中
             */
            BeanUtils.populate(bean, value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }

    /**
     * 将字符串转化为int类型的数据
     * @param strInt
     * @param defaultValue
     * @return
     */
    public static int parseInt(String strInt, int defaultValue) {
        try {
            return Integer.parseInt(strInt);
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return defaultValue;
    }
}

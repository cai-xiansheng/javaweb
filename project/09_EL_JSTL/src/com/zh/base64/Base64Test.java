package com.zh.base64;

import java.util.Arrays;
import java.util.Base64;

import static java.util.Base64.getDecoder;
import static java.util.Base64.getEncoder;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-08-15 16:52
 */
public class Base64Test {
    public static void main(String[] args) throws Exception {
        String content = "这是需要Base64编码的内容";

        // 编码操作
        Base64.Encoder base64 = getEncoder();
        byte[] encode = base64.encode(content.getBytes("utf-8"));
        System.out.println(new String(encode, 0, encode.length));

        // 节码操作
        Base64.Decoder decoder = getDecoder();
        byte[] decode = decoder.decode(encode);
        System.out.println(new String(decode, 0, decode.length));
    }
}

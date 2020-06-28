package com.parking.ssm.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUtils {
    private  static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    public static String encodePassword(String password) {
        return bCryptPasswordEncoder.encode(password);
    }

    public static void main(String[] args) {
        String password = "123123";
        //$2a$10$vxasL1qxqw.U.j8kKl38kerhgGlIXpCzkXSSSwZlf8Yb5mrlwHFoW
        //$2a$10$6124R6urY6kIPjm381nX4.bGDUNrUHgUhkvS/udwBiRZZrBcfiplm
        String pwd = BCryptPasswordEncoderUtils.encodePassword(password);
        System.out.println(pwd);

        Boolean match = bCryptPasswordEncoder.matches("123123","$2a$10$vxasL1qxqw.U.j8kKl38kerhgGlIXpCzkXSSSwZlf8Yb5mrlwHFoW");
        if (match == true) {
            System.out.println("匹配");
        }else if (match == false) {
            System.out.println("不匹配");
        }
    }
}

package com.autotboxdatasystem.demo.util;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexUtil {

    public static boolean isUsername(String username) {
        // 4~20位, 数字字母点下划线横线
        String regex = "^[a-zA-Z0-9._-]{4,20}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }

    public static boolean isPassword(String password) {
        // 4~20位, 数字字母混合
        String regex = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{4,20}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static boolean isEmail(String email) {
        // e.g: user?name@domain.co.in
        String regex = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isPhone(String phone) {
        // 11位, 数字
        String regex = "^[0-9]{11}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }
}

package com.autotboxdatasystem.demo.util;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexUtil {

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

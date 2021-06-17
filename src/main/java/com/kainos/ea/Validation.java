package com.kainos.ea;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    public static boolean lengthCheck(String input, int min, int max) {
        int length = input.length();

        if(length < min || length > max){
            return false;
        }

        return true;
    }

    public static boolean NumericCheck(String input, int min, int max) {
        return checkRegex(input, "^\\d+(\\.\\d+)*$");
    }

    public static boolean NonNumericCheck(String input, int min, int max) {
        return checkRegex(input, "^([^0-9]*)$");
    }

    public static boolean checkRegex(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        boolean matchFound = matcher.find();
        return matchFound;
    }
}

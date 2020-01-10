package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null) {
            throw new TooShortStringException();
        }

        String[] result = string.split("\t");

        int tabsCount = string.length() - string.replaceAll("\t", "").length();

        if (tabsCount < 2) {
            throw new TooShortStringException();
        }

        return result[1];
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
//        System.out.println(getPartOfString("\tJavaRush - лучший сервис обучения Java."));
    }
}

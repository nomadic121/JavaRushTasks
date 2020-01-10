package com.javarush.task.task22.task2202;

/*
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
        System.out.println(getPartOfString("Амиго и Диего лучшие друзья!"));
    }

    public static String getPartOfString(String string) {
        if (string == null) {
            throw new TooShortStringException();
        }
        int[] spaces = new int[5];

        for (int i = 0; i < 5; i++) {
            int lastIndex = (i == 0) ? 0 : spaces[i - 1] + 1;
            spaces[i] = string.indexOf(" ", lastIndex);
            if (spaces[i] == -1) {
                if (i < 4) {
                    throw new TooShortStringException();
                }
                spaces[i] = string.length();
            }
        }

        String result = null;
        try {
            result = string.substring(spaces[0] + 1, spaces[4]);
        } catch (IndexOutOfBoundsException e) {
            throw new TooShortStringException();
        }
        return result.trim();
    }

    public static class TooShortStringException extends RuntimeException {
    }
}

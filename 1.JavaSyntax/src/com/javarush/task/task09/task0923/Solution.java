package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] inputLine = reader.readLine().toCharArray();
        String vowel = "";
        String notVowel = "";

        for (char x : inputLine) {
            if (Solution.isVowel(x)) {
                vowel += (x + " ");
            } else
                if (!" ".equals(String.valueOf(x))) {
                    notVowel += (x + " ");
                }
        }
        System.out.println(vowel);
        System.out.println(notVowel);
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам
        for (char d : vowels) {  // ищем среди массива гласных
            if (c == d) {
                return true;
            }
        }
        return false;
    }
}
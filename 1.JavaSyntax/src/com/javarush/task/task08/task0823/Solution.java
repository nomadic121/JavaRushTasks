package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();

        //напишите тут ваш код
        char[] s = string.toCharArray();

        s[0] = Character.toUpperCase(s[0]);

        for (int i = 0; i < s.length; i++) {
            if (Character.isWhitespace(s[i]) && (i + 1) <= s.length){
                s[i + 1] = Character.toUpperCase(s[i + 1]);
            }
        }
        string = "";
        for (char x: s){
            string = string + x;
        }
        System.out.println(string);
    }
}

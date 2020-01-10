package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        ArrayList<String > list = new ArrayList<>();
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            list.add(reader.readLine());
        }
        String s = list.get(0);
        int length = s.length();
        int index = 0;
        for (int i = 0; i < 10; i++) {
            s = list.get(i);
            if (length <= s.length()){
                length = s.length();
            } else {
                System.out.println(i);
                break;
            }
        }

    }
}


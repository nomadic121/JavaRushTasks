package com.javarush.task.task04.task0442;


/* 
Суммирование
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int sum = 0, input = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (input != -1) {
            input = Integer.parseInt(reader.readLine());
            sum = sum + input;
        }

        System.out.println(sum);
    }
}

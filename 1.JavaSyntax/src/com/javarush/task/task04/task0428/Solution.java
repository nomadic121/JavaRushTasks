package com.javarush.task.task04.task0428;

/* 
Положительное число
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] a = new int[3];
        int count = 0;
        for (int i = 0; i < 3; i++) {
            a[i] = Integer.parseInt(reader.readLine());
            if (a[i] > 0) count++;
        }
        System.out.println(count);
    }
}

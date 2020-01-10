package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] a = new int[4];
        int max;
        for (int i = 0; i < 4; i++) {
            a[i] = Integer.parseInt(reader.readLine());
        }
        max = a[0];

        for (int i = 0; i < 4; i++) {
            if (max < a[i]) max = a[i];
        }
        System.out.println(max);
    }
}

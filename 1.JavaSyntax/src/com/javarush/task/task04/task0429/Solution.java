package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] a = new int[3];
        int plus = 0 , minus = 0;
        for (int i = 0; i < 3; i++) {
            a[i] = Integer.parseInt(reader.readLine());
            if (a[i] > 0) plus++;
            if (a[i] < 0) minus++;
        }
        System.out.println("количество отрицательных чисел: " + minus);
        System.out.println("количество положительных чисел: " + plus);
    }
}

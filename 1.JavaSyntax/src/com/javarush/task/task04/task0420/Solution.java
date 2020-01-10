package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = new int[3];

        for (int i = 0; i < 3; i++) {
            numbers[i] = Integer.parseInt(reader.readLine());
        }
        shakerSort(numbers);

        for (int i = 2; i >= 0; i--) {
            System.out.print(numbers[i] + " ");
        }
    }

    public static void shakerSort(int[] array) {
        int buff;
        int left = 0;
        int right = array.length - 1;
        do {
            for (int i = left; i < right; i++) {
                if (array[i] > array[i + 1]) {
                    buff = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = buff;
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (array[i] < array[i - 1]) {
                    buff = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = buff;
                }
            }
            left++;
        } while (left < right);
    }
}



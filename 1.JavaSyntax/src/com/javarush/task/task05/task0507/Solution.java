package com.javarush.task.task05.task0507;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Среднее арифметическое
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int input, summ = 0, count = 0;

        while (true) {
            int num = Integer.parseInt(reader.readLine());
            if (num == -1) break;
            summ += num;
            count++;
        }

        System.out.println((double) summ/count);
    }
}


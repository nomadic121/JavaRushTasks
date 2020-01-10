package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int even = 0; //чётные
        int odd = 0; //нечётные

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] big = new int[15];
        for (int i = 0; i < 15; i++) {
            big[i] = Integer.parseInt(reader.readLine());
            if (i%2 == 0) even = even + big[i];
            else odd = odd + big[i];
        }
        if (even > odd) System.out.println("В домах с четными номерами проживает больше жителей.");
        else System.out.println("В домах с нечетными номерами проживает больше жителей.");
    }
}

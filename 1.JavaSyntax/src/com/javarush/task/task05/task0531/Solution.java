package com.javarush.task.task05.task0531;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Совершенствуем функциональность
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[5];

        for (int i = 0; i < 5; i++){
            arr[i] = Integer.parseInt(reader.readLine());
        }

        int result = min(arr[0], arr[1], arr[2], arr[3], arr[4]);


        System.out.println("Minimum = " + result);
    }


    public static int min(int a, int b, int c, int d, int e) {
        int[] mi = {a,b,c,d,e};
        int mini = mi[0];
        for (int i = 0; i < 5; i++){
            mini = min2(mini, mi[i]);
        }
        return mini;
    }

    public static int min2(int a, int b) {
        return a < b ? a : b;
    }
}

package com.javarush.task.task04.task0418;

/* 
Минимум двух чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a,b;
        a = Integer.parseInt(reader.readLine());
        b = Integer.parseInt(reader.readLine());

        if (a < b){
            System.out.println(a);
        } else {
            System.out.println(b);
        }
    }
}
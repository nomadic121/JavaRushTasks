package com.javarush.task.task04.task0424;

/* 
Три числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int a, b, c;
        a = Integer.parseInt(reader.readLine());
        b = Integer.parseInt(reader.readLine());
        c = Integer.parseInt(reader.readLine());

        if (a != b && a != c && b == c){
            System.out.println(1);
        } else if (b != a && b != c && a == c){
            System.out.println(2);
        } else if (c != a && c != b && a == b){
            System.out.println(3);
        }
    }
}

package com.javarush.task.task04.task0417;

/* 
Существует ли пара?
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int a,b,c;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        a = Integer.parseInt(reader.readLine());
        b = Integer.parseInt(reader.readLine());
        c = Integer.parseInt(reader.readLine());

        if (a == b && b == c){
            System.out.println(a + " " + b + " " + c);
        } else if (a == b){
            System.out.println(a + " " + b);
        } else if (b == c){
            System.out.println(b + " " + c);
        } else if (a == c){
            System.out.println(a + " " + c);
        }
    }
}
package com.javarush.task.task04.task0421;

/* 
Настя или Настя?
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a,b;
        a = reader.readLine();
        b = reader.readLine();

        if (a.equals(b)){
            System.out.println("Имена идентичны");
        } else if (a.length() == b.length()){
            System.out.println("Длины имен равны");
        }
    }
}

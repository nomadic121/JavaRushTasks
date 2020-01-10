package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
        double minutes = Double.parseDouble(reader.readLine());

        //float divide = minutes % 5;
        double divide = minutes - ((int) minutes / 5) * 5;

        if (divide < 3.0){
            System.out.println("зелёный");
        } else if (divide < 4.0){
            System.out.println("жёлтый");
        } else System.out.println("красный");

    }
}
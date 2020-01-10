package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        while (!s.equals("exit")){
            try {
                if (s.contains(".")) {
                    print(Double.parseDouble(s));
                } else {
                    Integer x = Integer.parseInt(s);

                    if (x.intValue() > 0 & x.intValue() < 128){
                        print(x.shortValue());
                    } else if (x.intValue() <=0 | x.intValue() >= 128){
                        print(x);
                    }
                }
            }
            catch (Exception NumberFormatException){
                    print(s);
            } finally {
                s = reader.readLine();
            }
        }

    }
    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}

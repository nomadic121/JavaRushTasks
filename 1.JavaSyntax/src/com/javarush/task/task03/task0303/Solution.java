package com.javarush.task.task03.task0303;

/* 
Обмен валют
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        System.out.println(convertEurToUsd(5, 1.2));
        System.out.println(convertEurToUsd(25, 1.3));
    }

    public static double convertEurToUsd(int eur, double course) {
        //напишите тут ваш код
        return eur * course;
    }
}

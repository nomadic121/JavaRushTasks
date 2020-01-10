package com.javarush.task.task06.task0609;

/* 
Расстояние между двумя точками
*/

public class Util {
    public static double getDistance(int x1, int y1, int x2, int y2) {
        //напишите тут ваш код
        double c;
        int a, b;
        a = x1 - x2;
        b = y1 - y2;
        c = Math.sqrt(a * a + b * b);
        return c;
    }


    public static void main(String[] args) {

    }
}

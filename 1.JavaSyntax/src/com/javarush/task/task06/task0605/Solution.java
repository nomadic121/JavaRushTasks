package com.javarush.task.task06.task0605;


import java.io.*;

/* 
Контролируем массу тела
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
        double weight = Double.parseDouble(bis.readLine());
        double height = Double.parseDouble(bis.readLine());

        Body.calculateMassIndex(weight, height);
    }

    public static class Body {
        public static void calculateMassIndex(double weight, double height) {
/*
            // напишите тут ваш код
            "Недовес: меньше чем 18.5" - если индекс массы тела меньше 18.5 (не включая),
            "Нормальный: между 18.5 и 25" - если индекс массы тела между 18.5 и 25 (не включая),
            "Избыточный вес: между 25 и 30" - если индекс массы тела между 25 и 30 (не включая),
            "Ожирение: 30 или больше" - если индекс массы тела 30 или больше.
*/
            double imt = weight / (height * height);

            if (imt < 18.5) {
                System.out.println("Недовес: меньше чем 18.5");
            }
            if (imt >= 18.5 && imt < 25){
                System.out.println("Нормальный: между 18.5 и 25");
            }
            if (imt >= 25 && imt < 30){
                System.out.println("Избыточный вес: между 25 и 30");
            }
            if (imt >= 30){
                System.out.println("Ожирение: 30 или больше");
            }
        }
    }
}

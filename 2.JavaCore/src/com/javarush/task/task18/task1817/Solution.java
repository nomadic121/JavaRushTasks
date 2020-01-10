package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream file = new FileInputStream(args[0]);
        int count = 0, countS = 0;
        while (file.available() > 0) {
            int b = file.read();
            if (b == 32) {
                countS++;
            }
            count++;
        }
        double proportion = (double)Math.round ((double)countS / count * 10000) / 100d;

        System.out.println(proportion);
        file.close();
    }
}

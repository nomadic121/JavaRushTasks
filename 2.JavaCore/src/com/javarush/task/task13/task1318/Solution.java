package com.javarush.task.task13.task1318;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        FileInputStream file;

        try {
            file = new FileInputStream(s);
            while (file.available() > 0){
                System.out.print((char)file.read());
//                System.out.println();
            }
        } finally {
            reader.close();
        }
        file.close();

    }
}
package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        fileName = reader.readLine();

        FileInputStream file = null;
        try {
            file = new FileInputStream(fileName);

            int min = Integer.MAX_VALUE;

            while (file.available() > 0) {
                int buff = file.read();
                min = min < buff ? min : buff;
            }

            System.out.println(min);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            file.close();
        }
    }
}

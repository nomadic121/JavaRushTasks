package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.SortedSet;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        fileName = reader.readLine();

        FileInputStream file = new FileInputStream(fileName);
        int count = 0;

        while (file.available() > 0) {
            if (file.read() == 44) {
                count++;
            }
        }

        System.out.println(count);

        file.close();
        reader.close();
    }
}

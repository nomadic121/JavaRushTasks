package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader (new FileReader(reader.readLine()));
        reader.close();

        while (fileReader.ready()) {
            StringBuilder sb = new StringBuilder(fileReader.readLine());
            sb.reverse();
            System.out.println(sb.toString());
        }
        fileReader.close();
    }
}

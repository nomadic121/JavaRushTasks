package com.javarush.task.task18.task1801;

import java.io.*;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        fileName = reader.readLine();

        FileInputStream file = null;
        try {
            file = new FileInputStream(fileName);

            int max = 0;

            while (file.available() > 0){
                int buff = file.read();
                max = max > buff ? max : buff;
            }

            System.out.println(max);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            file.close();
        }
    }
}

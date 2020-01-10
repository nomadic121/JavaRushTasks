package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1, fileName2;
        fileName1 = reader.readLine();
        fileName2 = reader.readLine();

        FileInputStream file1 = new FileInputStream(fileName1);
        FileOutputStream file2 = new FileOutputStream(fileName2);

        if (file1.available() > 0) {
            byte[] buff = new byte[file1.available()];
            int count = file1.read(buff);

            for (int i = count - 1; i >= 0; i--) {
                file2.write(buff[i]);
            }
        }

        reader.close();
        file1.close();
        file2.close();

    }
}

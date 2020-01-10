package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1, fileName2, fileName3;
        fileName1 = reader.readLine();
        fileName2 = reader.readLine();
        fileName3 = reader.readLine();

        FileInputStream file1 = new FileInputStream(fileName1);
        FileOutputStream file2 = new FileOutputStream(fileName2);
        FileOutputStream file3 = new FileOutputStream(fileName3);

        byte[] buff = new byte[file1.available()];
        int count = 0;

        if (file1.available() > 0){
            count = file1.read(buff);
        }
        if (count % 2 == 1){
            file2.write(buff, 0, count / 2 + 1);
            file3.write(Arrays.copyOfRange(buff, count / 2 + 1, buff.length), 0, count / 2);
        } else {
            file2.write(buff, 0, count / 2);
            file3.write(Arrays.copyOfRange(buff, count / 2, buff.length), 0, count / 2);
        }

        reader.close();
        file1.close();
        file2.close();
        file3.close();
    }
}

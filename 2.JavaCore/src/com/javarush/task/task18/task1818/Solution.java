package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1, file2, file3;
        file1 = reader.readLine();
        file2 = reader.readLine();
        file3 = reader.readLine();

        FileOutputStream fw1 = new FileOutputStream(file1);
        FileInputStream fr2 = new FileInputStream(file2);
        FileInputStream fr3 = new FileInputStream(file3);

        if (fr2.available() > 0) {
            byte[] buff = new byte[fr2.available()];
            int count = fr2.read(buff, 0, fr2.available());
            fw1.write(buff, 0, count);
        }
        if (fr3.available() > 0) {
            byte[] buff = new byte[fr3.available()];
            int count = fr3.read(buff, 0, fr3.available());
            fw1.write(buff, 0, count);
        }

        fw1.close();
        fr2.close();
        fr3.close();
    }
}

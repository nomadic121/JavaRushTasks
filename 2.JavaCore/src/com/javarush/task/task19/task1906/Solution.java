package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();
        String filename2 = reader.readLine();
        reader.close();

        FileReader in = new FileReader(filename1);
        FileWriter out = new FileWriter(filename2);
        int i = 1;
        while (in.ready()) {
            int buff = in.read();
            if (i % 2 == 0) out.write(buff);
            i++;
        }
        in.close();
        out.close();
    }

}

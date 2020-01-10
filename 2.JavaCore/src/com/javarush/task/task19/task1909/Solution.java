package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader in = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter out = new BufferedWriter(new FileWriter(reader.readLine()));

        while (in.ready()) {
            out.write(in.readLine().replaceAll("\\.", "\\!") + System.lineSeparator());
        }
        reader.close();
        in.close();
        out.close();
    }
}

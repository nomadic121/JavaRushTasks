package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();

        BufferedReader in = new BufferedReader(new FileReader(filename));
        int count = 0;
        while (in.ready()) {
            String buff = in.readLine();
            for (String s: buff.split("\\W")) {
                if ("world".equals(s)) count ++;
            }
        }
        in.close();
        System.out.println(count);
    }

}

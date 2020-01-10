package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        doIt();
//        System.out.println(parse("12 text var2 14 8ю 1"));
    }

    private static void doIt() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader in = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter out = new BufferedWriter(new FileWriter(reader.readLine()));

        while (in.ready()) {
            out.write(parse(in.readLine()));
        }
        reader.close();
        in.close();
        out.close();
    }

    private static String parse(String in) {
        if (in == null) return "";
        StringBuilder sb = new StringBuilder();

        for (String s : in.split(" ")) {
            if (!s.isEmpty() && s.replaceAll("\\d", "").isEmpty()) {
                sb
                        .append(s)
                        .append(" ");
            }
        }
        return sb.toString().trim();
    }
}

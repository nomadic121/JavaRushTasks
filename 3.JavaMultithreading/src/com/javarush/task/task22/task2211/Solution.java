package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
//        args = new String[] {"C:\\temp\\text.txt", "C:\\temp\\text2.txt"};

//        BufferedReader in = new BufferedReader(new FileReader(args[0], Charset.forName("Windows-1251")));
//        FileWriter out = new FileWriter(args[1], Charset.forName("UTF-8"));
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(args[0]), "Cp1251"));
        FileOutputStream out = new FileOutputStream (args[1]);
        while (in.ready()) {
            String buff = in.readLine();
            out.write((buff + System.lineSeparator()).getBytes("UTF-8"));
        }
        in.close();
        out.close();
    }
}

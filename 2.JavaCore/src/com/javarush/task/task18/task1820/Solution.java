package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
//        String sConsole = "C:\\temp\\double.txt\nC:\\temp\\result.txt\n";
//        byte[] bytes = sConsole.getBytes();
//        InputStream inputStream = new ByteArrayInputStream(bytes);
//        System.setIn(inputStream);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fn1 = reader.readLine();
        String fn2 = reader.readLine();
        FileInputStream fi = new FileInputStream(fn1);
        FileOutputStream fo = new FileOutputStream(fn2);

        byte[] buff = new byte[fi.available()];
        fi.read(buff);
        String numbers = "";

        for (byte b : buff) {
            numbers += (char) b;
        }

        String result = "";
        for (String number : numbers.split(" ")) {
            result += (int)Math.round(Double.parseDouble(number)) + " ";
        }

        fo.write(result.getBytes());

        fi.close();
        fo.close();
        reader.close();

    }
}

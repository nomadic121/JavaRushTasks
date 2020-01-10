package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        BufferedReader reader;
        FileWriter fileWr;
        BufferedWriter buffWr;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            String s = reader.readLine();

//        BufferedWriter buf = Files.newBufferedWriter(s), Charset.forName("utf-8"), StandardOpenOption.APPEND);

            File file = new File(s);
            fileWr = new FileWriter(file);
            buffWr = new BufferedWriter(fileWr);

            do {
                s = reader.readLine();
                buffWr.write(s + System.lineSeparator());
            } while (!(s.equals("exit")));

            buffWr.close();
            fileWr.close();
//        file.close();
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }


    }
}

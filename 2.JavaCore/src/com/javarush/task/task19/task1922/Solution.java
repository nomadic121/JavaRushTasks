package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader (new FileReader(reader.readLine()));
        reader.close();

        while (fileReader.ready()){
            String buff = fileReader.readLine();
            if (isMatch(buff)) System.out.println(buff);
        }

        fileReader.close();

//        System.out.println(isMatch("файл вид В"));
//        System.out.println(isMatch("файл вид  файл"));
//        System.out.println(isMatch(" вид В"));
//        System.out.println(isMatch("файл  В"));
//        System.out.println(isMatch("  В"));
    }

    private static boolean isMatch(String buff) {
        int wordCount = 0;
        for (String element : buff.split("[\\p{P}\\p{Z}]+")) {
            if (words.contains(element)) wordCount++;
        }
        if (wordCount == 2) return true;
        return false;
    }
}

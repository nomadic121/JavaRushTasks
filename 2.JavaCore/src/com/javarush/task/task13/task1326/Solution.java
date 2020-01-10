package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        BufferedReader file;
        List<Integer> intList = new LinkedList<>();

        try {
            file = new BufferedReader(new InputStreamReader(new FileInputStream(new File(s))));
            while (file.ready()) {
                intList.add(Integer.parseInt(file.readLine()));
            }
        } finally {
            reader.close();
        }
        file.close();

//        System.out.println(intList);

        intList.stream()
                .sorted()
                .filter(x -> x % 2 == 0)
                .forEach(System.out::println);

    }
}

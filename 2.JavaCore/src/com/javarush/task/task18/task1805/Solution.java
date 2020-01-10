package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.SortedSet;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        fileName = reader.readLine();

        FileInputStream file = new FileInputStream(fileName);
        SortedSet<Integer> bytesSet = new TreeSet<>();

        while (file.available() > 0){
            bytesSet.add(file.read());
        }

        for (int x :
                bytesSet) {
            System.out.print(x + " ");
        }

        file.close();
        reader.close();

    }
}

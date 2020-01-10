package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader (new FileReader(args[0]));
        Map<String, Double> data = new TreeMap<>();

        while (fileReader.ready()) {
            String[] buff = fileReader.readLine().split(" ");
            if (data.containsKey(buff[0])) {
                data.put (buff[0], Double.parseDouble (buff[1]) + data.get(buff[0]));
            } else {
                data.put (buff[0], Double.parseDouble (buff[1]));
            }
        }

        for (Map.Entry<String, Double> element: data.entrySet()) {
            System.out.println(element.getKey() + " " + element.getValue());
        }
        fileReader.close();
    }
}

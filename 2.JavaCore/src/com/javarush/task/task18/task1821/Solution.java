package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fi = new FileInputStream(args[0]);
        byte[] buff = new byte[fi.available()];
        fi.read(buff);

        SortedMap<Byte, Integer> dataMap = new TreeMap<>();

        for (byte b : buff) {
            if (b >= 0 & b < 128) {
                if (dataMap.containsKey(b)){
                    dataMap.put(b, dataMap.get(b) + 1);
                } else {
                    dataMap.put(b, 1);
                }
            }
        }

        for (Map.Entry<Byte, Integer> x: dataMap.entrySet()){
            System.out.println((char)(int) x.getKey() + " " + x.getValue());
        }
        fi.close();

    }
}

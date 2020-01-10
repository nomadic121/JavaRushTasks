package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        fileName = reader.readLine();

        ArrayList<Integer> bytes = new ArrayList<>();
        HashMap<Integer, Integer> bytesMap = new HashMap<>();
        FileInputStream file = null;
        try {
            file = new FileInputStream(fileName);

            while (file.available() > 0) {
                int buff;
                buff = file.read();
                bytes.add(buff);
                bytesMap.put(buff, 1);
            }

            int count, max = 0;
            for (Map.Entry<Integer, Integer> x : bytesMap.entrySet()) {
                count = 0;
                for (Integer y : bytes) {
                    if (x.getKey() == y) {
                        count++;
                    }
                }
                bytesMap.replace(x.getKey(), count);
                max = max > count ? max : count;
            }

            for (Map.Entry<Integer, Integer> x : bytesMap.entrySet()) {
                if (x.getValue() == max) {
                    System.out.print(x.getKey() + " ");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            file.close();
        }
    }
}

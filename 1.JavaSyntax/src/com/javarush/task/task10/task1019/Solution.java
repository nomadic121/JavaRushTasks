package com.javarush.task.task10.task1019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();

        String s;
        Integer id;
        String name;
        while (true) {
            s = reader.readLine();
            if (s.isEmpty()) {
                break;
            }
            id = Integer.parseInt(s);

            s = reader.readLine();
            if (s.isEmpty()) {
                map.put("", id);
                break;
            }
            map.put(s, id);
        }

        for (Map.Entry<String, Integer> pair:
             map.entrySet()) {
            System.out.println(pair.getValue() + " " + pair.getKey());
        }
    }
}

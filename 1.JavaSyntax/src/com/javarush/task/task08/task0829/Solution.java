package com.javarush.task.task08.task0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* 
Модернизация ПО
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, String> map = new HashMap<>();
        while (true) {
            String city = reader.readLine();
            if (city.isEmpty()) {
                break;
            }
            String family = reader.readLine();
            if (family.isEmpty()) {
                break;
            }

            map.put(city, family);
        }

        // Read the house number
        String city = reader.readLine();

        if (!city.isEmpty()) {
            String familyName = map.get(city);
            System.out.println(familyName);
        }
    }
}

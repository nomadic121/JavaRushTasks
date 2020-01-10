package com.javarush.task.task08.task0817;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static Map<String, String> createMap() {
        //напишите тут ваш код
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put("lastname" + i, "firstname");
        }
        return map;
        }


    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        //напишите тут ваш код
        Map<String, String> mapcopy = new HashMap<>(map);
        int count = 0;
        for (Map.Entry<String, String> pair1 : mapcopy.entrySet()) {
            for (Map.Entry<String, String> pair2 : map.entrySet()) {
                if (pair1.getValue().equals(pair2.getValue())) {
                    count++;
                }
            }
            if (count > 1) {
                removeItemFromMapByValue(map, pair1.getValue());
            }
            count = 0;
        }

    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {

    }
}

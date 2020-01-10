package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.Map;

/* 
Перепись населения
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

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        //напишите тут ваш код
        int count = 0;

        for (Map.Entry<String, String> m : map.entrySet()) {
            if (m.getValue().equals(name)) count++;
        }
        return count;

    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        //напишите тут ваш код
        int count = 0;

        for (Map.Entry<String, String> m : map.entrySet()){
            if (m.getKey().equals(lastName)) count++;
        }
        return count;

    }

    public static void main(String[] args) {

    }
}

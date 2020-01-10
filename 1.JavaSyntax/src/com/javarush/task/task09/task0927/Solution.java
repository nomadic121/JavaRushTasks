package com.javarush.task.task09.task0927;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        //напишите тут ваш код
        Map<String, Cat> result =  new HashMap<>();
        for (int i = 0; i < 10; i++) {
            result.put("name " + i, new Cat("name " + i));
        }
        return result;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        //напишите тут ваш код
        Set<Cat> result = new HashSet<>();
        for (Map.Entry<String, Cat> m :
                map.entrySet()) {
            result.add(m.getValue());
        }
        return result;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}

package com.javarush.task.task05.task0504;


/* 
Трикотаж
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Cat name1, name2, name3;

        name1 = new Cat("barsik", 2, 3, 4);
        name2 = new Cat("murzik", 3, 2, 3);
        name3 = new Cat("tigra", 5, 4, 6);
    }

    public static class Cat {
        private String name;
        private int age;
        private int weight;
        private int strength;

        public Cat(String name, int age, int weight, int strength) {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.strength = strength;
        }
    }
}
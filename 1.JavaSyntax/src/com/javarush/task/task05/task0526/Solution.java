package com.javarush.task.task05.task0526;

/* 
Мужчина и женщина
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Man man1 = new Man("Tim", 25, "Str 1");
        Man man2 = new Man("Tom", 54, "Str 2");
        Woman woman1 = new Woman("Anna", 54, "Street 1");
        Woman woman2 = new Woman("Kate", 19, "Street 2");

        System.out.println(man1.name + " " + man1.age + " " + man1.address);
        System.out.println(man1.name + " " + man1.age + " " + man1.address);
        System.out.println(woman1.name + " " + woman1.age + " " + woman1.address);
        System.out.println(woman2.name + " " + woman2.age + " " + woman2.address);
    }

    //напишите тут ваш код
    public static class Man {
        public String name, address;
        public int age;

        public Man (String name, int age, String address){
            this.name = name;
            this.age = age;
            this.address = address;
        }
    }

    public static class Woman {
        public String name, address;
        public int age;

        public Woman (String name, int age, String address){
            this.name = name;
            this.age = age;
            this.address = address;
        }
    }
}

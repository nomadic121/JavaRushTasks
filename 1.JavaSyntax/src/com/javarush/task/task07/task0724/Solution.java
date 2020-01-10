package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        List<Human> humans = new LinkedList<>();
        humans.add(new Human("GF1", true, 70));
        humans.add(new Human("GF2", true, 70));
        humans.add(new Human("GM1", false, 70));
        humans.add(new Human("GM2", false, 70));
        humans.add(new Human("F1", true, 40, humans.get(0), humans.get(2)));
        humans.add(new Human("M1", false, 40, humans.get(1), humans.get(3)));
        humans.add(new Human("C1", false, 10, humans.get(4), humans.get(5)));
        humans.add(new Human("C2", false, 10, humans.get(4), humans.get(5)));
        humans.add(new Human("C3", true, 10, humans.get(4), humans.get(5)));

        humans.stream().forEach(System.out::println);
    }

    public static class Human {
        // напишите тут ваш код
        String name;
        int age;
        boolean sex;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age,  Human father, Human mother) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.father = father;
            this.mother = mother;
        }

        public Human(String name, boolean sex, int age) {
            this(name,sex, age, null, null);
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null) {
                text += ", отец: " + this.father.name;
            }

            if (this.mother != null) {
                text += ", мать: " + this.mother.name;
            }

            return text;
        }
    }
}
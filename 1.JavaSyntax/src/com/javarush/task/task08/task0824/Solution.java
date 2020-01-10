package com.javarush.task.task08.task0824;

import java.util.ArrayList;
import java.util.List;

/* 
Собираем семейство
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код

        ArrayList<Human> childs = new ArrayList<>();

        childs.add(new Human("c1", 1, false));
        childs.add(new Human("c2", 2, true));
        childs.add(new Human("c3", 3, false));

        ArrayList<Human> parents = new ArrayList<>();

        parents.add(new Human("p1", 25, true, childs));
        parents.add(new Human("p2", 25, false, childs));

        ArrayList<Human> gparents = new ArrayList<>();
        gparents.add(new Human ("gp1", 60, true, parents.get(0)));
        gparents.add(new Human ("gp2", 60, false, parents.get(0)));
        gparents.add(new Human ("gp3", 64, false, parents.get(1)));
        gparents.add(new Human ("gp3", 64, false, parents.get(1)));

        ArrayList<Human> all = new ArrayList<>();
        all.addAll(childs);
        all.addAll(parents);
        all.addAll(gparents);

        for (Human x: all
             ) {
            System.out.println(x.toString());
        }
    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;

        public Human (String name, int age, boolean sex, ArrayList<Human> children) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.children = new ArrayList<Human>();
            this.children.addAll (children);
        }

        public Human (String name, int age, boolean sex, Human children) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.children = new ArrayList<Human>();
            this.children.add(children);
        }

        public Human (String name, int age, boolean sex){
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.children = new ArrayList<Human>();
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.children == null)
                return text;
            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}

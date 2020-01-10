package com.javarush.task.task06.task0614;

import java.util.ArrayList;

/* 
Статические коты
*/

public class Cat {
    //напишите тут ваш код
    public static ArrayList<Cat> cats;

    public Cat() {
    }

    public static void main(String[] args) {
        //напишите тут ваш код
        cats = new ArrayList();
        for (int i = 0; i < 10; i++) cats.add(new Cat());
        printCats();
    }

    public static void printCats() {
        //напишите тут ваш код
        for (int i = 0; i < 10; i++) System.out.println(cats.get(i));
    }
}

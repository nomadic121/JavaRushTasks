package com.javarush.task.task05.task0517;

/* 
Конструируем котиков
*/

public class Cat {
    //напишите тут ваш код
    String name;
    int age;
    int weight;
    String address;
    String color;

    public Cat(){
        //this.name;
        this.age = 1;
        this.weight = 2;
        //this.address;
        this.color = "white";
    }
    public Cat(String name){
        this.name = name;
        this.age = 1;
        this.weight = 2;
        //this.address;
        this.color = "white";
    }
    public Cat(String name, int weight, int age){
        this.name = name;
        this.age = age;
        this.weight = weight;
        //this.address;
        this.color = "white";
    }
    public Cat(String name, int age){
        this.name = name;
        this.age = age;
        this.weight = 2;
        //this.address;
        this.color = "white";
    }
    public Cat(int weight, String color){
        //this.name;
        this.age = 1;
        this.weight = weight;
        //this.address;
        this.color = color;
    }
    public Cat(int weight, String color, String address){
        //this.name;
        this.age = 1;
        this.weight = weight;
        this.address = address;
        this.color = color;
    }

    public static void main(String[] args) {

    }
}

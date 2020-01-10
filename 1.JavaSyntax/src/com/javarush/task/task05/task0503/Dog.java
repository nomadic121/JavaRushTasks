package com.javarush.task.task05.task0503;


/* 
Геттеры и сеттеры для класса Dog
*/

public class Dog {
    //напишите тут ваш код
    String name;
    int age;

    public void setName (String s){
        this.name = s;
    }
    public String getName (){
        return this.name;
    }

    public void setAge (int x){
        this.age = x;
    }

    public int getAge() {
        return this.age;
    }

    public static void main(String[] args) {

    }
}

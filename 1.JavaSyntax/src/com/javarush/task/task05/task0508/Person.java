package com.javarush.task.task05.task0508;

/* 
Геттеры и сеттеры для класса Person
*/

public class Person {
    //напишите тут ваш код
    String name;
    int age;
    char sex;

    public void setName (String s){
        name = s;
    }

    public String getName() {
        return name;
    }

    public void setAge (int x){
        age = x;
    }
    public int getAge (){
        return age;
    }

    public void setSex (char s){
        sex = s;
    }
    public char getSex (){
        return sex;
    }

    public static void main(String[] args) {

    }
}

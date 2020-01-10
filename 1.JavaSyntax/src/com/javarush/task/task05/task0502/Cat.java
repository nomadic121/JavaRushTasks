package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        //напишите тут ваш код
        int t = 0, a = 0;
        if (this.age > anotherCat.age){
            t++;
        } else if (this.age != anotherCat.age) a++;
        if (this.weight > anotherCat.weight){
            t++;
        } else if (this.weight != anotherCat.weight) a++;
        if (this.strength > anotherCat.strength){
            t++;
        } else if (this.strength != anotherCat.strength) a++;

        if (t > a){
            return true;
        } else return false;
    }

    public static void main(String[] args) {

    }
}

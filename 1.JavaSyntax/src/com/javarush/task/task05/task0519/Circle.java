package com.javarush.task.task05.task0519;

/* 
Ходим по кругу
*/


public class Circle {
    //напишите тут ваш код
    int centerX, centerY, radius, width, color;

    public Circle (int x, int y, int rad){
        this.centerX = x;
        this.centerY = y;
        this.radius = rad;
    }
    public Circle (int x, int y, int rad, int width){
        this.centerX = x;
        this.centerY = y;
        this.radius = rad;
        this.width = width;
    }
    public Circle (int x, int y, int rad, int width, int color){
        this.centerX = x;
        this.centerY = y;
        this.radius = rad;
        this.width = width;
        this.color = color;
    }

    public static void main(String[] args) {

    }
}

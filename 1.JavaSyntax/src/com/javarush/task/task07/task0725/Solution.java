package com.javarush.task.task07.task0725;

/* 
Переставь один модификатор static
*/

public class Solution {
    public static final int A = 5;
    public static final int B = 2;
    public static final  int C = A * B;

    public static void main(String[] args) {
    }

    public int getValue() {
        return C;
    }
}

package com.javarush.task.task15.task1517;

/* 
Статики и исключения
*/

public class Solution {
    public static int A = 0;

    static {
        //throw an exception here - выбросьте эксепшн тут
//        if (true)throw new Exception("");
        int c = 25/0;
    }

    public static int B = 5;

    public static void main(String[] args) /*throws Exception*/ {
        System.out.println(B);
    }

//    public Solution() throws Exception{}
}

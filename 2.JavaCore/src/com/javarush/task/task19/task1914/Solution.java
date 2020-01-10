package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream origin = System.out;
        ByteArrayOutputStream buff = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(buff);
        System.setOut(ps);

        testString.printSomething();

        System.setOut(origin);
        System.out.println(calculate(buff.toString().replaceAll(System.lineSeparator(), "")));

    }

    private static String calculate(String input) {
        String[] splited =  input.split(" ");
        String result = null;
        if ("-".equals(splited[1])) {
            result = input + (Integer.parseInt(splited[0]) - Integer.parseInt(splited[2]));
        }
        if ("+".equals(splited[1])) {
            result =  input + (Integer.parseInt(splited[0]) + Integer.parseInt(splited[2]));
        }
        if ("*".equals(splited[1])) {
            result =  input + (Integer.parseInt(splited[0]) * Integer.parseInt(splited[2]));
        }
        return result;
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}


package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream origin = System.out;
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stream));

        testString.printSomething();

        System.setOut(origin);

        printStream (stream);
    }

    private static void printStream(ByteArrayOutputStream stream) {
        String[] str = stream.toString().split(System.lineSeparator());
        for (int i = 1; i <= str.length; i++) {
            System.out.println(str[i - 1]);
            if (i % 2 == 0) {
                System.out.println("JavaRush - курсы Java онлайн");
            }
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}

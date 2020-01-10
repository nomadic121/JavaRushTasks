package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {

        private long index;

        private int age;

        private double height;

        private int weight;

        private String firstName;

        private String lastName;

        public Human () {

        }

        public Human(int index) {
            this.index = index;
        }

        public Human(int index, int age) {
            this.index = index;
            this.age = age;
        }

        public Human(int index, int age, int height) {
            this.index = index;
            this.age = age;
            this.height = height;
        }

        public Human(int index, int age, int height, int weight) {
            this.index = index;
            this.age = age;
            this.height = height;
            this.weight = weight;
        }

        public Human(int index, int age, int height, int weight, String firstName) {
            this.index = index;
            this.age = age;
            this.height = height;
            this.weight = weight;
            this.firstName = firstName;
        }

        public Human(int index, int age, int height, int weight, String firstName, String lastName) {
            this.index = index;
            this.age = age;
            this.height = height;
            this.weight = weight;
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Human(int index, int height, String firstName) {
            this.index = index;
            this.height = height;
            this.firstName = firstName;
        }

        public Human(long index, int age, double height, int weight, String firstName, String lastName) {
            this.index = index;
            this.age = age;
            this.height = height;
            this.weight = weight;
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Human(long index) {
            this.index = index;
        }

        // Напишите тут ваши переменные и конструкторы
    }
}

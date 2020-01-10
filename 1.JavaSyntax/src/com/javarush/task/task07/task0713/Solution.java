package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<Integer> numbers3 = new ArrayList<>();
        ArrayList<Integer> numbers2 = new ArrayList<>();
        ArrayList<Integer> numbersOthers = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 20; i++) {
            int buff;
            buff = Integer.parseInt(reader.readLine());
            numbers.add(buff);
            if (buff % 3 == 0) numbers3.add(buff);
            if (buff % 2 == 0) numbers2.add(buff);
            if (buff % 3 != 0 && buff % 2 != 0) numbersOthers.add(buff);
        }

        printList(numbers3);
        printList(numbers2);
        printList(numbersOthers);
    }

    public static void printList(ArrayList<Integer> list) {
        //напишите тут ваш код
            for (int x : list) {
                System.out.println(x);
            }
    }
}

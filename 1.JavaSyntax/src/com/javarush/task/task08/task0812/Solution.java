package com.javarush.task.task08.task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
//        ArrayList<Integer> count = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(Integer.parseInt(reader.readLine()));
//            count.add(1);
        }
//        for (int i = 0; i < 9; i++) {
//            for (int j = 1; j < 10; j++) {
//                if (list.get(i) == list.get(j)){
//                    count.set(i, count.get(i) + 1);
//                } else break;
//            }
//        }
//        int max = 0;
//        for (int i: count) {
//            if (max < i) max = i;
//        }
        int max = 0, count = 1;
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 10; j++) {
                if (list.get(i).equals(list.get(j))){
                    count++;
                } else break;
            }
            if (max < count) max = count;
            count = 1;
        }
//        if (max == 0) max = 1;
        System.out.println(max);

    }
}
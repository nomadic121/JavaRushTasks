package com.javarush.task.task07.task0716;

import java.util.ArrayList;
import java.util.Iterator;

/* 
Р или Л
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("роза");
        strings.add("лоза");
        strings.add("лира");
        strings = fix(strings);

        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> strings) {
        //напишите тут ваш код
        for (int i = 0; i < strings.size(); i++) {
            String s = strings.get(i);
            if (s.contains("р") && s.contains("л")){
                //strings.remove(i);
            } else if (s.contains("р")){
                strings.remove(i);
                i--;
            } else if (s.contains("л")){
                strings.add(i, strings.get(i));
                i++;
            }
        }
        return strings;
    }
}
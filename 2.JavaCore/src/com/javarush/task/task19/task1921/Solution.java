package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
//        args = new String[]{"C:\\temp\\text.txt"};
        BufferedReader fileReader = new BufferedReader (new FileReader(args[0]));

        while (fileReader.ready()) {
            StringTokenizer buff = new StringTokenizer(fileReader.readLine());
            String name = "";
            int day = -1;
            int month = -1;
            int year = -1;
            while (buff.hasMoreTokens()) {
                String token = buff.nextToken();
                if (token.matches("\\d+")) {
                    if (day < 0 ) day = Integer.parseInt(token);
                    else if (month < 0 ) month = Integer.parseInt(token);
                    else if (year < 0 ) year = Integer.parseInt(token);
                } else {
                    name = name +  token + " ";
                }
            }
            PEOPLE.add(new Person(name.trim(), new Date(year - 1900, month - 1, day)));
        }
        fileReader.close();
//        PEOPLE.stream().forEach(Solution::print);
    }

    private static void print(Person person) {
        System.out.print(person.getName());
        System.out.print("#");
        System.out.print(person.getBirthDate().toString());
        System.out.println();
    }
}

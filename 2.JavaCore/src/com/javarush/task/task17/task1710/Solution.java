package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
//        crud(new String[] {"-u", "0", "name", "ж", "01/09/1994"});
        crud(args);
//        crud(new String[] {"-i", "0"});
    }

    private static Date parseDate(String s) {
//        String[] sDate = s.split("/");
//        return new Date(Integer.parseInt(sDate[2]), Integer.parseInt(sDate[1]) - 1, Integer.parseInt(sDate[0]));
        try {
            return new SimpleDateFormat("dd/MM/y", Locale.ENGLISH).parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Sex parseSex(String s) {
        if ("м".equals(s)) {
            return Sex.MALE;
        }
        if ("ж".equals(s)) {
            return Sex.FEMALE;
        }
        return null;
    }

    private static String  sexToString (Sex sex) {
        if (sex != null) return  (sex == Sex.FEMALE) ? "ж" : "м";
        return null;
    }

    private static void crud(String[] args) {
        if ("-c".equals(args[0])) {
            if (parseSex(args[2]) == Sex.FEMALE) {
                allPeople.add(Person.createFemale(args[1], parseDate(args[3])));
            } else {
                allPeople.add(Person.createMale(args[1], parseDate(args[3])));
            }
            System.out.println(allPeople.size() - 1);
        } else if ("-u".equals(args[0])) {
            int id = Integer.parseInt(args[1]);
            allPeople.get(id).setName(args[2]);
            allPeople.get(id).setSex(parseSex(args[3]));
            allPeople.get(id).setBirthDate(parseDate(args[4]));
        } else if ("-d".equals(args[0])) {
            int id = Integer.parseInt(args[1]);
            allPeople.get(id).setName(null);
            allPeople.get(id).setSex(null);
            allPeople.get(id).setBirthDate(null);
        } else if ("-i".equals(args[0])) {
            int id = Integer.parseInt(args[1]);
            System.out.println(String.format(Locale.ENGLISH,
                    "%s %s %td-%tb-%tY",
                    allPeople.get(id).getName(),
                    sexToString(allPeople.get(id).getSex()),
                    allPeople.get(id).getBirthDate(),
                    allPeople.get(id).getBirthDate(),
                    allPeople.get(id).getBirthDate()
            ));
        }
    }

}

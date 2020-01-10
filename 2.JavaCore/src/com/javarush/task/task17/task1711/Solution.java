package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        switch (args[0]) {
            case ("-c"):
                synchronized (allPeople) {
                    for (int i = 4; i <= args.length; i += 3) {
                        allPeople.add(createPerson(Arrays.copyOfRange(args, i - 3, i)));
                        System.out.println(allPeople.size() - 1);
                    }
                }
                break;
            case ("-u"):
                synchronized (allPeople) {
                    for (int i = 5; i <= args.length; i += 4) {
                        updatePerson(Arrays.copyOfRange(args, i - 4, i));
                    }
                }
                break;
            case ("-d"):
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        int id = Integer.parseInt(args[i]);
                        deletePerson(id);
                    }
                }
                break;
            case ("-i"):
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        int id = Integer.parseInt(args[i]);
                        readPerson(id);
                    }
                }
                break;
        }
//        crud(args);
//        crud(new String[]{"-u", "0", "uupd", "ж", "01/09/1994", "1", "upd", "ж", "01/09/1994"});
//        crud(new String[]{"-c", "crt", "ж", "01/09/1994", "crt", "ж", "01/09/1994"});
//        crud(new String[] {"-d", "0", "1"});
//        crud(new String[] {"-i", "0", "1"});
//        crud(new String[] {"-i", "2", "3"});
    }

//    private static void crud(String[] args) {
//        switch (args[0]) {
//            case ("-c"):
//                synchronized (allPeople) {
//                    for (int i = 4; i <= args.length; i += 3) {
//                        allPeople.add(createPerson(Arrays.copyOfRange(args, i - 3, i)));
//                        System.out.println(allPeople.size() - 1);
//                    }
//                }
//                break;
//            case ("-u"):
//                synchronized (allPeople) {
//                    for (int i = 5; i <= args.length; i += 4) {
//                        updatePerson(Arrays.copyOfRange(args, i - 4, i));
//                    }
//                }
//                break;
//            case ("-d"):
//                synchronized (allPeople) {
//                    for (int i = 1; i < args.length; i++) {
//                        int id = Integer.parseInt(args[i]);
//                        deletePerson(id);
//                    }
//                }
//                break;
//            case ("-i"):
//                synchronized (allPeople) {
//                    for (int i = 1; i < args.length; i++) {
//                        int id = Integer.parseInt(args[i]);
//                        readPerson(id);
//                    }
//                }
//                break;
//        }
//
//    }

    private static Person createPerson(String[] args) {
        if (parseSex(args[1]) == Sex.FEMALE) {
            return Person.createFemale(args[0], parseDate(args[2]));
        } else {
            return Person.createMale(args[0], parseDate(args[2]));
        }
    }

    private static void updatePerson(String[] args) {
        int id = Integer.parseInt(args[0]);
        allPeople.get(id).setName(args[1]);
        allPeople.get(id).setSex(parseSex(args[2]));
        allPeople.get(id).setBirthDate(parseDate(args[3]));
    }

    private static void deletePerson(int id) {
        allPeople.get(id).setName(null);
        allPeople.get(id).setSex(null);
        allPeople.get(id).setBirthDate(null);
    }

    private static void readPerson(int id) {
        System.out.println(String.format(Locale.ENGLISH,
                "%s %s %td-%tb-%tY",
                allPeople.get(id).getName(),
                sexToString(allPeople.get(id).getSex()),
                allPeople.get(id).getBirthDate(),
                allPeople.get(id).getBirthDate(),
                allPeople.get(id).getBirthDate()
        ));
    }

    private static Date parseDate(String s) {
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

    private static String sexToString(Sex sex) {
        if (sex != null) return (sex == Sex.FEMALE) ? "ж" : "м";
        return null;
    }

}
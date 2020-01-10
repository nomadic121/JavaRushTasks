package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("Сталлоне", dateFormat.parse("MAY 1 2012"));

        //напишите тут ваш код
        map.put("Салоне", dateFormat.parse("MAY 5 2013"));
        map.put("Стаоне", dateFormat.parse("MAY 1 2012"));
        map.put("Саллоне", dateFormat.parse("MAY 7 2012"));
        map.put("Сллоне", dateFormat.parse("MAY 1 2017"));
        map.put("Сталон", dateFormat.parse("MAY 11 2012"));
        map.put("Стллоне", dateFormat.parse("MAY 22 2002"));
        map.put("Сталоне", dateFormat.parse("MAY 16 2000"));
        map.put("Сталлое", dateFormat.parse("MAY 14 2011"));
        map.put("Сталлон", dateFormat.parse("MAY 4 2013"));

        return map;
    }

    public static void removeAllSummerPeople(Map<String, Date> map) {
        //напишите тут ваш код
        DateFormat dateFormat = new SimpleDateFormat("M");

        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Date> entry = (Map.Entry<String, Date>) iterator.next();
            String date = entry.getValue().toString();
            if (date.contains("Jun") || date.contains("Jul") || date.contains("Aug")){
                iterator.remove();
            }
        }

    }

    public static void main(String[] args) {

    }
}
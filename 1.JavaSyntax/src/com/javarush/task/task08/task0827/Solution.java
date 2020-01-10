package com.javarush.task.task08.task0827;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date) {
        Date dateParsed = null;
        try {
            dateParsed = new SimpleDateFormat("MMMM d yyyy", Locale.ENGLISH).parse(date);
            dateParsed.setYear(-1900);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String day = new SimpleDateFormat("D", Locale.ENGLISH).format(dateParsed);
        return (Integer.parseInt(day) % 2) == 1;
    }
}

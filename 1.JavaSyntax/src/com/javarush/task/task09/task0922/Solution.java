package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Date dateParsed = null;
        SimpleDateFormat parseFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        try {
            dateParsed = parseFormat.parse(
                    reader.readLine()
//                    "2013-08-18"

            );
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH).format(dateParsed).toUpperCase());
    }
}
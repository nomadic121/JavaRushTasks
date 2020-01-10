package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Номер месяца
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String month = reader.readLine();

        Calendar calendar = new GregorianCalendar();
        Map<String, Integer> set = calendar.getDisplayNames(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH);

        int monthnumber = 0;
        for (Map.Entry<String, Integer> x: set.entrySet()){
            if (x.getKey().equals(month))
                monthnumber = x.getValue().intValue() + 1;
        }

        String s;
        s = month + " is the " + monthnumber + " month";
        System.out.println(s);
    }
}

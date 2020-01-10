package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null || telNumber.isEmpty()) return false;

        //6
        if (telNumber.matches("\\p{L}+")) return false;
        //7
        if (telNumber.substring(telNumber.length()).matches("\\D")) return false;
        //1
        if (telNumber.charAt(0) == '+'
                && telNumber.replaceAll("\\D", "").length() != 12) return false;
        //2
        if ((telNumber.substring(0, 1).matches("\\d") || telNumber.indexOf("(") == 0)
                && telNumber.replaceAll("\\D", "").length() != 10) return false;
        //3
        if (telNumber.matches("--") || telNumber.replaceAll("[^-]", "").length() > 2) return false;
        //4
        if (telNumber.replaceAll("[^()]", "").length() > 2) return false;

        if (telNumber.indexOf("(") >= 0 || telNumber.indexOf(")") >= 0) {
            if ((telNumber.indexOf("(") != telNumber.indexOf(")") - 4)) return false; //5
            if (telNumber.indexOf("-") > 0 && (telNumber.indexOf(")") > telNumber.indexOf("-"))) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("+380501234567" + " - " + checkTelNumber("+380501234567"));
        System.out.println("+38(050)1234567" + " - " + checkTelNumber("+38(050)1234567"));
        System.out.println("+38050123-45-67" + " - " + checkTelNumber("+38050123-45-67"));
        System.out.println("050123-4567" + " - " + checkTelNumber("050123-4567"));
        System.out.println("+38)050(1234567" + " - " + checkTelNumber("+38)050(1234567"));
        System.out.println("+38(050)1-23-45-6-7" + " - " + checkTelNumber("+38(050)1-23-45-6-7"));
        System.out.println("050ххх4567" + " - " + checkTelNumber("050ххх4567"));
        System.out.println("050123456" + " - " + checkTelNumber("050123456"));
        System.out.println("(0)501234567" + " - " + checkTelNumber("(0)501234567"));
//
//        System.out.println("+3-8(050)1234567" + " - " + checkTelNumber("+38(050)1234567"));
//
//        System.out.println("+3-8(050)1234567".indexOf("(") + " : " + ("+3-8(050)1234567".indexOf(")") - 4));
//        System.out.println("+3-8(050)1234567".replaceAll("\\(", ""));


    }
}





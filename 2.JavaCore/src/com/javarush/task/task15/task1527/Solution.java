package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        System.out.println(urlParser.parseParams(s));
        urlParser.printObj();
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }

    public static class urlParser {
        private static String objValue = null;
        private static String allparams = "";

        public static String parseParams (String s){
            String result = "";
            s = s.substring(s.indexOf("?") + 1, s.length() - 1);
            for (String params : s.split("&")){
                String key = "", value = "";
                if (params.contains("=")) {
                    key = params.split("=")[0];
                    value = params.split("=")[1];
                } else {
                    key = params;
                    value = "";
                }

                result += key + " ";
                if (key.equals("obj")) objValue = value;
            }
            return result;
        }

        public static void printObj (){
            if (objValue != null) {
                try {
                    double d = Double.parseDouble(objValue);
                    alert(d);
                } catch (NumberFormatException e) {
                    alert(objValue);
                }
            }
        }

//        public static void parse(String s) {
//            char[] url;
//            url = s.toCharArray();
//            boolean p = false, v = false;
//            String param = "", value = "";
//
//            for (int i = 0; i < url.length; i++) {
//
//                if ('&' == url[i]) allparams += param + " ";
//                if (i == url.length - 1) allparams += param;
//
//                if ('?' == url[i] || '&' == url[i]) {
//                    p = true;
//                    v = false;
//                    if (param.equals("obj")) {
//                        objValue = value;
//                    }
//                    param = "";
//                    value = "";
//                    i++;
//                }
//                if ('=' == url[i]) {
//                    p = false;
//                    v = true;
//                    i++;
//                }
//                if (p) {
//                    param += url[i];
//                }
//                if (v) {
//                    value += url[i];
//                }
//            }
//            System.out.println(allparams);
//
//            if (objValue != null) {
//                try {
//                    double d = Double.parseDouble(objValue);
//                    alert(d);
//                } catch (NumberFormatException e) {
//                    alert(objValue);
//                }
//            }
//        }
    }
}
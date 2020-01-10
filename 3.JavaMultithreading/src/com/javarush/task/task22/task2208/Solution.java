package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> pr = new HashMap<>();
        pr.put("name", "Ivanov");
        pr.put("country", "Ukraine");
        pr.put("city", "Kiev");
        pr.put("agenull", null);
        pr.put("age", "null");
        pr.put("agelast", "null");

        System.out.print(getQuery(pr) + "#\n");
        System.out.print(getQuery(null) + "#\n");
        System.out.print(getQuery(new HashMap<>()) + "#\n");

    }
    public static String getQuery(Map<String, String> params) {
        if (params == null || params.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (Map.Entry<String, String> pair: params.entrySet()){
//            if (!pair.getValue().equals("null")) {
//            if (pair.getValue() != null && !pair.getValue().equals("null")) {
            if (pair.getValue() != null && pair.getKey() != null) {
                sb
                        .append(pair.getKey())
                        .append(" = \'")
                        .append(pair.getValue())
                        .append("\'");
                if (count < params.size() - 1) sb.append(" and ");
            }
            count++;
        }
        return sb.length() > 0 ? sb.toString() : "";
    }
}

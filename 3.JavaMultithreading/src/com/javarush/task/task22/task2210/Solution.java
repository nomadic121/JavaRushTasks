package com.javarush.task.task22.task2210;

import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {

    }
    public static String [] getTokens(String query, String delimiter) {
        List<String> result = new LinkedList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(query, delimiter);
        while (stringTokenizer.hasMoreElements()){
            result.add(stringTokenizer.nextToken());
        }
        return result.toArray(new String[result.size()]);
    }
}

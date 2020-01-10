package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //...
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        BufferedReader file = new BufferedReader(new FileReader(fileName));

//        StringBuilder result = getLine(new String[] {"Киев", "Нью-Йорк", "Амстердам",  "Вена", "Мельбурн"});
        StringBuilder result = getLine(file.readLine().trim().split(" "));
        System.out.println(result.toString());
        reader.close();
        file.close();
    }

    public static StringBuilder getLine(String... words) {
        if (words == null || words.length == 0) return new StringBuilder();
        List<String> wordsSources = new LinkedList<>();

        for (String w : words) {
            wordsSources.add(w);
        }

        List<String> wordsLine = new LinkedList<>();

        while (!wordsSources.isEmpty()) {
            ListIterator<String> iter = wordsSources.listIterator();
            while (iter.hasNext()) {
                if (insertWord(wordsLine, iter.next())) {
                    iter.remove();
                }
            }

        }

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (String element :
                wordsLine) {
            sb.append(element);
            if (count < wordsLine.size() - 1) {
                sb.append(" ");
            }
            count++;
        }
        return sb;
    }

    private static boolean insertWord(List<String> wordsLine, String word) {
        if (wordsLine.isEmpty()) {
            wordsLine.add(word);
//            System.out.println("insert first: " + word);
            return true;
        }
        for (int i = 0; i < wordsLine.size(); i++) {
            String current = wordsLine.get(i).toLowerCase();
            String next = null;
            if (i + 1 < wordsLine.size()) {
                next = wordsLine.get(i + 1).toLowerCase();
            }

            if (current.charAt(current.length() - 1) == word.toLowerCase().charAt(0)) {
                if (next != null && next.charAt(0) == word.toLowerCase().charAt(word.length() - 1)) {
                    wordsLine.add(i + 1, word); //or i+1
//                    System.out.println("insert " + word +  " center: " + current + " " + word + " " + next);
//                    System.out.println("# " + wordsLine);
                    return true;
                }
                if (next == null) {
                    wordsLine.add(word); //or i+1
//                    System.out.println("insert " + word +  " forward: " + current + " " + word + " " + next);
//                    System.out.println("# " + wordsLine);
                    return true;
                }
            }
            if (i == 0 && current.charAt(0) == word.toLowerCase().charAt(word.length() - 1)) {
                wordsLine.add(i, word); //or i+1
//                System.out.println("insert " + word +  " back: " + word + " " + current + " " + next);
//                System.out.println("# " + wordsLine);
                return true;
            }
        }
        return false;
    }
}

// C:\\temp\\text.txt
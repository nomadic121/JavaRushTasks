package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
        List<String> words = new LinkedList<>();

        while (file.ready()) {
            for (String word : file.readLine().split(" ")) {
                words.add(word);
            }
        }

        for (int i = 0; i < words.size(); i++) {
            for (int j = i + 1; j < words.size(); j++) {
//                if (reflectWorld(currentWorld).equals(secondWorld)) {
                String currentWorld = words.get(i);
                String secondWorld = words.get(j);
                if (currentWorld != secondWorld &&
                        new StringBuilder(currentWorld).reverse().toString().equals(secondWorld)) {
                    Pair pair = new Pair();
                    pair.first = currentWorld;
                    pair.second = secondWorld;
                    if (!result.contains(pair)) result.add(pair);
                }
            }
        }

        result.stream().forEach(System.out::println);

    }

    private static String reflectWorld(String currentWorld) {
        StringBuilder sb = new StringBuilder(currentWorld);
        return sb.reverse().toString();
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}

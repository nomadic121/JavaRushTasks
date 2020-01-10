package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        List<Word> match = detectAllWords(crossword, "home", "same", "lgm",  "sgr");
        match.stream().forEach(System.out::println);
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */

        System.out.println(scanLine("basetestbasestringsofsbaseubstringbase", "base"));
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> result = new LinkedList<>();
        for (String word : words) {
            scanHorizontal(crossword, word, result);
            scanVertical(crossword, word, result);
            scanDiagonal(crossword, word, result);
        }
        return result;
    }
//X horozontal
//Y vertical
    private static void scanHorizontal(int[][] crossword, String word, List<Word> result) {
        String[] lines = new String[crossword.length];
        for (int i = 0; i < lines.length; i++) {
            lines[i] = getStringFromIntArray(crossword[i]);
            List<Integer> coord = scanLine (lines[i], word);
            if (!coord.isEmpty()) {
                for (int j = 0; j < coord.size(); j++) {
                    Word findedWord = new Word(word);
                    findedWord.setStartPoint(coord.get(j), i);
                    findedWord.setEndPoint(coord.get(j) + word.length() - 1, i);
                    result.add(findedWord);
                }
            }
        }
    }

    private static void scanVertical(int[][] crossword, String word, List<Word> result) {
        String[] lines = new String[crossword[0].length];
        for (int i = 0; i < lines.length; i++) {
            int[] l = new int[crossword.length];
            for (int j = 0; j < crossword.length; j++) {
                l[j] = crossword[j][i];
            }
            lines[i] = getStringFromIntArray(l);
        }
        for (int i = 0; i < lines.length; i++) {
            List<Integer> coord = scanLine (lines[i], word);
            if (!coord.isEmpty()) {
                for (int j = 0; j < coord.size(); j++) {
                    Word findedWord = new Word(word);
                    findedWord.setStartPoint(i , coord.get(j));
                    findedWord.setEndPoint(i, coord.get(j) + word.length() - 1);
                    result.add(findedWord);
                }
            }
        }
    }

    private static void scanDiagonal(int[][] crossword, String word, List<Word> result) {
        String[] lines = new String[2];
        int diagonalLineLenght = crossword.length < crossword[0].length ? crossword.length : crossword[0].length;
        int[] l = new int[crossword.length];
        for (int j = 0; j < diagonalLineLenght; j++) {
            l[j] = crossword[j][j];
        }
        lines[0] = getStringFromIntArray(l);
        for (int j = 0; j < diagonalLineLenght; j++) {
            l[j] = crossword[crossword.length - j - 1][j];
        }
        lines[1] = getStringFromIntArray(l);

        List<Integer> coord = scanLine (lines[0], word);
        if (!coord.isEmpty()) {
            for (int j = 0; j < coord.size(); j++) {
                Word findedWord = new Word(word);
                findedWord.setStartPoint(coord.get(j), coord.get(j));
                findedWord.setEndPoint(coord.get(j) + word.length() - 1, coord.get(j) + word.length() - 1);
                result.add(findedWord);
            }
        }
        coord.clear();
        coord = scanLine (lines[1], word);
        if (!coord.isEmpty()) {
            for (int j = 0; j < coord.size(); j++) {
                Word findedWord = new Word(word);
                findedWord.setStartPoint(coord.get(j), coord.get(j) + word.length() - 1);
                findedWord.setEndPoint(coord.get(j) + word.length() - 1, coord.get(j));
                result.add(findedWord);
            }
        }
    }

    private static List<Integer> scanLine(String line, String word) {
        List<Integer> coords = new ArrayList<>();
        int offset = 0;
        int globalOffset = 0;
        while ((offset >= 0) && (globalOffset < line.length() - 1)){
            offset = line.substring(globalOffset).indexOf(word);
            if (offset >= 0){
                globalOffset += offset;
                coords.add(globalOffset++);
            }
        }
        return coords;
    }

    private static String getStringFromIntArray(int[] line) {
        String result = "";
        for (int x : line) {
            result += (char) x;
        }
        return result;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}

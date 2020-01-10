package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
//        args = new String[] {"C:\\temp\\text.txt", "C:\\temp\\text2.txt"};
        BufferedReader fileReader = new BufferedReader (new FileReader(args[0]));
        FileWriter fileWriter = new FileWriter(args[1]);

        while (fileReader.ready()){
            String[] buff = fileReader.readLine().split("[\\p{Z}]+");
            for (String word: buff ) {
                if (isMatch(word)){
                    fileWriter.write(word + " ");
                }
            }
        }

        fileReader.close();
        fileWriter.close();
    }

    private static boolean isMatch(String word) {
        return word.matches(".*[\\p{N}]+.*");
    }
}

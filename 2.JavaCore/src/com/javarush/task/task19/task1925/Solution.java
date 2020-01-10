package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
//        args = new String[] {"C:\\temp\\text.txt", "C:\\temp\\text2.txt"};
        BufferedReader fileReader = new BufferedReader (new FileReader(args[0]));
        FileWriter fileWriter = new FileWriter(args[1]);

        StringBuilder sbOut = new StringBuilder();
        while (fileReader.ready()){
            String[] buff = fileReader.readLine().split("[\\p{Z}]+");
            for (String word: buff ) {
                if (isMatch(word)){
                    sbOut
                            .append(word)
                            .append(",");
                }
            }
        }
        fileWriter.write(sbOut.toString().substring(0, sbOut.length() - 1));

        fileReader.close();
        fileWriter.close();
    }

    private static boolean isMatch(String word) {
        return word.length() > 6;
    }

}

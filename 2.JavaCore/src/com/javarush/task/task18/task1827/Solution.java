package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) throws Exception {
//        args = new String[4];
//        args[0] = "-c";
//        args[1] = "name";
//        args[2] = "159.00";
//        args[3] = "12";

        if (args != null && args.length == 4 && "-c".equals(args[0])) {
            makeMagic(Arrays.copyOfRange(args, 1, args.length));
        }
    }

    private static void makeMagic (String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();
        BufferedReader fileIn = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
        int maxId = getMaxIdFromFile(fileIn);
        fileIn.close();
        FileOutputStream fileOut = new FileOutputStream(filename, true);
        writeProductToFile (fileOut, maxId + 1, args);
        fileOut.close();
    }

    private static void writeProductToFile(FileOutputStream fileOut, int id, String[] product) throws IOException {
        StringBuilder sb = new StringBuilder(8+30+8+4);
        sb
                .append(System.lineSeparator())
                .append(String.valueOf(id))
                .append(getSpaces(8 - String.valueOf(id).length()))
                .append(product[0])
                .append(getSpaces(30 - product[0].length()))
                .append(product[1])
                .append(getSpaces(8 - product[1].length()))
                .append(product[2])
                .append(getSpaces(4 - product[2].length()));
        fileOut.write(sb.toString().getBytes());
    }

    private static String getSpaces(int count) {
        String str = "";
        for (int i = 0; i < count; i++) {
            str += " ";
        }
        return str;
    }

    private static int getMaxIdFromFile(BufferedReader fileIn) throws IOException {
        int maxId = 0;
        while (fileIn.ready()) {
            int buff = Integer.parseInt (fileIn.readLine().substring(0, 8).trim());
            maxId = maxId > buff ? maxId : buff;
        }
        return maxId;
    }

}

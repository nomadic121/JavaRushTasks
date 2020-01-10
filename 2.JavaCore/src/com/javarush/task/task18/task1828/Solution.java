package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
//        args = new String[5];
//        args[0] = "-u";
//        args[1] = "19847";
//        args[2] = "name";
//        args[3] = "159.00";
//        args[4] = "12";

//        args = new String[2];
//        args[0] = "-d";
//        args[1] = "19847";

        if (args != null && args.length == 4 && "-c".equals(args[0])) {
            addProduct(Arrays.copyOfRange(args, 1, args.length));
        }
        if (args != null && args.length == 5 && "-u".equals(args[0])) {
            updateProduct(Arrays.copyOfRange(args, 1, args.length), false);
        }
        if (args != null && args.length == 2 && "-d".equals(args[0])) {
            updateProduct(Arrays.copyOfRange(args, 1, args.length), true);
        }
    }

    private static void updateProduct(String[] args, boolean deleteProduct) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();
        BufferedReader fileIn = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
        StringBuilder sb = new StringBuilder();
        while (fileIn.ready()) {
            String buff = fileIn.readLine();
            if (buff.split(" ")[0].trim().equals(args[0].trim())) {
                if (!deleteProduct) {
                    buff = createFormattedProductLine(args);
                } else {
                   continue;
                }
            }
            sb
                    .append(buff)
                    .append(System.lineSeparator());
        }
        fileIn.close();
        FileOutputStream fileOut = new FileOutputStream(filename, false);
        fileOut.write(sb.toString().getBytes());
        fileOut.close();
    }

    private static String createFormattedProductLine(int id, String[] args) {
        StringBuilder sb = new StringBuilder(8 + 30 + 8 + 4);
        sb
                .append(String.valueOf(id))
                .append(getSpaces(8 - String.valueOf(id).length()))
                .append(args[0])
                .append(getSpaces(30 - args[0].length()))
                .append(args[1])
                .append(getSpaces(8 - args[1].length()))
                .append(args[2])
                .append(getSpaces(4 - args[2].length()));
        return sb.toString();
    }

    private static String createFormattedProductLine(String[] args) {
        return createFormattedProductLine(Integer.parseInt(args[0].trim()), Arrays.copyOfRange(args, 1, args.length));
    }

    private static void addProduct(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();
        BufferedReader fileIn = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
        int maxId = getMaxIdFromFile(fileIn);
        fileIn.close();
        FileOutputStream fileOut = new FileOutputStream(filename, true);
        writeProductToFile(fileOut, maxId + 1, args);
        fileOut.close();
    }

    private static void writeProductToFile(FileOutputStream fileOut, int id, String[] args) throws IOException {
        fileOut.write((System.lineSeparator() + createFormattedProductLine(id, args)).getBytes());
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
            int buff = Integer.parseInt(fileIn.readLine().substring(0, 8).trim());
            maxId = maxId > buff ? maxId : buff;
        }
        return maxId;
    }
}

package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {

    private final static int CODE_KEY = 4;

    public static void main(String[] args) throws IOException {
        if ("-e".equals(args[0])) {
            FileInputStream in = new FileInputStream(args[1]);
            FileOutputStream out = new FileOutputStream(args[2]);
            encryptFile(in, out);
            in.close();
            out.close();
        }

        if ("-d".equals(args[0])) {
            FileInputStream in = new FileInputStream(args[1]);
            FileOutputStream out = new FileOutputStream(args[2]);
            decryptFile(in, out);
            in.close();
            out.close();
        }

    }

    private static void encryptFile (final FileInputStream in, final FileOutputStream out) throws IOException {
        while (in.available() > 0) {
            out.write(in.read() + CODE_KEY);
        }
    }

    private static void decryptFile (final FileInputStream in, final FileOutputStream out) throws IOException {
        while (in.available() > 0) {
            out.write(in.read() - CODE_KEY);
        }
    }

}

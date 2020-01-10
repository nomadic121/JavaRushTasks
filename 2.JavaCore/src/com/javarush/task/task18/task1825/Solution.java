package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        SortedSet<String> files = new TreeSet<>();

        while (true) {
            String path = reader.readLine();
            if (path.equals("end")) {
                break;
            } else {
                files.add(path);
            }
        }
        reader.close();

        String foPath = "";
        String[] temp = files.first().split("\\.");
        for (int i = 0; i < temp.length - 1; i++) {
            foPath += temp[i];
            if (i < temp.length - 2) foPath += ".";
        }

        FileOutputStream fo = new FileOutputStream(foPath);

        for (String fileName : files) {
            FileInputStream fi = new FileInputStream(fileName);
            byte[] buff = new byte[fi.available()];
            int count = fi.read(buff);
            fi.close();
            fo.write(buff, 0, count);
            fo.flush();
        }
        fo.close();
    }
}

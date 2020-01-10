package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<FileInputStream> files = new LinkedList<>();

        while (true) {
            String name = reader.readLine();
            try {
                files.add(new FileInputStream(name));
            } catch (FileNotFoundException e) {
                System.out.println(name);
                for (FileInputStream f :
                        files) {
                    f.close();
                }
                break;
            }
        }
        reader.close();
    }
}

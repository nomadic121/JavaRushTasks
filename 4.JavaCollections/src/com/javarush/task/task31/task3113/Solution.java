package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/* 
Что внутри папки?
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputPath = reader.readLine();
        Path path = Paths.get(inputPath);
        if (Files.isRegularFile(path)) {
            System.out.println(path.toAbsolutePath().toString() + " - не папка");
        } else {
//            System.out.println(path.toString());
            CounterFileVisitor visitor = new CounterFileVisitor();
            Files.walkFileTree(path, visitor);
            System.out.println("Всего папок - " + visitor.getFoldersCount());
            System.out.println("Всего файлов - " + visitor.getFilesCount());
            System.out.println("Общий размер - " + visitor.getFilesSize());
        }
    }

}

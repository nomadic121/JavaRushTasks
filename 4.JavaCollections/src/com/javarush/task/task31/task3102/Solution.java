package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/* 
Находим все файлы
*/
public class Solution {

    public static List<String> getFileTree(String root) throws IOException {
        List<String> result = new LinkedList<>();
        Queue<File> queue = new LinkedBlockingQueue<>();
        queue.add(new File(root));

        while (!queue.isEmpty()) {
            for (File file :
                    queue.poll().listFiles()) {
                if (file.isDirectory()) {
                    queue.add(file);
                } else {
                    result.add(file.getAbsolutePath());
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
//        getFileTree("/Users/rustam/Dropbox/java/JavaRushTasks/out/production/4.JavaCollections").stream().forEach(System.out::println);
    }

}

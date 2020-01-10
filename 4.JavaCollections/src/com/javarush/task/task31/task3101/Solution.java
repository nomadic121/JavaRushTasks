package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

/*
Проход по дереву файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);

        if (FileUtils.isExist(resultFileAbsolutePath)) {
            FileUtils.renameFile(resultFileAbsolutePath, new File(resultFileAbsolutePath.getParentFile().getAbsolutePath() + "/allFilesContent.txt"));
        } else {
            resultFileAbsolutePath = new File(resultFileAbsolutePath.getParentFile().getAbsolutePath() + "/allFilesContent.txt");
        }

        Map<String, File> filesList = new TreeMap<>();
        getAllFiles(path, filesList);

        FileOutputStream out = new FileOutputStream(resultFileAbsolutePath);
        for (Map.Entry<String, File> element :
                filesList.entrySet()) {
            byte[] data = new byte[(int)element.getValue().length()];
            FileInputStream in = new FileInputStream(element.getValue());
            int length = in.read(data);
            out.write(data, 0, length);
            out.write("\n".getBytes());
            in.close();
        }
        out.close();
    }

    private static void getAllFiles(File path, Map<String, File> filesList) {
        for (File file : path.listFiles()) {
            if (file.isDirectory()) {
                getAllFiles(file, filesList);
            } else if (file.length() <= 50) {
                filesList.put(file.getName(), file);
            }
        }
    }

}

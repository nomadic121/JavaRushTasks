package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String name = reader.readLine();
            if (name.equals("exit")) break;
            new ReadThread(name).start();
        }
        reader.close();
//        System.out.println(resultMap);

    }

    public static class ReadThread extends Thread {
        private String fileName;
        private Integer maxByte;
        private FileInputStream file;

        public ReadThread(String fileName) throws FileNotFoundException {
            //implement constructor body
            this.fileName = fileName;
            file = new FileInputStream(fileName);
        }

        // implement file reading here - реализуйте чтение из файла тут
        public void run() {
            int[] bytesSet = new int[256];
            try {
                while (file.available() > 0) {
                    int x = file.read();
                    bytesSet[x]++;
                }
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < bytesSet.length; i++) {
                if (max < bytesSet[i]) {
                    max = bytesSet[i];
                    maxByte = i;
                }
            }
            resultMap.put(fileName, maxByte);
        }
    }
}

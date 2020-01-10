package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
//        String sConsole = "C:\\temp\\text.txt\nC:\\temp\\result.txt\n";
//        byte[] bytes = sConsole.getBytes();
//        InputStream inputStream = new ByteArrayInputStream(bytes);
//        System.setIn(inputStream);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fn1 = reader.readLine();
        String fn2 = reader.readLine();
        FileInputStream fi1 = new FileInputStream(fn1);
        FileInputStream fi2 = new FileInputStream(fn2);

        FileData fd1 = new FileData(fi1);
        FileData fd2 = new FileData(fi2);

        fi1.close();
        fi2.close();

        FileOutputStream fo1 = new FileOutputStream(fn1, false);

        FileData.writeToFile(fo1, fd2);
        FileData.writeToFile(fo1, fd1);

        fo1.close();
    }

    public static class FileData {
        private int count;
        private byte[] buff;

        public int getCount() {
            return count;
        }

        public byte[] getBuff() {
            return buff;
        }

        public FileData(FileInputStream file) throws IOException {
            buff = new byte[file.available()];
            this.count = file.read(buff, 0, file.available());
        }

        public static void writeToFile(FileOutputStream fos, FileData fd) throws IOException {
            fos.write(fd.getBuff(), 0, fd.getCount());
        }
    }
}

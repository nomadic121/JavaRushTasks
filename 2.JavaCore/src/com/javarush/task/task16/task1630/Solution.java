package com.javarush.task.task16.task1630;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here - добавьте код тут
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут
    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private String FileName;
        private String FileContent = "";

        @Override
        public void setFileName(String fullFileName) {
            FileName = fullFileName;
        }

        @Override
        public String getFileContent() {
            return FileContent;
        }

        public void run() {
            String temp = "";
            try {
                BufferedReader fileReader = new BufferedReader(new FileReader(FileName));

                while (temp != null) {
                    if (FileContent.isEmpty()) {
                        FileContent = temp;
                    } else {
                        FileContent = FileContent + " " + temp;
                    }
                    temp = fileReader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
            }
        }
    }
}

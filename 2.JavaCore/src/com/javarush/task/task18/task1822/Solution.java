package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

//        String sConsole = "C:\\temp\\result.txt\n";
//        byte[] bytes = sConsole.getBytes();
//        InputStream inputStream = new ByteArrayInputStream(bytes);
//        System.setIn(inputStream);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file = new FileInputStream(reader.readLine());
        BufferedReader filereader = new BufferedReader(new InputStreamReader(file));
        String line;
        while (filereader.ready()) {
            line = filereader.readLine();
            String[] lines = line.split(" ");
            if (lines[0].equals(args[0])){
                System.out.println(line);
                break;
            }
        }
        filereader.close();
        file.close();
        reader.close();
    }
}

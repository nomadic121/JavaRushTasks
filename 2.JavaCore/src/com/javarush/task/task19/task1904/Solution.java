package com.javarush.task.task19.task1904;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException {
//        File f = new File("C:\\temp\\text.txt");
//        Scanner file = new Scanner(f);
//        PersonScannerAdapter personScannerAdapter = new PersonScannerAdapter(file);
//        System.out.println(personScannerAdapter.read().toString());
    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String[] line  = fileScanner.nextLine().split(" ");

            Calendar cal = Calendar.getInstance();
            cal.clear();

            cal.set(Calendar.YEAR, Integer.parseInt(line[5]));
            cal.set(Calendar.MONTH, Integer.parseInt(line[4]) - 1);
            cal.set(Calendar.DATE, Integer.parseInt(line[3]));

            return new Person(line[1], line[2], line[0], cal.getTime());
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}

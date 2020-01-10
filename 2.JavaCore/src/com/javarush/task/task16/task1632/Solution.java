package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new Thread(new InfinityThread()));
        threads.add(new Thread(new InterruptedExceptionThread()));
        threads.add(new Thread(new UraThread()));
        threads.add(new MessageThread());
        threads.add(new Thread(new ReadThread()));
    }

    public static void main(String[] args) {
    }

    public static class InfinityThread implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
//                    e.printStackTrace();
                }
            }
        }

    }

    public static class InterruptedExceptionThread implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException");
                }
            }
        }

    }

    public static class UraThread implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("Ура");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
//                    e.printStackTrace();
                }
            }
        }

    }

    public static class MessageThread extends Thread implements Message {

        private boolean live = true;

        @Override
        public void run() {
            while (live) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
//                    e.printStackTrace();
                }
            }
        }

        @Override
        public void showWarning() {
//            if (Thread.currentThread().isAlive()) Thread.currentThread().interrupt();
//            this.interrupt();
            live = false;
        }

    }

    public static class ReadThread implements Runnable {

        @Override
        public void run() {
            int sum = 0;
            String input;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                try {
                    input = reader.readLine();
                    if ("N".equals(input)) break;
                    sum += Integer.parseInt(input);
                } catch (IOException e) {
//                    e.printStackTrace();
                }
            }
            System.out.println(sum);
        }
    }

}
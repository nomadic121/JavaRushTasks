package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println(new Solution(4));

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("/Users/rustam/Downloads/temp/test.txt"));
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("/Users/rustam/Downloads/temp/test.txt"));

        Solution savedObject = new Solution(40);
        out.writeObject(savedObject);
        out.flush();

        Solution loadedObject = new Solution (30);
        loadedObject = (Solution) in.readObject();

        System.out.println(savedObject.string.equals(loadedObject.string));

        in.close();
        out.close();

    }

    private final transient String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}

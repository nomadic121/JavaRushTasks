package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.IntStream;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputStream input = new FileInputStream(reader.readLine());
        reader.close();
        this.load(input);
//        new Solution().load(input);
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        for (Map.Entry<String, String> element: properties.entrySet()) {
            Properties prop = new Properties();
            prop.setProperty(element.getKey(), element.getValue());
            prop.store(outputStream, "");
        }
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties prop = new Properties();
        while (inputStream.available() > 0) {
            prop.load(inputStream);
            for (Map.Entry<Object, Object> element: prop.entrySet()) {
                 properties.put((String)element.getKey(), (String)element.getValue());
            }
        }

    }

    public static void main(String[] args) {

    }
}

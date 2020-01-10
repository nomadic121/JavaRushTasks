package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    private String fileName;
    private transient FileOutputStream stream;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
//        out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.stream = new FileOutputStream(fileName, true);
//        in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Solution sol1 = new Solution("test.txt");
        try {
            sol1.writeObject("test string!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("your.file.name"));
        out.writeObject(sol1);
        out.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("your.file.name"));
        Solution sol2 = (Solution) in.readObject();
        try {
            sol2.writeObject("test string 2!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        in.close();
    }
}

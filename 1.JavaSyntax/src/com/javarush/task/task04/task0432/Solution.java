package com.javarush.task.task04.task0432;



/* 
Хорошего много не бывает
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        int count, i = 0;
        s = reader.readLine();
        count = Integer.parseInt(reader.readLine());

        while (i < count){
            System.out.println(s);
            i++;
        }

    }
}

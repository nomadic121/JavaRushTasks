package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int x, y, min, nod = 1;

//        try {
            x = Integer.parseInt(reader.readLine());
            y = Integer.parseInt(reader.readLine());

            if(x <= 0) throw new Exception();
            if(y <= 0) throw new Exception();

            min = x < y ? x : y;

            for (int i = 1; i <= min; i++) {
                if (x % i == 0 && y % i == 0) nod = i;
            }

            System.out.println(nod);

//        } catch (NumberFormatException e) {
//            e.printStackTrace();
////            throw e;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }
}

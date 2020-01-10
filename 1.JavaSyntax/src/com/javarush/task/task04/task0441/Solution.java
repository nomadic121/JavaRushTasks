package com.javarush.task.task04.task0441;


/* 
Как-то средненько
*/
import java.io.*;
import java.lang.reflect.Array;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int a,b,c;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        a = Integer.parseInt(reader.readLine());
        b = Integer.parseInt(reader.readLine());
        c = Integer.parseInt(reader.readLine());

        //if (a == b && b == c) System.out.println(a);

        int[] numbers = {a,b,c};

        Solution.shakerSort(numbers);

        System.out.println(numbers[1]);


    }
    public static void shakerSort(int array[]) {
        int buff;
        int left=0;
        int right=array.length-1;
        do {
            for (int i=left; i<right;i++) {
                if (array[i]>array[i+1]) {
                    buff = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = buff;
                }
            }
            right--;
            for (int i=right; i>left; i--) {
                if (array[i]<array[i-1]) {
                    buff = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = buff;
                }
            }
            left++;
        } while (left <right);
    }
}

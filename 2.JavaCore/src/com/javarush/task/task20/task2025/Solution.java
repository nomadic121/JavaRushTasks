package com.javarush.task.task20.task2025;

import java.util.*;

/*
Алгоритмы-числа
*/
public class Solution {

    public static void main(String[] args) {
        System.out.println("for -1 : " + Arrays.toString(getNumbers(-1)));
        System.out.println("for 0 : " + Arrays.toString(getNumbers(0)));
        System.out.println("for 1 : " + Arrays.toString(getNumbers(1)));
        System.out.println("for 9 : " + Arrays.toString(getNumbers(9)));
        System.out.println("for 10 : " + Arrays.toString(getNumbers(10)));
        System.out.println("for Long.MAX_VALUE : ");
        long[] result;
        long start = System.currentTimeMillis();
        result = getNumbers(Long.MAX_VALUE);
        System.out.println("time : " + (System.currentTimeMillis() - start) + " ms");
        System.out.println("numbers : ");
        System.out.println(Arrays.toString(result));
        if (result != null) System.out.println("generated count : " + result.length);
        
        long[] test = {
                1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 153L, 370L, 371L, 407L, 1634L, 8208L, 9474L,
                54748L, 92727L, 93084L, 548834L, 1741725L, 4210818L, 9800817L, 9926315L,
                24678050L, 24678051L, 88593477L, 146511208L, 472335975L, 534494836L,
                912985153L, 4679307774L, 32164049650L, 32164049651L, 40028394225L,
                42678290603L, 44708635679L, 49388550606L, 82693916578L,
                94204591914L, 28116440335967L, 4338281769391370L,
                4338281769391371L, 21897142587612075L, 35641594208964132L,
                35875699062250035L, 1517841543307505039L, 3289582984443187032L,
                4498128791164624869L, 4929273885928088826L};

        System.out.println("#Armstrong array count: " + test.length);
        List<Long> testList = new ArrayList<>();
        for (int i = 0; i < test.length; i++) testList.add(test[i]);

        List<Long> resultList = new ArrayList<>();
        for (int i = 0; i < result.length; i++) resultList.add(test[i]);

        List<Long> different = new ArrayList<>();
        System.out.println("#Different: " + "не хватает :");
        different.addAll(testList);
        different.removeAll(resultList);
        System.out.println(different.toString());

        System.out.println("#Different: " + " лишние :");
        different.clear();
        different.addAll(resultList);
        different.removeAll(testList);
        System.out.println(different.toString());
    }

    public static long[] getNumbers(long N) {
        long[] result = new long[0];
        if (N > 1) {
            armstrongHash.clear();
            inputNumber = N;
            int base = ((int) Math.log10(N)) + 1;
            recursiveGenerateDigitsHash(base);

            result = new long[armstrongHash.size()];
            int i = 0;
            for (long element : armstrongHash) {
                result[i] = element;
                i++;
            }
        }
        return result;
    }

    private static long inputNumber = 0;
    private static Set<Long> armstrongHash = new TreeSet<>();

    private static void recursiveGenerateDigitsHash (int digitExponent) {
        recursiveGenerateDigitsHash(0, digitExponent, 0);
    }

    private static void recursiveGenerateDigitsHash(long digitCurrent, int digitExponent, int digitLimit) {
        if (digitExponent == 0 ){
            for (int i = digitLimit; i <= 10; i++) {
                long x;
                if (i == 10) {
                    x = getSubNumbersMultiplySumMath(digitCurrent);
                    if (x < inputNumber && isArmstrongNumber(x)) {
                        armstrongHash.add(x);
                    }
                    x = getSubNumbersMultiplySumMath(digitCurrent * 100);
                    if (x < inputNumber && isArmstrongNumber(x)) {
                        armstrongHash.add(x);
                    }
                }
                x = getSubNumbersMultiplySumMath(digitCurrent + i);
                if (x < inputNumber && isArmstrongNumber(x)) {
                    armstrongHash.add(x);
                }
            }
        } else {
            for (int i = digitLimit; i < 10; i++) {
                recursiveGenerateDigitsHash(digitCurrent * 10 + digitLimit * 10, digitExponent - 1, i);
            }
        }
    }

    private static long getSubNumbersMultiplySumMath (long i) {
        long result = 0;
        long x = i;
        int exp = ((int) Math.log10(x)) + 1;
        do {
            int digit = (int) (x % 10);
            long temp = 1;
            for (int j = 0; j < exp; j++) {
                temp = temp * digit;
            }
            result += temp;
//            result += (long) Math.pow(digit, exp);
            x = x / 10;
        } while (x != 0);
        return result;
    }

    private static boolean isArmstrongNumber(long i) {
        return i == getSubNumbersMultiplySumMath(i);
    }

}
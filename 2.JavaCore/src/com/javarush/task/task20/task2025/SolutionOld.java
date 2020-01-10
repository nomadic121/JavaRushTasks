package com.javarush.task.task20.task2025;

import java.util.*;

/*
Алгоритмы-числа
*/
public class SolutionOld {

    private static long numCount;

    public static void main(String[] args) {
        long[] result;
        long start = System.currentTimeMillis();
        result = getNumbers(Long.MAX_VALUE);
//        result = getNumbers(3);
        System.out.println("time : " + (System.currentTimeMillis() - start) + " ms");
        System.out.println("numbers : ");
        System.out.println(Arrays.toString(result));
        if (result != null) System.out.println("length: " + result.length);

//        long[] test = new long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 153L, 370L, 371L, 407L, 1634L, 8208L, 9474L, 54748L,
//                92727L, 93084L, 548834L, 1741725L, 4210818L, 9800817L, 9926315L, 24678050L, 24678051L, 88593477L, 146511208L,
//                472335975L, 534494836L, 912985153L, 4679307774L, 32164049650L, 32164049651L, 40028394225L, 42678290603L, 44708635679L,
//                49388550606L, 82693916578L, 94204591914L, 28116440335967L, 4338281769391370L, 4338281769391371L, 21897142587612075L,
//                35641594208964132L, 35875699062250035L, 1517841543307505039L, 3289582984443187032L, 4498128791164624869L, 4929273885928088826L};

        long[] test = {
                1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407, 1634, 8208, 9474,
                54748, 92727, 93084, 548834, 1741725, 4210818, 9800817, 9926315,
                24678050, 24678051, 88593477, 146511208, 472335975, 534494836,
                912985153, 4679307774L, 32164049650L, 32164049651L, 40028394225L,
                42678290603L, 44708635679L, 49388550606L, 82693916578L,
                94204591914L, 28116440335967L, 4338281769391370L,
                4338281769391371L, 21897142587612075L, 35641594208964132L,
                35875699062250035L, 1517841543307505039L, 3289582984443187032L,
                4498128791164624869L, 4929273885928088826L};

        System.out.println("#Armstrong array count: " + test.length);

        LinkedList<Long> different = new LinkedList<>();
        for (int i = 0; i < test.length; i++) different.add(test[i]);
        different.removeAll(armstrongHash);
        System.out.println("#Different: ");
        different.stream().forEach(System.out::println);
    }

    public static long[] getNumbers(long N) {
        long[] result = null;
        if (N > 1) {
            int base = ((int) Math.log10(N)) + 1;
            recursiveGenerateDigitsHash(base);

            for (long element : numbersHash) {
                long x = getSubNumbersMultiplySumMath(element);
                if (x < N && isCorrect(x)) {
                    armstrongHash.add(x);
                }
            }

            result = new long[armstrongHash.size()];
            int i = 0;
            for (long element : armstrongHash) {
                result[i] = element;
                i++;
            }
        }
        return result;
    }

    private static List<Long> numbersHash = new ArrayList<>();
    private static Set<Long> armstrongHash = new TreeSet<>();

    private static void recursiveGenerateDigitsHash (int digitExponent) {
        recursiveGenerateDigitsHash(0, digitExponent, 0);
    }

    private static void recursiveGenerateDigitsHash(long digitCurrent, int digitExponent, int digitLimit) {
        if (digitExponent == 0 ){
            for (int i = digitLimit; i <= 10; i++) {
                if (i == 10) numbersHash.add(digitCurrent);
                numbersHash.add(digitCurrent + i);
                numCount++;
//                System.out.println("generated: " + (digitCurrent + i));
                if (2880 == digitCurrent + i) System.out.println("generated: 2880");
            }
        } else {
            for (int i = digitLimit; i < 10; i++) {
                recursiveGenerateDigitsHash(digitCurrent * 10 + digitLimit * 10, digitExponent - 1, i);
//                recursiveGenerateDigitsHash(digitCurrent * 10 + digitLimit * 10, digitExponent - 1, i == 0 ? 0 : i - 1);
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

    private static boolean isCorrect(long i) {
        return i == getSubNumbersMultiplySumMath(i);
    }

    private static long getSubNumbersMultiplySum(long i) {
        String s = String.valueOf(i);
        long number = 0;
        for (int j = 0; j < s.length(); j++) {
            long part = Long.parseLong(String.valueOf(s.charAt(j)));
            number += (long) Math.pow(part, s.length());
        }
        return number;
    }

}

//#8208
//2880
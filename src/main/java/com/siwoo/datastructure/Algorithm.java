package com.siwoo.datastructure;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Algorithm {
    private int[] intArray;
    private Scanner in = new Scanner(new BufferedInputStream(System.in));

    public static void main(String[] args) {
        Algorithm chapter1 = new Algorithm(1,2,3,4,5);
//        System.out.println(chapter1.max());
//        System.out.println(chapter1.min());
//        System.out.println(chapter1.mid());
//        System.out.println(mid(1, 2, 3));
//        System.out.println(mid(2, 3, 1));
//        System.out.println(mid(3, 2, 1));
//        System.out.println(mid(3, 1, 2));
//        System.out.println(chapter1.sum(10));
//        System.out.println(chapter1.sum(8));
//        System.out.println(sumOf(3, 5));
//        System.out.println(sumOf(6, 4));

//        System.out.println(chapter1.getSumFromInput());
        //System.out.println(chapter1.subtractValueFromInput());
//        System.out.println(chapter1.getDigitsFromInput());
        chapter1.printMultiplicationTable();
        chapter1.printSquare(5);
    }

    private void printSquare(int lengthOfSide) {
        for (int col = 0; col < lengthOfSide; col++) {
            for (int row = 0; row < lengthOfSide; row++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    final int LAST_NUM = 9;

    interface Operation {
        int execute(int a, int b);
    }

    public void printTable(Operation op) {
        printMultiplicationTableHeader();
        for (int i = 1; i <= LAST_NUM; i++) {
            System.out.printf("%3d|", i);
            for (int j = 1; j <= LAST_NUM; j++)
                System.out.printf("%3d", op.execute(i, j));
            System.out.println();
        }
    }

    private void printAddTable() {
        printTable((a,b) -> a + b);
    }

    private void printMultiplicationTable() {
        printTable((a,b) -> a * b);
    }

    private void printMultiplicationTableHeader() {
        System.out.print("   |");
        for (int i = 1; i <= LAST_NUM; i++) {
            System.out.printf("%3d", i);
        }
        System.out.println("\n---+---------------------------");
    }

    private int getDigitsFromInput() {
        int num = in.nextInt();
        return getDigits(num);
    }

    private int getDigits(int num) {
        int digits = 0;
        while (num > 0) {
            digits++;
            num /= 10;
        }
        return digits;
    }

    private int subtractValueFromInput() {
        int to, from;
        to = in.nextInt();
        do {
            from = in.nextInt();
            if (from <= to) {
                System.out.println("Input bigger value than " + to);
            }
        } while (from <= to);
        return from - to;
    }

    public Algorithm(int... intArray) {
        this.intArray = intArray;
    }

    public int min() {
        return getMinOrMax((min, el) -> min > el);
    }

    public int max() {
        return getMinOrMax((max, el) -> max < el);
    }

    public int mid() {
        int[] copied = new int[intArray.length];
        System.arraycopy(intArray, 0, copied, 0, intArray.length);
        Arrays.sort(copied);
        int mid = (0 + intArray.length - 1) / 2;
        return copied[mid];
    }

//    public int sum(final int lastInt) {
//        int sum = 0;
////        int i = 1;
////        while (i <= lastInt) {
////            sum += i++;
////        }
//        for (int i = 1; i <= lastInt; i++)
//            sum += i;
//        return sum;
//    }

    public int getSumFromInput() {
        int input;
        do {
            input = in.nextInt();
        } while (input <= 0);
        return sum(input);
    }

    public int sum(final int n) {
        boolean even = n % 2 == 0;
        if (even)
            return (1 + n) * (n / 2);
        else
            return sum(n - 1) + n;
    }

    public static int sumOf(int a, int b) {
        int from = a < b ? a : b;

        int to = a > b ? a : b;
        int sum = 0;
        for (int i = from; i <= to; i++) {
            sum += i;
        }
        return sum;
    }

    public static int mid(int a, int b, int c) {
        if (a >= b)
            if (a <= c)
                return a;
            else if (b >= c)
                return b;
            else
                return c;
        else if (a > c)
            return a;
        else if (b > c)
            return c;
        else
            return b;
    }

    @FunctionalInterface
    interface Comparing {
        boolean test(Integer minOrMax, Integer el);
    }

    private int getMinOrMax(Comparing comparing) {
        if (intArray.length < 1) {
            throw new IllegalStateException();
        }
        int result = intArray[0];
        for (int i = 1; i < intArray.length; i++) {
            if (comparing.test(result, intArray[i])) {
                result = intArray[i];
            }
        }
        return result;
    }
}

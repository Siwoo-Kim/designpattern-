package com.siwoo.datastructure;

public class Array {
    private int[] intArray = {1, 2, 3, 4, 5};

    public static void main(String[] args) {
        Array array = new Array();
        int[] b = array.intArray.clone();
        b[3] = 0;

        array.printArray();
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + ", ");
        }
        System.out.println();
    }

    private void printArray() {
        for (int i = 0; i < intArray.length; i++)
            System.out.print(intArray[i] + ", ");
        System.out.println();
    }

}

package com.examples.array;

public class ArrayReverser {

    public static void main(String[] args) {
        int[] array = {10, 20, 30, 40, 50, 70, 90, 88};
        reverseArray(array);
        System.out.println("Reversed array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    public static void reverseArray(int[] array) {
        int startIndex = 0;
        int endIndex = array.length - 1;

        while (startIndex < endIndex) {
        	System.out.println("startIndex :: "+startIndex +", endIndex :: "+endIndex);
            // Swap the values
            int temp = array[startIndex];
            array[startIndex] = array[endIndex];
            array[endIndex] = temp;

            // Move indices towards the center
            startIndex++;
            endIndex--;
        }
    }
}
package com.examples.problems.array;

public class SecondLargestInArray {
    public static void main(String[] args) {
        // Initializing an array with values
        int[] numbers = {45, 86, 63, 29, 57, 90, 83, 39};

        // Initializing the largest and second largest numbers
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        
        // Looping through the array to find the largest and second largest numbers
        for (int number : numbers) {
            if (number > largest) {
                secondLargest = largest; // Update second largest
                largest = number; // Update largest
            } else if (number > secondLargest && number != largest) {
                secondLargest = number; // Update second largest if it's different from the largest
            }
        }

        // Displaying the second largest number
        System.out.println("The second largest number is: " + secondLargest);
    }
}
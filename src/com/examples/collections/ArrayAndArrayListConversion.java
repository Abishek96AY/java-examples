package com.examples.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayAndArrayListConversion {
    public static void main(String[] args) {
        // Step 1: Convert an array to an ArrayList
        String[] array = {"Java", "Python", "C++"};
        List<String> arrayList = new ArrayList<>(Arrays.asList(array));
        System.out.println("Array to ArrayList: " + arrayList);

        // Step 2: Convert an ArrayList to an array
        ArrayList<String> listOfLanguages = new ArrayList<>();
        listOfLanguages.add("JavaScript");
        listOfLanguages.add("TypeScript");
        listOfLanguages.add("Kotlin");
        String[] languageArray = listOfLanguages.toArray(new String[0]);
        System.out.println("ArrayList to Array: " + Arrays.toString(languageArray));
    }
}
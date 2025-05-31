package com.examples.string;

public class StringPermutations {
	public static void main(String[] args) {
        String input = "abc";
        generatePermutations(input, "");
        System.out.println("All permutations of " + input + " have been displayed.");
    }

    public static void generatePermutations(String input, String ans) {
        if (input.length() == 0) {
            System.out.println("ans :: "+ans);
            return;
        }

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            String remaining = input.substring(0, i) + input.substring(i + 1);
            System.out.println("remaining :: "+remaining+", ans + ch :: "+ans + ch);
            generatePermutations(remaining, ans + ch);
        }
    }
}

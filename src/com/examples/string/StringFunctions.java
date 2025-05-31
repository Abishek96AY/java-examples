package com.examples.string;

public class StringFunctions {

    public static void main(String[] args) {
        String str = "  Hello, Java World!  ";

        // 1. length()
        System.out.println("Length: " + str.length());

        // 2. substring()
        System.out.println("Substring (7, 11): " + str.substring(7, 11));

        // 3. charAt()
        System.out.println("Char at 1: " + str.charAt(1));

        // 4. indexOf(), lastIndexOf()
        System.out.println("Index of 'Java': " + str.indexOf("Java"));
        System.out.println("Last index of 'l': " + str.lastIndexOf('l'));

        // 5. contains()
        System.out.println("Contains 'World': " + str.contains("World"));

        // 6. equals(), equalsIgnoreCase()
        System.out.println("Equals 'Hello, Java World!': " + str.trim().equals("Hello, Java World!"));
        System.out.println("EqualsIgnoreCase '  hello, java world!  ': " + str.trim().equalsIgnoreCase("hello, java world!"));

        // 7. startsWith(), endsWith()
        System.out.println("Starts with '  He': " + str.startsWith("  He"));
        System.out.println("Ends with '!  ': " + str.endsWith("!  "));

        // 8. replace(), replaceAll()
        System.out.println("Replace 'Java' with 'Spring': " + str.replace("Java", "Spring"));
        System.out.println("ReplaceAll whitespace: " + str.replaceAll("\\s+", ""));

        // 9. toUpperCase(), toLowerCase()
        System.out.println("Uppercase: " + str.toUpperCase());
        System.out.println("Lowercase: " + str.toLowerCase());

        // 10. trim()
        System.out.println("Trimmed: '" + str.trim() + "'");

        // 11. split()
        String[] words = str.trim().split(" ");
        System.out.println("Split:");
        for (String word : words) {
            System.out.println("- " + word);
        }

        // 12. isEmpty(), isBlank() (Java 11+)
        String emptyStr = "   ";
        System.out.println("Is empty: " + emptyStr.isEmpty());
        System.out.println("Is blank: " + emptyStr.isBlank());
    }
}
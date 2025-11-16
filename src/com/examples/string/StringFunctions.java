package com.examples.string;

public class StringFunctions {

	public static void main(String[] args) {
		String str = "  Hello, Java World!  ";

		// 1. length()
		System.out.println("Length: " + str.length());

		// 2. substring()
		System.out.println("Substring (7, 11): " + str.substring(7, 11));

		// 3. charAt()
		System.out.println("Char at 5: " + str.charAt(5));

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

		// ================= Extra Important Interview Methods =================

		// 13. compareTo() (lexicographical comparison)
		System.out.println("CompareTo 'apple' vs 'banana': " + "apple".compareTo("banana")); // negative
		System.out.println("CompareTo 'banana' vs 'apple': " + "banana".compareTo("apple")); // positive
		System.out.println("CompareTo 'apple' vs 'apple': " + "apple".compareTo("apple")); // 0

		// 14. intern() (String pool)
		String a = new String("Java");
		String b = a.intern();
		String c = "Java";
		System.out.println("a == c: " + (a == c)); // false
		System.out.println("b == c: " + (b == c)); // true

		// 15. join() (Java 8+)
		String joined = String.join("-", "Java", "Spring", "Kafka");
		System.out.println("Joined: " + joined);

		// 16. format() (String formatting)
		String formatted = String.format("Name: %s, Age: %d", "Abishek", 30);
		System.out.println("Formatted: " + formatted);

		// 17. valueOf() (conversion to String)
		int num = 100;
		String numStr = String.valueOf(num);
		System.out.println("ValueOf int: " + numStr);

		// 18. matches() (regex full match)
		System.out.println("Matches digits: " + "12345".matches("\\d+")); // true
		System.out.println("Matches digits: " + "abc123".matches("\\d+")); // false

		// 19. Demonstrating Immutability
		String s1 = "Java";
		String s2 = s1;
		s1 = s1 + " World";
		System.out.println("s1: " + s1); // Java World
		System.out.println("s2: " + s2); // Java
	}
}
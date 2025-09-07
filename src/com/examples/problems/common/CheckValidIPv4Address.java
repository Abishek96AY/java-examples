package com.examples.problems.common;

import java.util.Arrays;

public class CheckValidIPv4Address {
	public static void main(String[] args) {

		String str = "255.181.01.22"; // test input

		boolean status = isValidIPv4WithStream(str);

		System.out.println(status ? "Valid" : "Invalid");
	}

	public static boolean isValidIPv4WithStream(String ip) {
		String str = "255.181.10.22"; // test input

        boolean status = Arrays.stream(str.split("\\."))
                .filter(part -> !part.isEmpty()) // no empty segments
                .filter(part -> !(part.length() > 1 && part.startsWith("0"))) // no leading zeros unless "0"
                .map(e -> Integer.parseInt(e)) // safely convert to int (invalid -> -1)
                .allMatch(num -> num >= 0 && num <= 255) && str.split("\\.").length == 4; // all in range & must be exactly 4 parts

        System.out.println(status ? "Valid" : "Invalid");
        return status;
	}

	public static boolean isValidIPv4WithOutStream(String ip) {
		String[] parts = ip.split("\\.");
		boolean status = true;

		// IPv4 must have exactly 4 parts
		if (parts.length != 4) {
			status = false;
		} else {
			for (String part : parts) {
				System.out.println("Part :: " + part);
				status = isValidPart(part);
				if (!status)
					break;
			}
		}

		return status;
	}

	public static boolean isValidPart(String str) {
		try {
			// Empty string is invalid
			if (str.isEmpty())
				return false;

			// Leading zeros check (allow "0", but not "01", "001")
			if (str.length() > 1 && str.startsWith("0"))
				return false;
			
			int num = Integer.parseInt(str);
			
			return num >= 0 && num <= 255;
		} catch (NumberFormatException e) {
			return false; // non-numeric parts
		}
	}
}
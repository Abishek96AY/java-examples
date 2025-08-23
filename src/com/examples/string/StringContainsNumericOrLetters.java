package com.examples.string;

public class StringContainsNumericOrLetters {
	public static boolean isEmpty(final CharSequence cs) {
		return cs == null || cs.length() == 0;
	}

	public static boolean isAlphanumeric(final CharSequence cs) {
		if (isEmpty(cs)) {
			return false;
		}
		final int sz = cs.length();
		for (int i = 0; i < sz; i++) {
			if (!Character.isLetterOrDigit(cs.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}
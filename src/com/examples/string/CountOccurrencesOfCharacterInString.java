package com.examples.string;

import java.util.HashMap;
import java.util.Map;

public class CountOccurrencesOfCharacterInString
{
	public static void method1()
	{
		String inputString = "Java is a widely used programming language. Java is versatile and has a large community.";
		Map<Character, Integer> characterCountMap = new HashMap<>();
		
		for (char c : inputString.toCharArray())
		{
			characterCountMap.put(c, characterCountMap.getOrDefault(c, 0) + 1);
		}
		System.out.println(characterCountMap);
	}
	
	public static void main(String[] args)
	{
		method1();
	}
}
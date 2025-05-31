package com.examples.string;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CountOccurrencesCharacter {
	public static void main(String[] args) {
		char[] obj = {'A', 'E', 'I', 'O', 'U', 'A'};
		Map<Character, Integer> mapObj = new LinkedHashMap<>();
		for (int i = 0; i < obj.length; i++) {
			mapObj.put(obj[i], mapObj.getOrDefault(obj[i], 0)+1);
		}
		
		System.out.println(mapObj);
		
		Map<Character, Integer> mapObj2 = IntStream.range(0, obj.length)
			    .mapToObj(i -> obj[i])
			    .collect(Collectors.toMap(
			        ch -> ch,
			        ch -> 1,
			        Integer::sum,
			        LinkedHashMap::new
			    ));
		
		System.out.println(mapObj2);
	}
}

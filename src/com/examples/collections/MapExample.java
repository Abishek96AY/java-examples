package com.examples.collections;

import java.util.HashMap;
import java.util.Map.Entry;

public class MapExample {

	public static void main(String[] args) {
		HashMap<String, Integer> mapObj = new HashMap<String, Integer>();
		
		mapObj.put("Abi", 1);
		mapObj.put("Yamuna", 2);
		
		for (Entry<String, Integer> obj : mapObj.entrySet()) {
			System.out.println(obj.getKey() + " , " + obj.getValue());
		}
		
		// Update MAP while iterate
		for (Entry<String, Integer> entry : mapObj.entrySet()) {
		    if (mapObj.containsKey("Abi")) {
		    	entry.setValue(entry.getValue() + 10);  // safe update
			}
		}
		
		mapObj.entrySet().stream()
	    .forEach(entry -> System.out.println(entry.getKey() + " , " + entry.getValue()));
	}
}
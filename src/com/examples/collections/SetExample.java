package com.examples.collections;

import java.util.Set;
import java.util.TreeSet;

public class SetExample {
	public static void main(String[] args) {
		Set<String> setObj = new TreeSet<>();
		
		setObj.add("Abi");
		setObj.add("Abi");
		
		for (String key : setObj) {
			System.out.println("Key :: " + key);
		}
		
		setObj.stream().forEach(e -> System.out.print("E : "+e));
	}
}
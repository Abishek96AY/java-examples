package com.examples.collections;

import java.util.ArrayList;
import java.util.ListIterator;

public class ListExample {
	public static void main(String[] args) {
		ArrayList<String> arrayListObj = new ArrayList<String>();
		
		arrayListObj.add("Abi");
		arrayListObj.add("Nobody");
		
		for (String arrListValue : arrayListObj) {
			System.out.println(arrListValue);
		}
		
		ListIterator<String> iterator = arrayListObj.listIterator();
		while (iterator.hasNext()) {
		    String value = iterator.next();
		    if (value.equals("Abi")) {
		        iterator.set("Abishek");   // update Abi
		        iterator.add("Loves");   // add after ListIterator
		    }
		}
		
		arrayListObj.forEach(e -> System.out.print(" "+e));
	}
}
package com.examples.syntax;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorEx
{
	/*
	 * Trying to remove items using a for loop or a for-each loop would not work correctly because 
	 * the collection is changing size at the same time that the code is trying to loop.
	 * 
	 * Trying to remove numbers from the ArrayList while iterating through it using a regular enhanced for loop.
	 * However, this will lead to a ConcurrentModificationException because we're modifying the list's structure 
	 * (by removing elements) while iterating through it.
	 */
	public static void main(String[] args)
	{
		ArrayList<Integer> numbers = new ArrayList<Integer>();
	    numbers.add(12);
	    numbers.add(8);
	    numbers.add(2);
	    numbers.add(23);
	    
	    Iterator<Integer> it = numbers.iterator();
	    while(it.hasNext()) {
	      Integer i = it.next();
	      if(i < 10) {
	        it.remove();
	      }
	    }
	    
	    /*for (int i = 0; i < numbers.size(); i++) {
	    	if(i < 10) {
	    		numbers.remove(i);
		      }
		}*/
	    
	    /*for (Integer integer : numbers) {
			numbers.remove(integer);
		}*/
	    System.out.println(numbers);
	}
}
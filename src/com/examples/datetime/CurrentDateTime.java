package com.examples.datetime;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentDateTime
{
	public static void main(String[] args)
	{
		String dateTime = new SimpleDateFormat("yyyy:MM:dd, HH:mm:ss").format(new Date());
		System.out.println(dateTime);
	}
}
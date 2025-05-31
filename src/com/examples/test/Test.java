package com.examples.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Automation
{
	public void run()
	{
		System.out.println("Executes All Api's !!!");
	}
}

public class Test {
	public static void main(String[] args) {
		ExecutorService obj = Executors.newFixedThreadPool(10);
		Automation automationObj = new Automation();
		obj.submit(() ->
		{
			for (int i = 0; i < 50; i++) {
				automationObj.run();
			}
		});
		obj.shutdown();
	}
}
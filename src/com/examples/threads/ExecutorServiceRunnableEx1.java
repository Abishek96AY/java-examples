package com.examples.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceRunnableEx1 {

	public static void main(String[] args) {
		// Create a fixed thread pool with 3 threads
		ExecutorService executor = Executors.newFixedThreadPool(3);

		// Submit the task to the executor
		executor.submit(() -> {
			System.out.println("ExecutorServiceRunnable Example !!!");
		});

		// Shutdown the executor
		executor.shutdown();
	}
}
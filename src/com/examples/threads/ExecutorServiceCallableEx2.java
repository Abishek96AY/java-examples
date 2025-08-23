package com.examples.threads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceCallableEx2 {

	public static void main(String[] args) {
		// Create a fixed thread pool with 3 threads
		ExecutorService executor = Executors.newFixedThreadPool(3);

		// Submit the task to the executor
		Future<Integer> future = executor.submit(() -> {
			return 123;
		});

		try {
			// Wait for the result and print it
			System.out.println("Result of the callable task: " + future.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		// Shutdown the executor
		executor.shutdown();
	}
}
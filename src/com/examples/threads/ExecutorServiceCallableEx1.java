package com.examples.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceCallableEx1 {

	public static void main(String[] args) {
		// Create a fixed thread pool with 3 threads
		ExecutorService executor = Executors.newFixedThreadPool(3);

		// Define a Callable task
		Callable<Integer> task = () -> {
			System.out.println("Callable task is running on " + Thread.currentThread().getName());
			// Perform some computation
			return 123;
		};

		// Submit the task to the executor
		Future<Integer> future = executor.submit(task);

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
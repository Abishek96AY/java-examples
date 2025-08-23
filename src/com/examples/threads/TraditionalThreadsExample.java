package com.examples.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TraditionalThreadsExample {
	public static void main(String[] args) throws Exception {

		ExecutorService executor = Executors.newFixedThreadPool(10); // only 10 threads
		for (int i = 1; i <= 10000; i++) {
			final int taskId = i;
			executor.submit(() -> {
				System.out.println("Task " + taskId + " running on " + Thread.currentThread());
				try {
					Thread.sleep(1000); // simulate blocking work
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			});
		}
		executor.shutdown();
	}
}
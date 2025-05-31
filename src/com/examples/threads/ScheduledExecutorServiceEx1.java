package com.examples.threads;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceEx1 {
	void callService()
	{
		// Create a scheduled executor service with 10 threads
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);

		// Define the task to be executed
		Runnable task = new Runnable() {
			private int counter = 1;

			@Override
			public void run() {
				System.out.println("Thread: " + Thread.currentThread().getName() + " Value: " + counter++);
			}
		};

		// Schedule the task to run every second
		scheduledExecutorService.scheduleAtFixedRate(task, 0, 1, TimeUnit.MILLISECONDS);
		
		// Schedule a task to shutdown the executor service after 10 minutes
		scheduledExecutorService.schedule(() -> {
			scheduledExecutorService.shutdown();
			System.out.println("Executor service shut down after 10 minutes.");
		}, 10, TimeUnit.MINUTES);

	}

	public static void main(String[] args) {
		new ScheduledExecutorServiceEx1().callService();
	}
}

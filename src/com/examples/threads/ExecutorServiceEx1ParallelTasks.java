package com.examples.threads;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

public class ExecutorServiceEx1ParallelTasks {

	static AtomicLong value = new AtomicLong(0);

	void executeThreads() {
		// Custom ThreadPoolExecutor with bounded queue and rejection policy
		ExecutorService executorService = new ThreadPoolExecutor(
			50, // Core pool size
			50, // Max pool size
			0L, TimeUnit.MILLISECONDS,
			new ArrayBlockingQueue<>(500), // Bounded queue to avoid memory leaks
			Executors.defaultThreadFactory(),
			new ThreadPoolExecutor.CallerRunsPolicy() // Fallback if queue is full
		);

		Instant startTime = Instant.now();

		try {
			while (!checkTimePassed(startTime)) {
				for (int i = 1; i <= 50; i++) {
					executorService.submit(() -> {
						long current = value.getAndIncrement();
						System.out.println("Thread: " + Thread.currentThread().getName() + " Value: " + current);
					});
				}
				Thread.sleep(100); // Throttle submissions
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			System.err.println("Task submission interrupted");
		} finally {
			executorService.shutdown();
			try {
				if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
					executorService.shutdownNow();
					if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
						System.err.println("Executor service did not terminate");
					}
				}
				System.out.println("All tasks completed and executor service shut down.");
			} catch (InterruptedException e) {
				executorService.shutdownNow();
				Thread.currentThread().interrupt();
			}
		}
	}

	public static boolean checkTimePassed(Instant startTime) {
		Instant currentTime = Instant.now();
		Duration duration = Duration.between(startTime, currentTime);
		return duration.toMinutes() >= 30;
	}

	public static void main(String[] args) {
		new ExecutorServiceEx1ParallelTasks().executeThreads();
		System.out.println("Main thread finished.");
	}
}
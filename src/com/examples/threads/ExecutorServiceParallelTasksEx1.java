package com.examples.threads;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

public class ExecutorServiceParallelTasksEx1 {

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
						System.out.println("Thread: " + Thread.currentThread().threadId() + " Value: " + current);
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
		new ExecutorServiceParallelTasksEx1().executeThreads();
		System.out.println("Main thread finished.");
	}
	
	/*@Configuration
	@EnableScheduling
	public class ThreadPoolConfig {

	    @Value("${threadpool.core-size}")
	    private int coreSize;

	    @Value("${threadpool.max-size}")
	    private int maxSize;

	    @Value("${threadpool.queue-capacity}")
	    private int queueCapacity;

	    @Value("${threadpool.thread-name-prefix}")
	    private String threadNamePrefix;

	    @Bean
	    public ThreadPoolTaskExecutor taskExecutor() {
	        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
	        executor.setCorePoolSize(coreSize);
	        executor.setMaxPoolSize(maxSize);
	        executor.setQueueCapacity(queueCapacity);
	        executor.setThreadNamePrefix(threadNamePrefix);
	        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
	        executor.initialize();
	        return executor;
	    }
	}
	
	@Service
	public class ParallelTaskService {

	    private final ThreadPoolTaskExecutor executor;
	    private final AtomicLong value = new AtomicLong(0);
	    private final Instant startTime = Instant.now();

	    public ParallelTaskService(ThreadPoolTaskExecutor executor) {
	        this.executor = executor;
	    }

	    @Scheduled(fixedRate = 100)
	    public void submitParallelTasks() {
	        if (Duration.between(startTime, Instant.now()).toMinutes() >= 30) {
	            System.out.println("30 minutes passed. Skipping task submission.");
	            return;
	        }

	        for (int i = 0; i < 50; i++) {
	            executor.submit(() -> {
	                long current = value.getAndIncrement();
	                System.out.println("Thread: " + Thread.currentThread().getName() + " Value: " + current);
	            });
	        }
	    }
	}*/
}
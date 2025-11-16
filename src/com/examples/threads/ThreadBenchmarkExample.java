package com.examples.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadBenchmarkExample {

    private static final int TASK_COUNT = 10_000;

    public static void main(String[] args) throws Exception {
        System.out.println("=== Traditional Threads Benchmark ===");
        benchmarkTraditionalThreads();

        System.out.println("\n=== Virtual Threads Benchmark ===");
        benchmarkVirtualThreads();
    }

    private static void benchmarkTraditionalThreads() throws Exception {
        long start = System.currentTimeMillis();

        ExecutorService executor = Executors.newFixedThreadPool(100); // limited pool
        for (int i = 0; i < TASK_COUNT; i++) {
            executor.submit(() -> {
                try {
                    Thread.sleep(1000); // simulate I/O blocking
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(2, TimeUnit.MINUTES);

        long end = System.currentTimeMillis();
        System.out.println("Traditional threads took: " + (end - start) + " ms");
    }

    private static void benchmarkVirtualThreads() throws Exception {
        long start = System.currentTimeMillis();

        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < TASK_COUNT; i++) {
                executor.submit(() -> {
                    try {
                        Thread.sleep(1000); // simulate I/O blocking
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
            }
        } // automatically waits for completion

        long end = System.currentTimeMillis();
        System.out.println("Virtual threads took: " + (end - start) + " ms");
    }
}

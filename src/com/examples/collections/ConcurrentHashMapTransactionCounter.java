package com.examples.collections;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

public class ConcurrentHashMapTransactionCounter {
	private final ConcurrentHashMap<String, LongAdder> counters = new ConcurrentHashMap<>();

	public void increment(String status) {
		counters.computeIfAbsent(status, k -> new LongAdder()).increment();
	}

	public long getCount(String status) {
		return counters.getOrDefault(status, new LongAdder()).sum();
	}

	public static void main(String[] args) throws InterruptedException {
		ConcurrentHashMapTransactionCounter counter = new ConcurrentHashMapTransactionCounter();
		ExecutorService executor = Executors.newFixedThreadPool(100);

		// Simulate 1,000 transactions
		for (int i = 0; i < 10000000; i++) {
			executor.submit(() -> counter.increment("Approved"));
		}

		executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

		System.out.println("Approved count: " + counter.getCount("Approved")); // Should be 1000
	}
}
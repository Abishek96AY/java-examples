package com.examples.threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueWithThreadsExample {
	public static void main(String[] args) {
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(5);

		new Thread(() -> {
			try {
				for (int i = 0; i < 10; i++) {
					System.out.println("Produced: " + i);
					queue.put(i);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}).start();

		new Thread(() -> {
			try {
				for (int i = 0; i < 10; i++) {
					Integer val = queue.take();
					System.out.println("Consumed: " + val);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}).start();
	}
}

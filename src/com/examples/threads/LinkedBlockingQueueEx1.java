package com.examples.threads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


class Producer1 implements Runnable {
	private BlockingQueue<Integer> queue;

	public Producer1(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				queue.put(i);
				System.out.println("Produced " + i);
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}

class Consumer1 implements Runnable {
	private BlockingQueue<Integer> queue;

	public Consumer1(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	public void run() {
		try {
			while (true) {
				int value = queue.take();
				System.out.println("Consumed " + value);
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}

public class LinkedBlockingQueueEx1 {
	public static void main(String[] args) {
		BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(5);

		Thread producer = new Thread(new Producer1(queue));
		Thread consumer = new Thread(new Consumer1(queue));

		producer.start();
		consumer.start();
	}
}

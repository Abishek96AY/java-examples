package com.examples.threads;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

class Storage {
	private Queue<Integer> items = new LinkedList<>();
	private final int capacity = 5;

	public synchronized void produce(int item) throws InterruptedException {
		while (items.size() == capacity) {
			// Storage is full, wait for the consumer to consume
			System.err.println(new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date())+ " Storage is full, wait for the consumer to consume !!!");
			wait();
		}
		items.add(item);
		System.out.println(new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date())+ " Produced : " + item);
		// Notify the consumer that an item is available
		notify();
	}

	public synchronized int consume() throws InterruptedException {
		while (items.isEmpty()) {
			// Storage is empty, wait for the producer to produce
			System.err.println(new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date())+ " Storage is empty, wait for the producer to produce !!!");
			wait();
		}
		int item = items.poll();
		System.out.println(new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date())+ " Consumed : " + item);
		// Notify the producer that space is available
		notify();
		return item;
	}
}

class Producer extends Thread {
	private Storage storage;

	public Producer(Storage storage) {
		this.storage = storage;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				storage.produce(i);
				Thread.sleep(5000); // Simulate production time
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Consumer extends Thread {
	private Storage storage;

	public Consumer(Storage storage) {
		this.storage = storage;
	}

	
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				storage.consume();
				//Thread.sleep(1000); // Simulate consumption time
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class SleepWaitNotify {
	public static void main(String[] args) {
		Storage storage = new Storage();
		Producer producer = new Producer(storage);
		Consumer consumer = new Consumer(storage);

		producer.start();
		consumer.start();
	}
}

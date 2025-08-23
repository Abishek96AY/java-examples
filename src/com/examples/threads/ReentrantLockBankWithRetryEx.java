package com.examples.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount2 {
	private double balance = 1000.0; // initial balance
	private final ReentrantLock lock = new ReentrantLock();

	public void deposit(double amount, String customerName) {
		int maxRetries = 3;
		int attempts = 0;

		while (attempts < maxRetries) {
			try {
				if (lock.tryLock(2, TimeUnit.SECONDS)) {
					try {
						System.out.println(customerName + " is depositing $" + amount + "...");
						// Simulate slow operation if needed: 
						Thread.sleep(2000);
						balance += amount;
						System.out.println(customerName + " deposited $" + amount + " | Balance: $" + balance);
						return;
					} finally {
						lock.unlock();
					}
				} else {
					System.out.println(customerName + " failed to acquire lock for deposit. Retrying... (" + (attempts + 1) + ")");
					attempts++;
					Thread.sleep(100); // Small delay before retrying
				}
			} catch (InterruptedException e) {
				System.out.println(customerName + " interrupted while waiting for lock.");
				Thread.currentThread().interrupt();
				return;
			}
		}
		System.out.println(customerName + " gave up deposit after " + maxRetries + " attempts.");
	}

	public void withdraw(double amount, String customerName) {
		int maxRetries = 3;
		int attempts = 0;

		while (attempts < maxRetries) {
			try {
				if (lock.tryLock(2, TimeUnit.SECONDS)) {
					try {
						System.out.println(customerName + " is withdrawing $" + amount + "...");
						// Simulate slow operation if needed: 
						Thread.sleep(2000);
						if (balance >= amount) {
							balance -= amount;
							System.out.println(customerName + " withdrew $" + amount + " | Balance: $" + balance);
						} else {
							System.out.println(customerName + " failed to withdraw $" + amount + " | Insufficient funds. Balance: $" + balance);
						}
						return;
					} finally {
						lock.unlock();
					}
				} else {
					System.out.println(customerName + " failed to acquire lock for withdrawal. Retrying... (" + (attempts + 1) + ")");
					attempts++;
					Thread.sleep(100); // Small delay before retrying
				}
			} catch (InterruptedException e) {
				System.out.println(customerName + " interrupted while waiting for lock.");
				Thread.currentThread().interrupt();
				return;
			}
		}
		System.out.println(customerName + " gave up withdrawal after " + maxRetries + " attempts.");
	}

	public double getBalance() {
		return balance;
	}
}

public class ReentrantLockBankWithRetryEx {
	public static void main(String[] args) {
		BankAccount2 account = new BankAccount2();
		ExecutorService executor = Executors.newFixedThreadPool(3); // 3 bank counters

		Runnable customer1 = () -> {
			account.deposit(300, "Alice");
			account.withdraw(500, "Alice");
		};

		Runnable customer2 = () -> {
			account.withdraw(400, "Bob");
			account.deposit(200, "Bob");
		};

		Runnable customer3 = () -> {
			account.withdraw(800, "Charlie");
		};

		executor.submit(customer1);
		executor.submit(customer2);
		executor.submit(customer3);

		executor.shutdown();
		try {
			if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
				executor.shutdownNow();
			}
		} catch (InterruptedException e) {
			executor.shutdownNow();
		}

		System.out.println("Final Account Balance: $" + account.getBalance());
	}
}

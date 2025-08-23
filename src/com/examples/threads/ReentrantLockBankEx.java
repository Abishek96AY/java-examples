package com.examples.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount {
	private double balance = 1000.0; // initial balance
	private final ReentrantLock lock = new ReentrantLock();

	public void deposit(double amount, String customerName) {
		try {
			if (lock.tryLock(2, TimeUnit.SECONDS)) { // Try to acquire the lock with a timeout
				try {
					// Simulate a slow deposit operation by sleeping for 2 seconds
					System.out.println(customerName + " is depositing $" + amount + "...");
					//Thread.sleep(3000); // Simulate a slow operation
					balance += amount;
					System.out.println(customerName + " deposited $" + amount + " | Balance: $" + balance);
				} finally {
					lock.unlock(); // Always release the lock
				}
			} else {
				System.out.println(customerName + " failed to acquire lock for deposit.");
			}
		} catch (InterruptedException e) {
			System.out.println("Thread interrupted while waiting for lock.");
		}
	}

	public void withdraw(double amount, String customerName) {
		try {
			if (lock.tryLock(2, TimeUnit.SECONDS)) { // Try to acquire the lock with a timeout
				try {
					// Simulate a slow withdrawal operation by sleeping for 2 seconds
					System.out.println(customerName + " is withdrawing $" + amount + "...");
					//Thread.sleep(3000); // Simulate a slow operation
					if (balance >= amount) {
						balance -= amount;
						System.out.println(customerName + " withdrew $" + amount + " | Balance: $" + balance);
					} else {
						System.out.println(customerName + " failed to withdraw $" + amount + " | Insufficient funds. Balance: $" + balance);
					}
				} finally {
					lock.unlock(); // Always release the lock
				}
			} else {
				System.out.println(customerName + " failed to acquire lock for withdrawal.");
			}
		} catch (InterruptedException e) {
			System.out.println("Thread interrupted while waiting for lock.");
		}
	}

	public double getBalance() {
		return balance;
	}
}

public class ReentrantLockBankEx {
	public static void main(String[] args) {
		BankAccount account = new BankAccount();
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
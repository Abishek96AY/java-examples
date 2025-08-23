package com.examples.threads;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockAvoidTryLock {
    public static void main(String[] args) {
        ReentrantLock lock1 = new ReentrantLock();
        ReentrantLock lock2 = new ReentrantLock();

        Thread t1 = new Thread(() -> {
            try {
                if (lock1.tryLock(50, TimeUnit.MILLISECONDS)) {
                    System.out.println("Thread 1 locked lock1");
                    Thread.sleep(50);
                    if (lock2.tryLock(50, TimeUnit.MILLISECONDS)) {
                        System.out.println("Thread 1 locked lock2");
                        lock2.unlock();
                    } else {
                        System.out.println("Thread 1: could not lock lock2, releasing lock1");
                    }
                    lock1.unlock();
                }
            } catch (InterruptedException ignored) {}
        });

        Thread t2 = new Thread(() -> {
            try {
                if (lock2.tryLock(50, TimeUnit.MILLISECONDS)) {
                    System.out.println("Thread 2 locked lock2");
                    Thread.sleep(50);
                    if (lock1.tryLock(50, TimeUnit.MILLISECONDS)) {
                        System.out.println("Thread 2 locked lock1");
                        lock1.unlock();
                    } else {
                        System.out.println("Thread 2: could not lock lock1, releasing lock2");
                    }
                    lock2.unlock();
                }
            } catch (InterruptedException ignored) {}
        });

        t1.start();
        t2.start();
    }
}
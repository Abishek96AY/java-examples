package com.examples.threads;

public class ThreadLifeCycleDemo implements Runnable {
    public void run() {
        try {
            System.out.println("Thread is running");
            Thread.sleep(1000); // Timed Waiting
            synchronized (this) {
                wait(500); // Timed Waiting
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread is finished");
    }

    public static void main(String[] args) {
        ThreadLifeCycleDemo runnable = new ThreadLifeCycleDemo();
        Thread thread = new Thread(runnable); // New state
        System.out.println("Thread state: " + thread.getState()); // NEW
        thread.start(); // Runnable state
        System.out.println("Thread state after start: " + thread.getState()); // RUNNABLE

        try {
            Thread.sleep(500); // Give some time for thread to start running
            System.out.println("Thread state while sleeping: " + thread.getState()); // TIMED_WAITING or WAITING or RUNNABLE
            thread.join(); // Waiting for the thread to die
            System.out.println("Thread state after join: " + thread.getState()); // TERMINATED
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
package com.examples.logical;

public class TrafficSignal {
	
	/**
	 * Creating a simple traffic signal simulator in Java involves using loops to continuously monitor and control the signal state. 
	 * Below is a basic example that demonstrates how to simulate a traffic signal with three states: Red, Green, and Yellow.
	 */
	
    private enum Signal {
        RED, GREEN, YELLOW
    }

    public static void main(String[] args) {
        new TrafficSignal().runSignal();
    }

    private void runSignal() {
        Signal currentSignal = Signal.RED;

        while (true) {
            switch (currentSignal) {
                case RED:
                    System.out.println("Red Light - Stop");
                    wait(5000);  // Red light for 5 seconds
                    currentSignal = Signal.GREEN;
                    break;

                case GREEN:
                    System.out.println("Green Light - Go");
                    wait(5000);  // Green light for 5 seconds
                    currentSignal = Signal.YELLOW;
                    break;

                case YELLOW:
                    System.out.println("Yellow Light - Slow down");
                    wait(2000);  // Yellow light for 2 seconds
                    currentSignal = Signal.RED;
                    break;
            }
        }
    }

    private void wait(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread was interrupted, Failed to complete operation");
        }
    }
}

package com.examples.datetime;

import java.time.Duration;
import java.time.Instant;

public class TimeCheck {

    public static void main(String[] args) {
        // Record the start time
        Instant startTime = Instant.now();

        // Simulate some processing or waiting time
        // In a real scenario, you would have your logic here
        
        // Check if 30 minutes have passed
        boolean thirtyMinutesPassed = checkIfThirtyMinutesPassed(startTime);
        
        System.out.println("Has 30 minutes passed? " + thirtyMinutesPassed);
    }

    public static boolean checkIfThirtyMinutesPassed(Instant startTime) {
        Instant currentTime = Instant.now();
        Duration duration = Duration.between(startTime, currentTime);
        return duration.toMinutes() >= 30;
    }
}
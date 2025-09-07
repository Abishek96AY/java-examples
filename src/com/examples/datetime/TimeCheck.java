package com.examples.datetime;

import java.time.Duration;
import java.time.Instant;

public class TimeCheck {

    public static void main(String[] args) {
        Instant startTime = Instant.now();
        boolean thirtyMinutesPassed = checkIfThirtyMinutesPassed(startTime);
        System.out.println("Has 30 minutes passed? " + thirtyMinutesPassed);
    }

    public static boolean checkIfThirtyMinutesPassed(Instant startTime) {
        Instant currentTime = Instant.now();
        Duration duration = Duration.between(startTime, currentTime);
        return duration.toMinutes() >= 30;
    }
}
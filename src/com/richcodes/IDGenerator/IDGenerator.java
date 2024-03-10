package com.richcodes.IDGenerator;

import java.util.concurrent.atomic.AtomicInteger;

public class IDGenerator {
    private static final String PREFIX = "ESL";
    private static final AtomicInteger counter = new AtomicInteger(0);

    public  String generateId() {
        int id = counter.incrementAndGet();
        return PREFIX + String.format("%04d", id); // Pads the numeric portion with leading zeros
    }
}

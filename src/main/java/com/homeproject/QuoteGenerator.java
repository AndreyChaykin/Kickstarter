package com.homeproject;

import java.util.Random;

public class QuoteGenerator {

    private Random random;

    public QuoteGenerator(Random random) {
        this.random = random;
    }

    protected String nextQuote() {
        String[] qoute = new String[]{
                "Tra la la",
                "upi-dupi",
                "Chih pih-pih"
        };
        int index = random.nextInt(qoute.length);
        return qoute[index];
    }
}
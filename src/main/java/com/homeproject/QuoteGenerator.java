package com.homeproject;

import java.util.Random;

public class QuoteGenerator {

    protected String nextQuote() {
        String[] qoute = new String[]{
                "Tra la la",
                "upi-dupi",
                "Chih pih-pih"
        };
        int index = new Random().nextInt(qoute.length);

        return qoute[index];
    }
}
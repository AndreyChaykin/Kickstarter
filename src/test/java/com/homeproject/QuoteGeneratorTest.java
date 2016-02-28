package com.homeproject;

import static org.junit.Assert.*;
import org.junit.Test;

public class QuoteGeneratorTest {

    private final QuoteGenerator quoteGenerator = new QuoteGenerator();

    @Test
    public void nextQouteTest() {
        assertNotNull(quoteGenerator.nextQuote());
    }


}

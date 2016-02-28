package com.homeproject;

import static org.junit.Assert.*;
import org.junit.Test;

public class QuoteGeneratorTest {

    @Test
    public void nextQouteTest() {
        assertNotNull(new QuoteGenerator().nextQuote());
    }
}

package com.homeproject;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class QuoteGeneratorTest {

    @Test
    public void nextQuoteTest() {
        QuoteGenerator quoteGenerator = new QuoteGenerator(new FakeRandom(0, 1, 2));
        assertEquals("Tra la la", quoteGenerator.nextQuote());
        assertEquals("upi-dupi", quoteGenerator.nextQuote());
        assertEquals("Chih pih-pih", quoteGenerator.nextQuote());
    }

    @Test
    public void nextQouteTestNotNull() {
        assertNotNull(new QuoteGenerator(new Random(1)).nextQuote());
    }

    class FakeRandom extends Random {
        private final List<Integer> numbers;

        FakeRandom(Integer... numbers) {
            this.numbers = new LinkedList<Integer>(Arrays.asList(numbers));
        }

        @Override
        public int nextInt(int i) {
            return numbers.remove(0);
        }
    }
}

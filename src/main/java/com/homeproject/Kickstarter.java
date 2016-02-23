package com.homeproject;

/**
 * Created by andrey on 23.02.2016.
 */
public class Kickstarter {



    public static void main(String[] args) {
        Kickstarter kickstarter = new Kickstarter();

        kickstarter.printQuote();
    }

    private void printQuote() {
        System.out.println(new QuoteRandom().quoteRandom());
    }
}

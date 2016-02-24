package com.homeproject;


import java.util.Arrays;

/**
 * Created by andrey on 23.02.2016.
 */
public class Kickstarter {

    Categories categories;

    public Kickstarter(Categories categories) {
        this.categories = categories;
    }

    public static void main(String[] args) {

        Category categoryOne = new Category("Photo");
        Category categoryTwo = new Category("Video");
        Category categoryThree = new Category("Music");

        Categories categories = new Categories();

        Kickstarter application = new Kickstarter(categories);

        categories.add(categoryOne);
        categories.add(categoryOne);
        categories.add(categoryOne);

        application.printQuote();
    }

    private void printQuote() {
        System.out.println(new QuoteGenerator().quoteRandom());

        System.out.println(Arrays.toString(categories.getCategories()));

        System.out.println(Arrays.toString(categories.getGategoriesNames()));
    }
}

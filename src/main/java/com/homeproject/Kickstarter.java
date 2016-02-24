package com.homeproject;


import java.io.*;
import java.util.Arrays;

/**
 * Created by andrey on 23.02.2016.
 */
public class Kickstarter {

    Categories categories;
    private Projects projects;

    public Kickstarter(Categories categories, Projects projects) {
        this.categories = categories;
        this.projects = projects;
    }

    public static void main(String[] args) {

        Category categoryOne = new Category("Photo");
        Category categoryTwo = new Category("Video");
        Category categoryThree = new Category("Music");

        Categories categories = new Categories();
        categories.add(categoryOne);
        categories.add(categoryTwo);
        categories.add(categoryThree);


        Project projectOne = new Project("new album", 1000, 15);
        Project projectTwo = new Project("new song", 200, 10);

        projectOne.setCategory(categoryThree);
        projectTwo.setCategory(categoryThree);

        Projects projects = new Projects();
        projects.add(projectOne);
        projects.add(projectTwo);

        Kickstarter application = new Kickstarter(categories, projects);

        application.printQuote();
        System.out.println(application.choiceCategory());
    }

    private void printQuote() {
        System.out.println(new QuoteGenerator().quoteRandom());
    }

    private Category choiceCategory() {
        try {
            System.out.println("Please, make choice:");
            System.out.println(Arrays.toString(categories.getGategoriesNames()));

            int number = enterNumber();

            Category[] result = categories.getCategories();

            if(number < categories.getCategories().length) {
                return result[number];
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private int enterNumber() throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int result = Integer.parseInt(bf.readLine());

        return result;
    }
}

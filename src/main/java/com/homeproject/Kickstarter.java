package com.homeproject;


import java.io.*;
import java.util.Arrays;

public class Kickstarter {

    private Categories categories;
    private Projects projects;

    public Kickstarter(Categories categories, Projects projects) {
        this.categories = categories;
        this.projects = projects;
    }

    public void run() {
        printQuote();
        System.out.println("Please, make choice:");
        System.out.println(Arrays.toString(categories.getCategories()));

        int index = 0;
        try {
            index = enterNumber();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String categoryName = categories.getName(index);
        Category category = categories.getCategoryByName(categoryName);
        Project[] selectedProjects = projects.getProjects(category);

        for (Project project : selectedProjects) {
            System.out.println("Project name: " + project.getName());
            System.out.println("About: " + project.getDescription());
            System.out.println("Sum of project: " + project.getAmount());
            System.out.println("Sum exist: " + project.getSumExist() + "\n");
        }
    }


    private void printQuote() {
        System.out.println(new QuoteGenerator().nextQuote());
    }


    private int enterNumber() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(bf.readLine());
    }
}

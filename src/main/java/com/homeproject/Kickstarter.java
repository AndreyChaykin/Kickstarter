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

        while (true) {
            System.out.println("Please, select category:");
            System.out.println(Arrays.toString(categories.getCategories()));

            try {
                int categoryIndex = selectMenu();
                Category categoryName = categories.chooseCategory(categoryIndex);
                Project[] selectedProjects = projects.getProjects(categoryName);

                printProject(selectedProjects);

                System.out.println("Please, select project:");
                System.out.println(Arrays.toString(projects.getProjects()));

                categoryIndex = selectMenu();

                System.out.println(selectedProjects[categoryIndex]);


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void printProject(Project[] projects) {
        for (Project project : projects) {
            System.out.println("Project name: " + project.getName());
            System.out.println("About: " + project.getDescription());
            System.out.println("Sum of project: " + project.getAmount());
            System.out.println("Sum exist: " + project.getSumExist() + "\n");
        }
    }


    private void printQuote() {
        System.out.println(new QuoteGenerator().nextQuote());
    }


    private int selectMenu() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(bf.readLine());
    }
}

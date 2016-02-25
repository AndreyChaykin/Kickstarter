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
            try {
                askCategory();
                int categoryIndex = selectMenu();
                Category category = categories.chooseCategory(categoryIndex);

                System.out.println("Please, select project:");
                Project[] selectedProjects = printProjects(category);

                int projectIndex = selectMenu();
                Project project = selectedProjects[projectIndex];
                System.out.println(project);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private Project[] printProjects(Category category) {
        Project[] selectedProjects = projects.getProjects(category);
        for (Project project : selectedProjects) {
            printProject(project);
        }
        return selectedProjects;
    }

    private void askCategory() {
        System.out.println("Please, select category:");
        System.out.println(Arrays.toString(categories.getCategories()));
    }

    private void printProject(Project project) {
        System.out.println("Project name: " + project.getName());
        System.out.println("About: " + project.getDescription());
        System.out.println("Sum of project: " + project.getAmount());
        System.out.println("Sum exist: " + project.getSumExist() + "\n");
    }


    private void printQuote() {
        System.out.println(new QuoteGenerator().nextQuote());
    }


    private int selectMenu() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(bf.readLine());
    }
}

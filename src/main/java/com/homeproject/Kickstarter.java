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
                Category category = chooseCategory(categoryIndex);
                Project[] selectedProjects = printProjects(category);
                while (true) {
                    askProject();
                    System.out.println("Please, select project");

                    int projectIndex = selectMenu();
                    Project project = chooseProject(projectIndex);

                    printProject(project);

                    printProjectDetail(project);
                }
//                Project[] selectedProjects = printProjects(category);
//                int projectIndex = selectMenu();
//                Project project = selectedProjects[projectIndex];
//                System.out.println(project);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void askProject() {
        System.out.println("Please, select category:");
        System.out.println(Arrays.toString(categories.getCategories()));
    }

    private void printProjectDetail(Project project) {
        printProject(project);
        System.out.println(project.getHistory());
        System.out.println(project.getDemoVideo());
        System.out.println(project.getQuestionAnswers() + "\n");
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
        System.out.println("Sum exist: " + project.getSumExist());
    }


    private void printQuote() {
        System.out.println(new QuoteGenerator().nextQuote());
    }

    private int selectMenu() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(bf.readLine());
    }

    private Project chooseProject(int index) {
        System.out.println("You have been select:");
        Project project = projects.getProject(index);
        return project;
    }

    private Category chooseCategory(int index) {
        System.out.println("You have been select:");
        Category category = categories.getCategory(index);
        return category;
    }
}

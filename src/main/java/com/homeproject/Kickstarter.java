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
                if(category == null) {
                    continue;
                }
                Project[] foundedProjects = printProjects(category);
                while (true) {
                    askProject(foundedProjects);
                    int projectIndex = selectMenu();
                    if(projectIndex < 0 || projectIndex >= foundedProjects.length) {
                        System.out.println("Wrong number of project, Please, try again!");
                        continue;
                    }
                    Project project = foundedProjects[projectIndex];
                    chooseProject(project);
                    printProjectDetail(project);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void askProject(Project[] foundedProjects) {
        System.out.println("Please, select project:");
        for (int i = 0; i < foundedProjects.length; i++) {
            System.out.println(i + ": " + foundedProjects[i]);
        }
    }

    private void printProjectDetail(Project project) {
        printProject(project);
        System.out.println(project.getHistory());
        System.out.println(project.getDemoVideo());
        System.out.println(project.getQuestionAnswers() + "\n");
    }

    private Project[] printProjects(Category category) {
        Project[] selectedProjects = projects.getProjects(category);
        int j = 1;
        for (int i = 0; i < selectedProjects.length; i++) {
            System.out.println(j++ + ": " + selectedProjects[i]);

        }
        for (Project project : selectedProjects) {
            printProject(project);
        }
        return selectedProjects;
    }

    private void askCategory() {
        System.out.println("Please, select category:");
        int j = 1;
        for (int i = 0; i < categories.size(); i++) {
            System.out.println(j++ + ": " + categories.getCategories()[i]);
        }
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

    private void chooseProject(Project projects) {
        System.out.println("You have been select: " + projects.getName());
    }

    private Category chooseCategory(int index) {
        if(index <= 0 || index > categories.size()) {
            System.out.println("Wrong number of category, Please, try again!");
            return null;
        }
        Category result = categories.getCategory(index - 1);
        System.out.println("You have been select: " + result);
        return result;
    }
}

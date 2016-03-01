package com.homeproject;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

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
                if (category == null) {
                    continue;
                }
                Project[] foundedProjects = printProjects(category);
                projectMenu(foundedProjects);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void projectMenu(Project[] foundedProjects) throws IOException {
        while (true) {
            askProject(foundedProjects);
            int projectIndex = selectMenu();
            if(projectIndex == 0) {
                break;
            }
            if (chooseProject(foundedProjects, projectIndex)) {
                continue;
            }
            Project project = foundedProjects[projectIndex];
            chooseProject(project);
            printProjectDetail(project);
        }
    }

    private boolean chooseProject(Project[] foundedProjects, int projectIndex) {
        if (projectIndex < 0 || projectIndex >= foundedProjects.length) {
            println("Wrong number of project, Please, try again!");
            return true;
        }
        return false;
    }

    private void println(String message) {
        System.out.println(message);
    }

    private void askProject(Project[] foundedProjects) {
        if(foundedProjects.length == 0) {
            println("There is no projects in this category. Enter \'0\' for exit");
        }
        println("Please, select project:");
        for (int i = 0; i < foundedProjects.length; i++) {
            println(i + ": " + foundedProjects[i]);
        }
    }

    private void printProjectDetail(Project project) {
        printProject(project);
        println(project.getHistory());
        println(project.getDemoVideo());
        println(project.getQuestionAnswers() + "\n");
    }

    private Project[] printProjects(Category category) {
        Project[] selectedProjects = projects.getProjects(category);
        int j = 1;
        for (int i = 0; i < selectedProjects.length; i++) {
            System.out.print(j++ + ": ");
            printProject(selectedProjects[i]);
        }
        return selectedProjects;
    }

    private void askCategory() {
        println("Please, select category:");
        int j = 1;
        for (int i = 0; i < categories.size(); i++) {
            System.out.println(j++ + ": " + categories.getCategories()[i]);
        }
    }

    private void printProject(Project project) {
        println("Project name: " + project.getName());
        println("About: " + project.getDescription());
        println("Sum of project: " + project.getAmount());
        println("Sum exist: " + project.getSumExist());
    }

    private void printQuote() {
        println(new QuoteGenerator(new Random()).nextQuote());
    }

    private int selectMenu() throws IOException {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private void chooseProject(Project projects) {
        println("You have been select: " + projects.getName());
    }

    private Category chooseCategory(int index) {
        if (index <= 0 || index > categories.size()) {
            println("Wrong number of category, Please, try again!");
            return null;
        }
        Category result = categories.getCategory(index - 1);
        println("You have been select: " + result);
        return result;
    }
}

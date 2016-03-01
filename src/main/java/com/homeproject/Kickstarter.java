package com.homeproject;

import java.util.Random;

public class Kickstarter {

    private final IO io;
    private Categories categories;
    private Projects projects;

    public Kickstarter(Categories categories, Projects projects, IO io) {
        this.categories = categories;
        this.projects = projects;
        this.io = io;
    }

    public void run() {
        printQuote();

        while (true) {
            askCategory();
            int categoryIndex = io.read();
            if (categoryIndex == 0) {
                break;
            }
            Category category = chooseCategory(categoryIndex);
            if (category == null) {
                continue;
            }
            Project[] foundedProjects = printProjects(category);
            projectMenu(foundedProjects);
        }
    }

    private void projectMenu(Project[] foundedProjects) {
        while (true) {
            askProject(foundedProjects);
            int projectIndex = io.read();
            if (projectIndex == 0) {
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
            io.println("Wrong number of project, Please, try again!");
            return true;
        }
        return false;
    }

    private void askProject(Project[] foundedProjects) {
        if (foundedProjects.length == 0) {
            io.println("There is no projects in this category. Enter \'0\' for exit");
        }
        io.println("Please, select project:");
        for (int i = 0; i < foundedProjects.length; i++) {
            io.println(i + ": " + foundedProjects[i]);
        }
    }

    private void printProjectDetail(Project project) {
        printProject(project);
        io.println(project.getHistory());
        io.println(project.getDemoVideo());
        io.println(project.getQuestionAnswers() + "\n");
    }

    private Project[] printProjects(Category category) {
        Project[] selectedProjects = projects.getProjects(category);
        int j = 1;
        for (Project project : selectedProjects) {
            System.out.print(j++ + ": ");
            printProject(project);
        }
        return selectedProjects;
    }

    private void askCategory() {
        io.println("Please, select category:");
        int j = 1;
        for (int i = 0; i < categories.size(); i++) {
            System.out.println(j++ + ": " + categories.getCategories()[i]);
        }
    }

    private void printProject(Project project) {
        io.println("Project name: " + project.getName());
        io.println("About: " + project.getDescription());
        io.println("Sum of project: " + project.getAmount());
        io.println("Sum exist: " + project.getSumExist());
    }

    private void printQuote() {
        io.println(new QuoteGenerator(new Random()).nextQuote());
    }

    private void chooseProject(Project projects) {
        io.println("You have been select: " + projects.getName());
    }

    private Category chooseCategory(int index) {
        if (index <= 0 || index > categories.size()) {
            io.println("Wrong number of category, Please, try again!");
            return null;
        }
        Category result = categories.getCategory(index - 1);
        io.println("You have been select: " + result);
        return result;
    }
}

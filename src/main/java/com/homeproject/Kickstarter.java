package com.homeproject;

public class Kickstarter {

    private final IO io;
    private final QuoteGenerator quoteGenerator;
    private Categories categories;
    private Projects projects;

    public Kickstarter(Categories categories, Projects projects, IO io, QuoteGenerator quoteGenerator) {
        this.categories = categories;
        this.projects = projects;
        this.io = io;
        this.quoteGenerator = quoteGenerator;
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
            Project[] foundedProjects = selectProjects(category);
            projectMenu(foundedProjects);
        }
    }

    private Category chooseCategory(int categoryIndex) {
        Category result = categories.chooseCategory(categoryIndex, this);
                if(result == null) {
                    io.println("Wrong number of category, Please, try again!");
                } else {
                    io.println("You have been select: " + result);
                }
        return result;
    }

    private void projectMenu(Project[] foundedProjects) {
        while (true) {
            if(isProjectsExist(foundedProjects)) {
                break;
            }
            askProject(foundedProjects);
            int projectIndex = io.read();
            if (projectIndex == 0) {
                break;
            }
            if (chosenProject(foundedProjects, projectIndex)) {
                continue;
            }
            Project project = foundedProjects[projectIndex - 1];
            chosenProject(project);
            printProjectDetail(project);
        }
    }

    private boolean chosenProject(Project[] foundedProjects, int projectIndex) {
        if (projectIndex < 0 || projectIndex > foundedProjects.length) {
            io.println("Wrong number of project, Please, try again!");
            return true;
        }
        return false;
    }

    private void askProject(Project[] foundedProjects) {
        io.println("Please, select project:");
        int j = 1;
        for (int i = 0; i < foundedProjects.length; i++) {
            io.println(j++ + ": " + foundedProjects[i]);
        }
    }

    private boolean isProjectsExist(Project[] foundedProjects) {
        if (foundedProjects == null || foundedProjects.length == 0) {
            io.println("There is no projects in this category.");
            return true;
        }
        return false;
    }

    private void printProjectDetail(Project project) {
        printProject(project);
        io.println(project.getHistory());
        io.println(project.getDemoVideo());
        io.println(project.getQuestionAnswers() + "\n");
    }

    private Project[] selectProjects(Category category) {
        Project[] result = projects.getProjects(category);
        if(result == null) {
            return null;
        }
        int j = 1;
        for (Project project : result) {
            System.out.print(j++ + ": ");
            printProject(project);
        }
        return result;
    }

    private void askCategory() {
        io.println("Please, select category or \"0\" for exit:");
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
        io.println(quoteGenerator.nextQuote());
    }

    private void chosenProject(Project projects) {
        io.println("You have been select: " + projects.getName());
    }

}

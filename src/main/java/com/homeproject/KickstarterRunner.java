package com.homeproject;

public class KickstarterRunner {
    public static void main(String[] args) {

        Category categoryOne = new Category("Photo");
        Category categoryTwo = new Category("Video");
        Category categoryThree = new Category("Music");

        Categories categories = new Categories();
        categories.add(categoryOne);
        categories.add(categoryTwo);
        categories.add(categoryThree);

        Project projectOne = new Project("new album", 1000, 15, "new rock album");
        Project projectTwo = new Project("new song", 200, 10, "write first song");

        projectOne.setCategory(categoryThree);
        projectTwo.setCategory(categoryThree);

        Projects projects = new Projects();
        projects.add(projectOne);
        projects.add(projectTwo);

        Kickstarter application = new Kickstarter(categories, projects);

        application.run();

    }
}
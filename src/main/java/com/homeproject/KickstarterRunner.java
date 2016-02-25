package com.homeproject;

public class KickstarterRunner {
    public static void main(String[] args) {

        Category categoryOne = new Category("Photo");
        Category categoryTwo = new Category("Video");
        Category categoryThree = new Category("Music");
        Category categoryFour = new Category("Smth");

        Categories categories = new Categories();
        categories.add(categoryOne);
        categories.add(categoryTwo);
        categories.add(categoryThree);
        categories.add(categoryFour);

        Project projectOne = new Project("new album", 1000, 15, "new rock album");
        Project projectTwo = new Project("new song", 200, 10, "write first song");
        Project projectThree = new Project("new bike", 5400, 100, "new bike");

        projectOne.setCategory(categoryOne);
        projectTwo.setCategory(categoryOne);
        projectThree.setCategory(categoryTwo);

        Projects projects = new Projects();
        projects.add(projectOne);
        projects.add(projectTwo);
        projects.add(projectThree);

        Kickstarter application = new Kickstarter(categories, projects);

        application.run();

    }
}
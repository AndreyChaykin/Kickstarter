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

    public static void main(String[] args) {

        Category categoryOne = new Category("Photo");
        Category categoryTwo = new Category("Video");
        Category categoryThree = new Category("Music");

        Categories categories = new Categories();
        categories.add(categoryOne);
        categories.add(categoryTwo);
        categories.add(categoryThree);

        Project projectOne = new Project("new album", 1000, 15);
        Project projectTwo = new Project("new song", 200, 10);

        projectOne.setCategory(categoryThree);
        projectTwo.setCategory(categoryThree);

        Projects projects = new Projects();
        projects.add(projectOne);
        projects.add(projectTwo);

        Kickstarter application = new Kickstarter(categories, projects);

        application.run();

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
        System.out.println(projects.getProject(category));

    }



    private void printQuote() {
        System.out.println(new QuoteGenerator().nextQuote());
    }


    private int enterNumber() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(bf.readLine());
    }
}

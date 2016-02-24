package com.homeproject;

/**
 * Created by andrey on 24.02.2016.
 */
public class Projects {

    private Project[] projects = new Project[10];
    private int count;

    public void add(Project project) {
        projects[count] = project;
        count++;
    }


    public Category getProject(Category category) {
        for (int i = 0; i < projects.length; i++) {
            if (projects[i].getCategory().equals(category)) {
                return projects[i].getCategory();
            }
        }
        return null;
    }
}

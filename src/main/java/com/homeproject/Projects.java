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
}

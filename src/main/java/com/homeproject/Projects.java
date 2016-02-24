package com.homeproject;

public class Projects {

    private Project[] projects = new Project[10];
    private int count;

    public void add(Project project) {
        projects[count] = project;
        count++;
    }


    public Project[] getProjects(Category category) {
        Project[] tmpResult = new Project[projects.length];
        int found = 0;
        for (int i = 0; i < projects.length; i++) {
            if (projects[i] != null) {
                if (projects[i].getCategory().equals(category)) {
                    tmpResult[found] = projects[i];
                    found++;
                }
            }
        }

        Project[] result = new Project[found];
        System.arraycopy(tmpResult, 0, result, 0, found);
        return result;
    }
}

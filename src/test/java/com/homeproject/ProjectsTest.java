package com.homeproject;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProjectsTest {

    private Projects projects;
    private Category category1;
    private Project project1;
    private Project project2;
    private Project[] expected;

    @Before
    public void setUp() {
        projects = new Projects();
        project1 = new Project("FirstProject", 100, 25, "Description of 1st project");
        category1 = new Category("FirstCategory");
        project2 = new Project("€ÛÒ˘Ú‚Project", 100, 25, "Description of 2nd project");
    }

    @Test
    public void addNewProjectTest() {
        projects.add(project1);

        assertEquals(project1, projects.getProject(0));
        assertNull(projects.getProject(1));

        projects.add(project2);

        assertEquals(project2, projects.getProject(1));
    }

    @Test
    public void getProjectsByExistCategory() {
        project1.setCategory(category1);
        project2.setCategory(category1);
        projects.add(project1);
        projects.add(project2);
        expected = new Project[]{project1, project2};

        assertArrayEquals(expected, projects.getProjects(category1));
    }

    @Test
    public void getProjectsListWhenThereIsNoProjects() {
        Project[] expected = new Project[10];
        assertArrayEquals(expected, projects.getProjects());
    }

    @Test
    public void getProjectsListWhenThereIsNoProjectsInSuchCategory() {
        Project[] expected = new Project[0];
        assertArrayEquals(expected, projects.getProjects(category1));
    }

}

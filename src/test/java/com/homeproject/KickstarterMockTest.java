package com.homeproject;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class KickstarterMockTest {

    @Mock
    private IO io;
    @Mock
    private QuoteGenerator quoteGenerator;
    @Mock
    private Categories categories;
    @Mock
    private Projects projects;

    @Mock
    Category category3;
    @Mock
    Category category4;

    @InjectMocks
    Kickstarter kickstarter;

    Category category = new Category("firstCategory");
    Category category2 = new Category("secondCategory");



    @Test (timeout = 1000)
    public void runTestExitFromMetodWithNoCategories() {
        when(quoteGenerator.nextQuote()).thenReturn("Very thoughtfully phraze");
        when(io.read()).thenReturn(1, 1, 0);

        kickstarter.run();

        verify(quoteGenerator, times(1)).nextQuote();
    }

    @Test (timeout = 1000)
    public void runTestExitFromProjectsAndMethod() {
        when(io.read()).thenReturn(1, 1, 2, 1, 0);

        when(categories.chooseCategory(1, kickstarter)).thenReturn(category, category3);

        Project projectOne = new Project("firstProject", 12, 14, "test1");
        Project projectTwo = new Project("secondProject", 12, 14, "test2");
        Project[] project = new Project[] {projectOne, projectTwo};
        when(projects.getProjects(category)).thenReturn(project);

        kickstarter.run();

        verify(categories, atLeastOnce()).chooseCategory(1, kickstarter);
        verify(projects, times(1)).getProjects(category);

        assertEquals("firstProject", projectOne.getName());
        assertEquals("secondProject", projectTwo.getName());
    }

}

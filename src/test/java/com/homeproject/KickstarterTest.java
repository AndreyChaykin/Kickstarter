package com.homeproject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class KickstarterTest {

    private Categories categories;
    private Projects projects;
    private FakeIO io;
    private Kickstarter kickstarter;
    private Category firstCategory;
    private Category secondCategory;

    @Before
    public void setUp() {
        io = new FakeIO(1, 0, 0);
        categories = new Categories();
        projects = new Projects();
        kickstarter = new Kickstarter(categories, projects, io, new StubQuoteGenerator("Some smart qoute"));
    }

    @Test
    public void shouldShowMenuWithNoCategoriesAndProject() {
//        kickstarter = new Kickstarter(categories, projects, io, new StubQuoteGenerator("Some smart qoute"));

        kickstarter.run();

        assertEquals("[Some smart qoute, Please, select category or \"0\" for exit:, " +
                "Wrong number of category, Please, try again!, " +
                "Please, select category or \"0\" for exit:]", io.getMessages().toString());
    }

    @Test
    public void shouldShowMenuWithCategories() {
        addCategories();

//        kickstarter = new Kickstarter(categories, projects, io, new StubQuoteGenerator("Some smart qoute"));

        kickstarter.run();

        assertEquals("[Some smart qoute, Please, select category or \"0\" for exit:, " +
                "You have been select: Category{name='firstCategory'}, " +
                "There is no projects in this category. Enter '0' for exit, Please, select project:, " +
                "Please, select category or \"0\" for exit:]", io.getMessages().toString());
    }

    @Test
    public void shouldShowMenuWithCategoriesAndProjects() {
        addProjectsInCategories();
        io = new FakeIO(1, 1, 0, 2, 0, 0);
        kickstarter = new Kickstarter(categories, projects, io, new StubQuoteGenerator("Some smart qoute"));

        kickstarter.run();

        assertEquals("[Some smart qoute, Please, select category or \"0\" for exit:, " +
                "You have been select: Category{name='firstCategory'}, " +
                "Project name: Test1, About: Test One description, " +
                "Sum of project: 100, Sum exist: 0, Please, select project:, 0: " +
                "Project{name='Test1', description='Test One description'}, " +
                "Wrong number of project, Please, try again!, " +
                "Please, select project:, 0: Project{name='Test1', description='Test One description'}, " +
                "Please, select category or \"0\" for exit:, You have been select: Category{name='secondCategory'}, " +
                "Project name: Test2, About: Test Two description, " +
                "Sum of project: 200, Sum exist: 0, Please, select project:, 0: " +
                "Project{name='Test2', description='Test Two description'}, " +
                "Please, select category or \"0\" for exit:]", io.getMessages().toString());
    }

    @After
    public void teadDown() {
        kickstarter = null;
        categories = null;
        projects = null;
        io = null;
    }

    private void addCategories() {
        firstCategory = new Category("firstCategory");
        secondCategory = new Category("secondCategory");

        categories.add(firstCategory);
        categories.add(secondCategory);
    }

    private void addProjectsInCategories() {
        addCategories();

        Project projectOne = new Project("Test1", 100, 10, "Test One description");
        Project projectTwo = new Project("Test2", 200, 20, "Test Two description");
        projectOne.setCategory(firstCategory);
        projectTwo.setCategory(secondCategory);

        projects.add(projectOne);
        projects.add(projectTwo);
    }

    private class FakeIO implements IO {
        List<String> messages = new LinkedList<String>();
        List<Integer> fakeIOConsole = new LinkedList<Integer>();

        public FakeIO(Integer... numbers) {
            fakeIOConsole = new LinkedList<Integer>(Arrays.asList(numbers));
        }

        public void println(String message) {
            messages.add(message);
        }

        public int read() {
            return fakeIOConsole.remove(0);
        }

        public List<String> getMessages() {
            return messages;
        }
    }

    private class StubQuoteGenerator extends QuoteGenerator {
        private final String quote;

        public StubQuoteGenerator(String quote) {
            super(new Random());
            this.quote = quote;
        }

        @Override
        protected String nextQuote() {
            return quote;
        }
    }
}

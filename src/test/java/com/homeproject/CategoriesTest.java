package com.homeproject;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CategoriesTest {

    private Categories categories;
    private Category categoryFirst;
    private Category categorySecond;
    private Category categoryThird;

    @Before
    public void setUp() {
        categories = new Categories();
        categoryFirst = new Category("FirstCategory");
        categorySecond = new Category("SecondCategory");
        categoryThird = new Category("ThirdCategory");
    }

    @Test
    public void addNewCategory() {
        categories.add(categoryFirst);

        assertEquals(categoryFirst, categories.getCategory(0));
    }

    @Test
    public void getCategoryByNumber() {
        categories.add(categoryFirst);
        categories.add(categorySecond);
        categories.add(categoryThird);

        assertEquals(categoryFirst, categories.getCategory(0));
        assertEquals(categorySecond, categories.getCategory(1));
        assertEquals(categoryThird, categories.getCategory(2));
    }

    @Test
    public void getCategoriesTest() {
        categories.add(categoryFirst);
        categories.add(categorySecond);
        categories.add(categoryThird);

        Category[] expected = new Category[10];
        expected[0] = categoryFirst;
        expected[1] = categorySecond;
        expected[2] = categoryThird;

        assertArrayEquals(expected, categories.getCategories());
    }

    @Test
    public void sizeTest() {
        categories.add(categoryFirst);
        assertEquals(1, categories.size());

        categories.add(categorySecond);
        categories.add(categoryThird);
        assertEquals(3, categories.size());

        categories.add(new Category("CategoryFourth"));
        assertEquals(4, categories.size());
    }

    @Test
    public void sizeTestIfEmptyCategories() {
        Categories categories = new Categories();
        assertEquals(0, categories.size());
    }

    @After
    public void tearDown() {
        categories = null;
        categoryFirst = null;
        categorySecond = null;
        categoryThird = null;
    }
}

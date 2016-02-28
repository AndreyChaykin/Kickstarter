package com.homeproject;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CategoryTest {

    private Category category;

    @Before
    public void setUp() {
        category = new Category("Name");
    }
    @Test
    public void getNameTest() {
        category = new Category("Name");
        assertEquals("Name", category.getName());
    }

    @Test
    public void getNameCheckDiffTest() {
        assertNotSame("Not expected name", category.getName());
    }

    @After
    public void tearDown() {
        category = null;
    }
}

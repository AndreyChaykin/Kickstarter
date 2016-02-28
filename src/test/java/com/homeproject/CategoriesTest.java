package com.homeproject;

import org.junit.Assert;
import org.junit.Test;

public class CategoriesTest {

    @Test
    public void addNewCategory() {
        Category category = new Category("TestCategory");
        Categories categories = new Categories();
        categories.add(category);

        Assert.assertEquals(category, categories.getCategory(0));
    }

    @Test
    public void getCategoryByNumber() {
        Category category = new Category("TestCategory1");
        Category category2 = new Category("TestCategory2");
        Category category3 = new Category("TestCategory3");
        Categories categories = new Categories();
        categories.add(category);
        categories.add(category2);
        categories.add(category3);

        Assert.assertEquals(category, categories.getCategory(0));
        Assert.assertEquals(category2, categories.getCategory(1));
        Assert.assertEquals(category3, categories.getCategory(2));
    }
}

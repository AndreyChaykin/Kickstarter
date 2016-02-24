package com.homeproject;

public class Categories {

    Category[] categories = new Category[10];

    private int count = 0;

    public void add(Category category) {
        categories[count] = category;
        count++;
    }

    public String[] getGategoriesNames() {
        String[] result = new String[count];

        for (int i = 0; i < count; i++) {
            result[i] = String.valueOf(i) + " - " + categories[i].getName();
        }
        return result;
    }

    public Category[] getCategories() {
        return categories;
    }
}

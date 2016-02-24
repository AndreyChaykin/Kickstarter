package com.homeproject;

public class Categories {

    Category[] categories = new Category[10];
    private int count = 0;

    public void add(Category category) {
        categories[count] = category;
        count++;
    }

    public String getName(int index) {
        return categories[index].getName();
    }

    public Category[] getCategories() {
        return categories;
    }


    public Category getCategoryByName(String name) {
        for (int i = 0; i < categories.length; i++) {
            if (categories[i].getName().equals(name)) {
                return categories[i];
            }
        }
        return null;
    }
}

package com.homeproject;

public class Categories {

    Category[] categories = new Category[10];
    private int count = 0;

    public void add(Category category) {
        categories[count] = category;
        count++;
    }

    public Category getCategory(int index) {
        return categories[index];
    }

    public Category[] getCategories() {
        return categories;
    }



}

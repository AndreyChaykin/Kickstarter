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


    public int size() {
        return count;
    }

    Category chooseCategory(int index, Kickstarter kickstarter) {
        if (index <= 0 || index > size()) {
            return null;
        }
        Category result = getCategory(index - 1);
        return result;
    }
}

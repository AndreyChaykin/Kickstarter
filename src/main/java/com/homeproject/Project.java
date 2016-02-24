package com.homeproject;

/**
 * Created by andrey on 24.02.2016.
 */
public class Project {

    private String name;
    private int amount;
    private int sumAlready;
    private int days;
    private Category category;

    public Project(String name, int orientalSum, int days) {
        this.name = name;
        this.amount = orientalSum;
        this.days = days;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getSumAlready() {
        return sumAlready;
    }

    public void setSumAlready(int sumAlready) {
        this.sumAlready = sumAlready;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public Category getCategory() {
        return category;
    }
}

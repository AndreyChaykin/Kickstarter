package com.homeproject;

/**
 * Created by andrey on 24.02.2016.
 */
public class Project {

    private String name;
    private int orientalSum;
    private int sumAlready;
    private int days;
    private Category category;

    public Project(String name, int orientalSum, int days) {
        this.name = name;
        this.orientalSum = orientalSum;
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

    public int getOrientalSum() {
        return orientalSum;
    }

    public void setOrientalSum(int orientalSum) {
        this.orientalSum = orientalSum;
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
}

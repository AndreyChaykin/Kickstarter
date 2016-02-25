package com.homeproject;

/**
 * Created by andrey on 24.02.2016.
 */
public class Project {

    private String name;
    private int amount;
    private int sumExist;
    private int days;
    private Category category;
    private String description;
    private String questionAnswers;
    private String demoVideo;
    private String history;

    public Project(String name, int orientalSum, int days, String description) {
        this.name = name;
        this.amount = orientalSum;
        this.days = days;
        this.description = description;
        sumExist = 0;
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

    public int getSumExist() {
        return sumExist;
    }

    public void setSumExist(int sumExist) {
        this.sumExist = sumExist;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public String getQuestionAnswers() {
        return questionAnswers;
    }

    public String getDemoVideo() {
        return demoVideo;
    }

    public String getHistory() {
        return history;
    }
}

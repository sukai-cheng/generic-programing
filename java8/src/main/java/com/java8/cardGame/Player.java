package com.java8.cardGame;

public class Player {
    String grade;
    String name;
    String groupName;

    public Player(String grade, String name, String groupName) {
        this.grade = grade;
        this.name = name;
        this.groupName = groupName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}

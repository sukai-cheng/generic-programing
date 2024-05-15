package com.java8.cardGame;


public class Group {
    String groupName;
    Boolean winFlag;
    Boolean firstPassA;
    Player a;
    Player b;
    Integer mark;
    Integer passACount;
    Integer loseACount;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Boolean getWinFlag() {
        return winFlag;
    }

    public void setWinFlag(Boolean winFlag) {
        this.winFlag = winFlag;
    }

    public Boolean getFirstPassA() {
        return firstPassA;
    }

    public void setFirstPassA(Boolean firstPassA) {
        this.firstPassA = firstPassA;
    }

    public Player getA() {
        return a;
    }

    public void setA(Player a) {
        this.a = a;
    }

    public Player getB() {
        return b;
    }

    public void setB(Player b) {
        this.b = b;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public Integer getPassACount() {
        return passACount;
    }

    public void setPassACount(Integer passACount) {
        this.passACount = passACount;
    }

    public Integer getLoseACount() {
        return loseACount;
    }

    public void setLoseACount(Integer loseACount) {
        this.loseACount = loseACount;
    }

    public Group() {
    }

    public Group(String groupName, Boolean winFlag, Player a, Player b, Integer mark, Integer passACount, Integer loseACount, Boolean firstPassA) {
        this.groupName = groupName;
        this.winFlag = winFlag;
        this.a = a;
        this.b = b;
        this.mark = mark;
        this.passACount = passACount;
        this.loseACount = loseACount;
        this.firstPassA = firstPassA;
        a.setGroupName(groupName);
        b.setGroupName(groupName);
    }

}

package com.java8.cardGame;


import java.util.HashMap;
import java.util.Random;

public class Game {
    static HashMap<Integer, String> path = new HashMap<>();
    private static final HashMap<String, Boolean> gradeMap = new HashMap<>();

    public static void initCard() {

        path.put(2, "2");
        path.put(3, "3");
        path.put(4, "4");
        path.put(5, "5");
        path.put(6, "6");
        path.put(7, "7");
        path.put(8, "8");
        path.put(9, "9");
        path.put(10, "10");
        path.put(11, "J");
        path.put(12, "Q");
        path.put(13, "K");
        path.put(14, "A");

    }


    /**
     * 开始游戏
     */
    public void startGame() {

    }

    /**
     * 判定升级数
     */
    public static HashMap<String, Boolean> initGradeRecord() {

        gradeMap.put("上游", false);
        gradeMap.put("二游", false);
        gradeMap.put("三游", false);
        gradeMap.put("末游", false);

        return gradeMap;
    }

    /**
     * 获取随机
     */
    public static String getRandomPoint(HashMap<String, Boolean> pointMap) {
        String[] keys = pointMap.keySet().toArray(new String[0]);
        Random random = new Random();
        String randomKey = keys[random.nextInt(keys.length)];
        while (pointMap.get(randomKey)) {
            random = new Random();
            randomKey = keys[random.nextInt(keys.length)];
        }
        pointMap.put(randomKey, true);

        return randomKey;
    }

    /**
     * 洗牌
     */
    public static void shuffle() {

    }


    /**
     * 过A规则
     */
    public static void passARule(Group group) {
        Integer mark = group.getMark();
        String a = group.getA().getGrade();
        String b = group.getB().getGrade();
        if ((a.equals("上游") && b.equals("二游")) || a.equals("上游") && b.equals("三游") ||
                (b.equals("上游") && a.equals("二游")) || b.equals("上游") && a.equals("三游")) {
            group.setWinFlag(Boolean.TRUE);
        }else{
            group.setWinFlag(Boolean.FALSE);
        }

    }

    /**
     * 过A
     */
    public static void missARule(Group group) {
        if (group.getMark() >= 14) {
            Integer mark = group.getMark();
            Boolean winFlag = group.getWinFlag();
            String a = group.getA().getGrade();
            String b = group.getB().getGrade();
            if ((a.equals("上游") && b.equals("末游")) || a.equals("末游") && b.equals("上游")) {
                group.setLoseACount(group.getLoseACount() + 1);
            } else if (!winFlag) {
                group.setLoseACount(group.getLoseACount() + 1);
            }
            group.mark = 14;
        }

    }

    /**
     * 三次不过A
     */
    public static void punishment(Group group) {
        if (group.getLoseACount() > 3) {
            group.setMark(2);
            group.setLoseACount(0);
        }
    }


    /**
     * 计算当前小组的得分
     */
    public static String calMark(HashMap<Integer, String> path, Integer point, Group group) {
        Integer mark = group.getMark();
        String currentMark = path.get(point + mark);
        group.setMark(point + mark);
        return currentMark;
    }

    /**
     * 计算得分数
     */
    public static Integer calPoint(Player a, Player b) {
        String gradeA = a.getGrade();
        String gradeB = b.getGrade();
        if (gradeA.equals("上游")) {
            if (gradeB.equals("二游")) {
                return 3;
            } else if (gradeB.equals("三游")) {
                return 2;
            } else {
                return 1;
            }
        } else if (gradeB.equals("上游")) {
            if (gradeA.equals("二游")) {
                return 3;
            } else if (gradeA.equals("三游")) {
                return 2;
            } else {
                return 1;
            }
        }

        return 0;
    }

    /**
     * 判断哪组获胜
     */
    public static boolean checkWins(Group group) {
        Player a = group.getA();
        Player b = group.getB();
        if (a.getGrade().equals("上游") || b.getGrade().equals("上游")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断哪组获胜
     */
    public static Group checkWins(Group groupA, Group groupB) {
        if (checkWins(groupA)) {
            return groupA;
        } else {
            return groupB;
        }
    }


    public static void main(String[] args) {
        initCard();

        Player a = new Player(null, "a", null);
        Player b = new Player(null, "b", null);
        Player c = new Player(null, "c", null);
        Player d = new Player(null, "d", null);

        // 分组
        Group groupA = new Group("group-A", false, a, b, 2, 0, 0, true);
        Group groupB = new Group("group-B", false, c, d, 2, 0, 0, true);

        while (true) {
            HashMap<String, Boolean> gradeRecord = initGradeRecord();
            a.setGrade(getRandomPoint(gradeRecord));
            b.setGrade(getRandomPoint(gradeRecord));
            c.setGrade(getRandomPoint(gradeRecord));
            d.setGrade(getRandomPoint(gradeRecord));
            // 检查哪个小组取得上游
            Group group = checkWins(groupA, groupB);

            // 统计分数
            Integer point = calPoint(group.a, group.b);
            calMark(path, point, group);

            // 规则判断
            if (group.getMark() >= 14 && group.getFirstPassA()) {
                group.setFirstPassA(false);
                group.setMark(14);
                if(group.getGroupName().equals("group-A")){
                    missARule(groupB);
                    punishment(groupB);
                }else if(group.getGroupName().equals("group-B")){
                    missARule(groupA);
                    punishment(groupA);
                }
            } else if (group.getMark() > 14) {
                passARule(group);
                missARule(groupA);
                missARule(groupB);
                punishment(groupA);
                punishment(groupB);
                if (group.getWinFlag()) {
                    break;
                }
            } else {
                missARule(groupA);
                missARule(groupB);
                punishment(groupA);
                punishment(groupB);
            }
            System.out.printf("A队总分: %s, B队总分 %s, A小组成员的结果: %s %s, A队是否第一次打A %s, A队打A机会: %s, A队过A机会: %s, B小组成员的结果: %s, %s,B队是否第一次打A %s,B队打A机会: %s,B队过A机会: %s,\n",
                    groupA.getMark(), groupB.getMark(), groupA.getA().grade, groupA.getB().grade,groupA.firstPassA, groupA.loseACount, groupA.passACount, groupB.getA().grade, groupB.getB().grade, groupB.firstPassA,groupB.loseACount, groupB.passACount);

        }

        System.out.printf("A队总分: %s, B队总分 %s, A小组成员的结果: %s %s, A队是否第一次打A %s, A队打A机会: %s, A队过A机会: %s, B小组成员的结果: %s, %s,B队是否第一次打A %s,B队打A机会: %s,B队过A机会: %s,\n",
                groupA.getMark(), groupB.getMark(), groupA.getA().grade, groupA.getB().grade,groupA.firstPassA, groupA.loseACount, groupA.passACount, groupB.getA().grade, groupB.getB().grade, groupB.firstPassA,groupB.loseACount, groupB.passACount);
        if (groupA.getWinFlag()) {
            System.out.println("A组win");
        } else {
            System.out.println("B组win");
        }


    }


}



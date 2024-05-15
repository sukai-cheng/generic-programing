package com.java8;

import java.util.Scanner;

public class GuandanGame {
    private int scoreA;
    private int scoreB;

    public GuandanGame() {
        this.scoreA = 2; // 初始从2开始
        this.scoreB = 2;
    }

    public void playRound() {
        // 模拟比赛一轮的过程
        // 这里可以根据实际情况修改，例如从输入获取牌面，模拟比赛结果等
        // 这里简单起见，直接手动输入比分
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter score for Team A:");
        int roundScoreA = scanner.nextInt();
        System.out.println("Enter score for Team B:");
        int roundScoreB = scanner.nextInt();

        // 记分逻辑
        if (roundScoreA > roundScoreB) {
            // A赢
            scoreA += roundScoreA - roundScoreB;
        } else if (roundScoreA < roundScoreB) {
            // B赢
            scoreB += roundScoreB - roundScoreA;
        }

        // 输出当前比分
        System.out.println("Current score - Team A: " + scoreA + ", Team B: " + scoreB);
    }

    public void playGame() {
        // 模拟整个比赛的过程
        for (int i = 0; i < 3; i++) {
            // 三次打A的机会
            playRound();

            // 检查是否已经过A
            if (scoreA >= 'A' - '0') {
                System.out.println("Team A wins!");
                return;
            }

            // 重置B的上游状态
            scoreB = 2;
        }

        // 三次打A都未过A，重置到2重新升级
        System.out.println("Reset to 2 and start over.");
        scoreA = 2;
        scoreB = 2;
    }

    public static void main(String[] args) {
        GuandanGame game = new GuandanGame();
        game.playGame();
    }
}
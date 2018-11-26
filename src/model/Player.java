package model;

import java.util.Scanner;

public class Player {
    private Team playerTeam;
    private String playerName;
    private int age;
    private int backNumber;
    private String position;
    private int numApperances;
    private int numGoals;

    Scanner scanner = new Scanner(System.in);

    public Player(Team playerTeam, int backNumber, String playerName, int age, String position) {
        this.playerTeam = playerTeam;
        this.backNumber = backNumber;
        this.playerName = playerName;
        this.age = age;
        this.position = position;
        numApperances = 0;
        numGoals = 0;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getBackNumber() {
        return backNumber;
    }

    public Team getPlayerTeam() {
        return playerTeam;
    }

    public void scoreGoal() {
        System.out.println(playerName + "has scored a goal!");
        numGoals++;
    }

}

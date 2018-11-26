package model;

import java.io.Serializable;
import java.util.Scanner;

public class Player implements Serializable {
    private Team playerTeam;
    private String playerName;
    private int age;
    private int backNumber;
    private String position;
    private int numApperances;
    private int numGoals;

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

    public String getPosition() {
        return position;
    }

    public int getNumApperances() {
        return numApperances;
    }

    public int getNumGoals() {
        return numGoals;
    }

    public void scoreGoal() {
        System.out.println(playerName + " has scored a goal!");
        numGoals++;
    }

    public void addAppearance(){
        numApperances++;
    }
}

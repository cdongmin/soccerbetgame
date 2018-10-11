package model;

import java.util.Scanner;

public class Player extends Human {
    private String playerName;
    private int age;
    private int backNumber;
    private String position;
    private int numApperances;
    private int numGoals;
    private int numAssists;

    Scanner scanner = new Scanner(System.in);

    public Player(String playerName, int age, int backNumber, String position) {
        this.playerName = playerName;
        this.age = age;
        this.backNumber = backNumber;
        this.position = position;
        numApperances = 0;
        numGoals = 0;
        numAssists = 0;
    }

    public String getPlayerName(){
        return playerName;
    }
    public void run(){
        System.out.println(playerName+" is sprinting for the ball!");
    }

    public void scoreGoal(){
        System.out.println(playerName+"has scored a goal!");
        numGoals++;
    }
}

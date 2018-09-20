package ui;

import java.util.Scanner;
import ui.Team;

public class Player {
    private String playerName;
    private int age;
    private int backNumber;
    private String position;
    private int numApperances;
    private int numGoals;
    private int numAssists;

    Scanner scanner = new Scanner(System.in);

    public Player(String playerName, int age, int backNumber, String position){
        this.playerName = playerName;
        this.age = age;
        this.backNumber = backNumber;
        this.position = position;
    }

}

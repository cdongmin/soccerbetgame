package ui;

import java.awt.Color;
import java.util.ArrayList;

public class Team {
    private String teamName;
    private Color teamColor;
    private ArrayList<Player> players;

    public Team(String teamName, Color teamColor){
        this.teamName = teamName;
        this.teamColor = teamColor;
    }

    public String getTeamName(Team team){
        return team.teamName;
    }

    public void printTeam(){
        System.out.println(teamName);
        System.out.println(teamColor);
    }

    public void assignTeam(Player newPlayer){
        players.add(newPlayer);
    }

    public void printTeamPlayers(){
        for(Player player:players){
            System.out.println(player);
        }
    }
}

package ui;

import java.awt.Color;
import java.util.ArrayList;


public class Team {
    private String teamName;
    private Color teamColor;
    private ArrayList<Player> players;

    //REQUIRES: non-null parameters
    //MODIFIES: this
    //EFFECTS: makes a new team
    public Team(String teamName, Color teamColor){
        this.teamName = teamName;
        this.teamColor = teamColor;
        players = new ArrayList<>();
    }

    //EFFECTS: returns name of the team
    public String getTeamName(){
        return teamName;
    }

    //EFFECTS: returns color of the team
    public Color getColor(){
        return teamColor;
    }

    //EFFECTS: prints out name of team in color
    public void printTeam(){
        System.out.println(teamName);
        System.out.println(teamColor);
    }

    //REQUIRES: non-null parameter
    //MODIFIES: this
    //EFFECTS: assigns a player to a team
    public void assignTeam(Player newPlayer){
        players.add(newPlayer);
    }

    //EFFECTS: prints out all players in a team
    public void printTeamPlayers(){
        for(Player player:players){
            System.out.println(player.playerName);
        }
    }

    //REQUIRES: non-null parameter
    //EFFECTS: returns a specific player of team
    public Player returnOneTeamPlayer(int number){
        Player p = null;
        for(int i = 0;i<=players.size();i++){
            if (number-1 == i){
                p = players.get(i);
            }
        }
        return p;
    }
}

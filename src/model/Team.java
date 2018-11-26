package model;

import Exceptions.NothingFoundException;

import java.awt.Color;
import java.lang.reflect.Array;
import java.util.*;


public class Team extends Component {
    private String teamName;
    private Color teamColor;
    protected HashSet<Player> players;

    //REQUIRES: non-null parameters
    //MODIFIES: this
    //EFFECTS: makes a new team
    public Team(String teamName, Color teamColor) {
        this.teamName = teamName;
        this.teamColor = teamColor;
        players = new HashSet<>();
    }


    //EFFECTS: returns name of the team
    public String getTeamName() {
        return teamName;
    }

    //EFFECTS: returns color of the team
    public Color getColor() {
        return teamColor;
    }

    public HashSet<Player> getPlayers() {
        return players;
    }

    //EFFECTS: prints out name of team in color
    public void printTeam() {
        System.out.println(teamName);
        System.out.println(teamColor);
    }

    //REQUIRES: non-null parameter
    //MODIFIES: this
    //EFFECTS: assigns a player to a team
    public void addPlayer(Player newPlayer) {
        if (!players.contains(newPlayer)) {
            players.add(newPlayer);
        }
    }

    public void removePlayer(Player getRidOf) {
        this.getPlayers().remove(getRidOf);
    }

    //EFFECTS: prints out all players in a team
    public String printTeamPlayers() {
        String string = null;
        for (Player player : players) {
            string+="Name: " + player.getPlayerName() + " Number: " + player.getBackNumber()+"";
        }
        return string;
    }

    private Player lookForPlayer(String input) throws NothingFoundException {
        Player aPlayer = null;
        for (Player player : players) {
            if (input.equals(player.getPlayerName()))
                aPlayer = player;
        }
        if (aPlayer == null) {
            throw new NothingFoundException();
        }
        return aPlayer;
    }

}

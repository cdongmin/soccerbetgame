package model;

import Exceptions.NothingFoundException;

import java.awt.Color;
import java.io.*;
import java.util.*;


public class Team implements Serializable, Comparable<Team> {
    private String teamName;
    private Color teamColor;
    private HashSet<Player> players;
    private File playersStats;
    private int points;
    private File pointsStats;
    private int standing;
    private static final long serialVersionUID = -6293520643154234138L;

    //REQUIRES: non-null parameters
    //MODIFIES: this
    //EFFECTS: makes a new team
    public Team(String teamName, Color teamColor) {
        this.teamName = teamName;
        this.teamColor = teamColor;
        players = new HashSet<>();
        playersStats = new File(teamName + "PlayerStats");
        points = 0;
        pointsStats = new File(teamName + "Points");
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

    public void setPlayers(HashSet<Player> players) {
        this.players = players;
    }

    public File getPlayersStats() {
        return playersStats;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public File getPointsStats() {
        return pointsStats;
    }

    public int getStanding() {
        return standing;
    }

    public void setStanding(int standing) {
        this.standing = standing;
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
        String linebreaker = System.lineSeparator();
        StringBuilder string = new StringBuilder();
        for (Player player : players) {
            string.append("Name: ").append(player.getPlayerName()).append(" Number: ").append(player.getBackNumber()).append(linebreaker);
        }
        return string.toString();
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

    @Override
    public int compareTo(Team team) {
        return Integer.compare(team.points,this.points);
    }


    public void savePointsStats() throws IOException{
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(this.getPointsStats()));
        out.writeObject(this.getPoints());
        out.close();
    }


    public int loadPointsStats() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(this.getPointsStats()));
        int points = (int) in.readObject();
        in.close();
        return points;
    }
}

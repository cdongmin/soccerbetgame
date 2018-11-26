package model;

import Exceptions.NothingFoundException;

import java.util.HashMap;

public class League {
    private String name;
    protected HashMap<String, Team> teams;

    public League() {
        name = new String();
        teams = new HashMap<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, Team> getTeams() {
        return teams;
    }

    public void addTeam(Team team) {
        if (!teams.containsKey(team.getTeamName())) {
            teams.put(team.getTeamName(), team);
        }
    }

    public Team lookForTeam(String input) throws NothingFoundException {
        if (teams.containsKey(input))
            return teams.get(input);
        else
            throw new NothingFoundException();
        /*
        Team returnTeam = null;
        for (Team team : this.getTeams().keySet()) {
            if (input.equals(team.getTeamName())) {
                returnTeam = team;
            }
        }
        if (returnTeam == null) {
            throw new NothingFoundException();
        }
        return returnTeam;
        */
    }
}

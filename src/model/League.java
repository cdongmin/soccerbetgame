package model;

import Exceptions.NothingFoundException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class League extends Component {
    private String name;
    private HashMap<Team, HashSet<Player>> teams;

    public League(String name) {
        this.name = name;
        teams = new HashMap<>();
    }

    public HashMap<Team, HashSet<Player>> getTeams() {
        return teams;
    }

    public void addTeam(Team team) {
        if (!teams.containsKey(team)) {
            teams.put(team, team.getPlayers());
        }
    }

    public Team lookForTeam(String input) throws NothingFoundException {
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
    }
}

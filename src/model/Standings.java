package model;

import java.lang.reflect.Array;
import java.util.*;

public class Standings extends League {
    private List<Team> teamStandings;

    public Standings() {
        super();
        teamStandings = new ArrayList<>();
    }

    public void initializeStandings() {
        teamStandings.addAll(teams.values());
        for (Team t : teamStandings)
            t.setStanding(1);
    }

    public void decideStandings() {
        Collections.sort(teamStandings);
        for (Team t : teamStandings)
            t.setStanding(teamStandings.indexOf(t) + 1);
        Team a = null;
        for (int i = 0; i < teamStandings.size(); i++) {
            if (i == 0)
                a = teamStandings.get(i);
            else if (teamStandings.get(i).getPoints() == a.getPoints())
                teamStandings.get(i).setStanding(teamStandings.indexOf(a)+1);
            else
                a = teamStandings.get(i);
        }
    }

    public void displayStandings() {
        for (Team team : teamStandings)
            System.out.println(team.getTeamName() + "'s place: " + team.getStanding() + " with " + team.getPoints() + " points");
    }

}




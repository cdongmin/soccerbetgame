package model;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Game extends Bet {
    private int betTeamScore;
    private int oppositionScore;
    private boolean wonOrNot;
    private Random rand = new Random(System.currentTimeMillis());

    public Game() {
        betTeamScore = 0;
        oppositionScore = 0;

    }

    public boolean isWonOrNot() {
        return wonOrNot;
    }

    public void setBetTeamScore() {
        this.betTeamScore = rand.nextInt(5);
    }

    public void setOppositionScore() {
        this.oppositionScore = rand.nextInt(5);
    }

    public void setWonOrNot() {
        if (betTeamScore > oppositionScore) {
            wonOrNot = true;
            int b = betTeam.getPoints();
            betTeam.setPoints(b + 3);
        } else {
            wonOrNot = false;
            if (betTeamScore == oppositionScore) {
                int b = betTeam.getPoints();
                betTeam.setPoints(b + 1);
                int c = oppositionTeam.getPoints();
                oppositionTeam.setPoints(c + 1);
            } else {
                int b = oppositionTeam.getPoints();
                oppositionTeam.setPoints(b + 3);
            }
        }
    }

    public void startGame(League league) {
        try {
            betTeam.setPlayers(loadTeamStats(betTeam));
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("");
        }
        oppositionTeam = selectOppositionTeam(league.getTeams());
        try {
            oppositionTeam.setPlayers(loadTeamStats(oppositionTeam));
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("");
        }
        addAppearance();
        setBetTeamScore();
        setOppositionScore();
        setWonOrNot();
        for (int i = 0; i < betTeamScore; i++)
            selectGoalScorer(betTeam);
        for (int i = 0; i < oppositionScore; i++)
            selectGoalScorer(oppositionTeam);
        try {
            savePlayersStats(betTeam);
        } catch (IOException e) {
            System.out.println("");
        }
        try {
            savePlayersStats(oppositionTeam);
        } catch (IOException e) {
            System.out.println("");
        }
        System.out.println("Your team's score: " + betTeamScore + " vs. Opponent team's score: " + oppositionScore);
        if (wonOrNot) {
            System.out.println("You have won!!");
            win();
            notifyObserversResult(this);
            System.out.println("You now have " + getAmount() + "coins");
        } else {
            System.out.println("You have lost.");
            lose();
            notifyObserversResult(this);
            System.out.println("You now have " + getAmount() + "coins");
            if (getAmount() == 0) {
                gameOver();
            }
        }
    }

    public Team selectOppositionTeam(HashMap<String, Team> league) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < league.size(); i++)
            set.add(i);
        int a = rand.nextInt(league.size());
        Team opposition = (Team) league.values().toArray()[a];
        if (opposition.equals(betTeam)) {
            set.remove(a);
            int b = rand.nextInt(set.size());
            int c = (int) set.toArray()[b];
            opposition = (Team) league.values().toArray()[c];
        }
        return opposition;
    }

    public void addAppearance() {
        for (Player p : betTeam.getPlayers())
            p.addAppearance();
        for (Player p : oppositionTeam.getPlayers())
            p.addAppearance();
    }

    public void selectGoalScorer(Team team) {
        boolean attackerScore = rand.nextDouble() <= 0.65;
        boolean midfielderScore = rand.nextDouble() <= 0.2;
        boolean defenderScore = rand.nextDouble() <= 0.15;
        if (attackerScore) {
            midfielderScore = false;
            defenderScore = false;
            for (Player p : team.getPlayers()) {
                if (p.getPosition().equals("Attacker"))
                    p.scoreGoal();
            }
        } else if (defenderScore) {
            attackerScore = false;
            midfielderScore = false;
            for (Player p : team.getPlayers()) {
                if (p.getPosition().equals("Defender"))
                    p.scoreGoal();
            }
        } else {
            midfielderScore = true;
            attackerScore = false;
            defenderScore = false;
            for (Player p : team.getPlayers()) {
                if (p.getPosition().equals("Midfielder"))
                    p.scoreGoal();
            }
        }
    }

    public void savePlayersStats(Team team) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(team.getPlayersStats()));
        out.writeObject(team.getPlayers());
        out.close();
    }


    public HashSet<Player> loadTeamStats(Team team) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(team.getPlayersStats()));
        HashSet<Player> players = (HashSet<Player>) in.readObject();
        in.close();
        return players;
    }

}

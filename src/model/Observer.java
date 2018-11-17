package model;

public interface Observer {
    public void update(Team team, Bet bet);

    public void updateResult(Game bet);
}

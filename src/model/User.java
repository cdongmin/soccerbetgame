package model;

import java.io.Serializable;

public class User implements Observer, Serializable{
    private String name;

    public User(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void update(Team team, Bet bet) {
        System.out.println(getName()+" has put "+bet.getBetAmount()+ " on "+team.getTeamName()+".");
    }

    @Override
    public void updateResult(Game bet){
        if(bet.isWonOrNot())
            System.out.println(getName()+" won "+bet.getBetAmount()*2+" coins.");
        else
            System.out.println(getName()+" lost "+bet.getBetAmount()+" coins. ");
    }
}

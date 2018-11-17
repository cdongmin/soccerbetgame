package model;

public class User implements Observer{
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
        if(bet.wonOrNot)
            System.out.println(getName()+" won "+bet.getBetAmount()+" coins.");
        else
            System.out.println(getName()+" lost "+bet.getBetAmount()+" coins. ");
    }
}

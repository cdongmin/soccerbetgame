package model;

import java.util.Random;

public class Game extends Bet{
    private int betTeamScore;
    private int oppositionScore;
    protected boolean wonOrNot;
    private Random rand = new Random(System.currentTimeMillis());

    public Game(){
        betTeamScore = 0;
        oppositionScore = 0;
    }

    public void setBetTeamScore() {
        this.betTeamScore = rand.nextInt(5);
    }

    public void setOppositionScore(){
        this.oppositionScore = rand.nextInt(5);
    }

    public void setWonOrNot(){
        if(betTeamScore>oppositionScore)
            wonOrNot = true;
        else
            wonOrNot = false;
    }

    public void startGame(){
        setBetTeamScore();
        setOppositionScore();
        setWonOrNot();
        System.out.println("Your team's score: "+betTeamScore+" vs. Opponent team's score: "+oppositionScore);
        if(wonOrNot){
            System.out.println("You have won!!");
            win();
            notifyObserversResult(this);
            System.out.println("You now have "+getAmount()+"coins");
        }
        else {
            System.out.println("You have lost.");
            lose();
            notifyObserversResult(this);
            System.out.println("You now have "+getAmount()+"coins");
            if(amount == 0){
                gameOver();
            }
        }
    }

}

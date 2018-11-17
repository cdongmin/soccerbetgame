package model;

import java.util.Random;

public class Game extends Bet{
    private int betTeamScore;
    private int oppositionScore;
    protected boolean wonOrNot;
    private Random rand;

    public Game(){
        rand = new Random();
        betTeamScore = rand.nextInt(5);
        oppositionScore = rand.nextInt(5);
        if(betTeamScore>oppositionScore)
            wonOrNot = true;
        else
            wonOrNot = false;
    }

    public void startGame(){
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

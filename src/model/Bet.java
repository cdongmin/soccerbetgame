package model;

import Exceptions.InvalidInputException;
import Exceptions.OutOfMoneyException;

import java.util.Scanner;

public class Bet extends UserManager {
    private final int INITIAL_AMOUNT = 10000;
    protected int amount;
    private int betAmount;
    private int multiplier;
    private Team betTeam;

    Scanner scanner = new Scanner(System.in);

    public Bet() {
        amount = INITIAL_AMOUNT;
        multiplier = 2;
    }

    //EFFECTS: returns amount of coins
    public int getAmount() {
        return amount;
    }

    public void setBetTeam(Team betTeam) {
        this.betTeam = betTeam;
    }

    public int getBetAmount() {
        return betAmount;
    }

    //EFFECTS: prints the remaining amount of coins
    public void betting(int betAmount) throws OutOfMoneyException, InvalidInputException {
        this.betAmount=betAmount;
        assert (amount != 0);
        if (betAmount > amount) {
            throw new OutOfMoneyException();
        } else if (betAmount <= 0) {
            throw new InvalidInputException();
        } else {
            amount = amount - betAmount;
            notifyObservers(betTeam,this);
            System.out.println("Your remaining number of coins is: " + amount + "coins");
        }
    }

    public void win() {
        amount = amount + (betAmount * multiplier);
    }

    public void lose() {

    }

    public void gameOver() {
        assert (amount == 0);
        System.out.println("GAME OVER");
    }
}


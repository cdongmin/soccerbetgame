package model;

import Exceptions.OutOfMoneyException;

import java.util.Scanner;

public class Bet {
    private final static int initialAmount = 10000;
    private static int amount;

    Scanner scanner = new Scanner(System.in);

    public Bet() {
        amount = initialAmount;
    }

    public void gameOver() {
        if (amount == 0) {
            System.out.println("GAME OVER");
        }
    }

    //EFFECTS: returns amount of coins
    public int getAmount(){
        return amount;
    }

    //EFFECTS: prints the remaining amount of coins
    public void betting(int betAmount) throws OutOfMoneyException  {
        if (betAmount > amount) {
            throw new OutOfMoneyException();
        } else {
            amount = amount - betAmount;
            System.out.println("Your remaining number of coins is: " + amount + "coins");
        }
    }

}


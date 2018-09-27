package ui;

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

    public int getAmount(){
        return amount;
    }

    public void betting() {
        int betAmount = scanner.nextInt();
        if (betAmount > amount) {
            System.out.println("Insufficient coins :(");
        } else {
            amount = amount - betAmount;
            System.out.println("Your remaining number of coins is: " + amount + "coins");
        }
    }

}


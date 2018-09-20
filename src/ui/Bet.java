package ui;

import java.util.Scanner;

public class Bet {
    private static int amount;

    public void gameOver() {
        if (amount == 0) {
            System.out.println("GAME OVER");
        }
    }

    public static void startBet() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1.Bet 2.See Balance 3.Exit");
            int option = scanner.nextInt();
            if (option == 1) {
                System.out.println("1.Bet on team 2.Bet on player");
                int option2 = scanner.nextInt();
                if (option2 == 1) {
                    System.out.println("Select the team you want to bet on");
                    //...
                } else if (option2 == 2) {
                    System.out.println("Select the team the player you want to be on is part of");
                    //...
                }
                System.out.println("How much money do you want to bet?");
                int betAmount = scanner.nextInt();
                if (betAmount > amount) {
                    System.out.println("Insufficient coins :(");
                } else {
                    System.out.println("Your remaining number of coins is: " + (amount - betAmount) + "coins");
                }
                break;
            } else if (option == 2) {
                System.out.println("Your balance is: " + amount + "coins :)");
            } else if (option == 3) {
                break;
            }
        }
    }
}

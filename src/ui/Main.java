package ui;

import Exceptions.InvalidInputException;
import Exceptions.NothingFoundException;
import Exceptions.OutOfMoneyException;
import Exceptions.WrongChoiceException;
import model.*;

import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {
        League CanadaSoccerLeague = new League("Canada Soccer League");
        Scanner scanner = new Scanner(System.in);

        BufferedReader br = null;
        try {

            URL url = new URL("https://www.ugrad.cs.ubc.ca/~cs210/2018w1/welcomemsg.html");
            br = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;

            StringBuilder sb = new StringBuilder();

            while ((line = br.readLine()) != null) {

                sb.append(line);
                sb.append(System.lineSeparator());
            }

            System.out.println(sb);
        } finally {

            if (br != null) {
                br.close();
            }
        }

        CurrentSeason season = new CurrentSeason(2018);
        season.makeSeason();

        System.out.println("Welcome!");
        lineBreaker();

        System.out.println("===Participating Teams===");
        Team calgary = new Team("Calgary Reds", Color.red);
        CanadaSoccerLeague.addTeam(calgary);
        Player player1 = new Player(calgary, 5, "Min", 19, "Defender");
        Player player2 = new Player(calgary, 20, "Anna", 20, "Midfielder");
        Player player3 = new Player(calgary, 9, "Alan", 19, "Attacker");
        Player player4 = new Player(calgary, 1, "Louis", 19, "Goalkeeper");
        calgary.printTeam();
        calgary.addPlayer(player1);
        calgary.addPlayer(player2);
        calgary.addPlayer(player3);
        calgary.addPlayer(player4);
        lineBreaker();

        Team toronto = new Team("Toronto Blues", Color.blue);
        CanadaSoccerLeague.addTeam(toronto);
        Player player5 = new Player(toronto, 26, "Blues Defender", 37, "Defender");
        Player player6 = new Player(toronto, 8, "Blues Midfielder", 40, "Midfielder");
        Player player7 = new Player(toronto, 9, "Blues Attacker", 40, "Attacker");
        Player player8 = new Player(toronto, 1, "Blues Goalkeeper", 36, "Goalkeeper");
        toronto.printTeam();
        toronto.addPlayer(player5);
        toronto.addPlayer(player6);
        toronto.addPlayer(player7);
        toronto.addPlayer(player8);
        lineBreaker();

        Team vancouver = new Team("Vancouver Greens", Color.green);
        CanadaSoccerLeague.addTeam(vancouver);
        Player player9 = new Player(vancouver, 7, "Greens Midfielder", 17, "Midfielder");
        Player player10 = new Player(vancouver, 11, "Greens Attacker", 25, "Attacker");
        Player player11 = new Player(vancouver, 4, "Greens Defender", 30, "Defender");
        Player player12 = new Player(vancouver, 1, "Greens Goalkeeper", 26, "Goalkeeper");
        vancouver.printTeam();
        vancouver.addPlayer(player9);
        vancouver.addPlayer(player10);
        vancouver.addPlayer(player11);
        vancouver.addPlayer(player12);
        lineBreaker();

        Team edmonton = new Team("Edmonton Oranges", Color.orange);
        CanadaSoccerLeague.addTeam(edmonton);
        Player player13 = new Player(edmonton, 8, "Oranges Midfielder", 26, "Midfielder");
        Player player14 = new Player(edmonton, 10, "Oranges Attacker", 27, "Attacker");
        Player player15 = new Player(edmonton, 2, "Oranges Defender", 27, "Defender");
        Player player16 = new Player(edmonton, 1, "Oranges Goalkeeper", 23, "Goalkeeper");
        edmonton.addPlayer(player13);
        edmonton.addPlayer(player14);
        edmonton.addPlayer(player15);
        edmonton.addPlayer(player16);
        edmonton.printTeam();
        lineBreaker();

        while (true) {
            System.out.println("Would like to view team information? (Answer Y or N)");
            String yesOrNo = null;
            try {
                yesOrNo = scanner.nextLine();
                if (!(yesOrNo.equals("Y") || yesOrNo.equals("N"))) {
                    throw new InvalidInputException();
                }
            } catch (InvalidInputException e) {
                System.out.println("Invalid input. Please try again");
            }
            if (yesOrNo.equals("Y")) {
                System.out.print("Select a team: ");
                String input = scanner.nextLine();
                Team t;
                try {
                    t = CanadaSoccerLeague.lookForTeam(input);
                } catch (InvalidInputException e) {
                    System.out.println("That team does not exist");
                    continue;
                }
                t.printTeamPlayers();
            }
            if (yesOrNo.equals("N")) {
                break;
            }
        }


        System.out.println("Are you a new user? Answer Y or N)");
        User user = null;
        String answer = null;
        try {
            answer = scanner.nextLine();
            if (!(answer.equals("Y") || answer.equals("N"))) {
                throw new InvalidInputException();
            }
        } catch (InvalidInputException e) {
            System.out.println("Invalid input. Please try again");
        }
        if (answer.equals("Y")) {
            System.out.println("Please enter your name");
            String userName = scanner.nextLine();
            user = new User(userName);
        }
        //Implement when the input is N

        Game bet = new Game();
        while (true) {
            System.out.println("1.Bet 2.See Balance 3.Exit");
            int option = 0;
            try {
                option = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.next();
            }
            scanner.nextLine();
            if (option == 1) {
                bet.addObserver(user);
                System.out.print("Select the team you want to bet on: ");
                String selectTeam = scanner.nextLine();
                try {
                    Team tt = CanadaSoccerLeague.lookForTeam(selectTeam);
                    bet.setBetTeam(tt);
                } catch (InvalidInputException e) {
                    System.out.println("That team does not exist");
                    continue;
                }
                System.out.println("How much money do you want to bet?");
                int betAmount = scanner.nextInt();
                try {
                    bet.betting(betAmount);
                    bet.startGame();
                } catch (OutOfMoneyException e) {
                    System.out.println("Insufficient coins");
                } catch (InvalidInputException e) {
                    System.out.println("Please bet at least one coin");
                } finally {
                    System.out.println("Please continue");
                }
            } else if (option == 2) {
                System.out.println("Your balance is: " + bet.getAmount() + "coins :)");
            } else if (option == 3) {
                break;
            } else
                try {
                    throw new WrongChoiceException();
                } catch (InvalidInputException e) {
                    System.out.println("Invalid input. Please try again");
                }
        }
        save(bet);
        load();


    }

    public static void save(Bet bet) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("inputfile.txt"));
        PrintWriter writer = new PrintWriter("outputfile.txt", "UTF-8");
        lines.add("Your current number of coins: " + Integer.toString(bet.getAmount()));
        for (String line : lines) {
            writer.println(line);
        }
        writer.close(); //note -- if you miss this, the file will not be written at all.
    }

    public static void load() {
        Paths.get("outputfile.txt");
    }

    private static void lineBreaker() {
        System.out.println("");
    }
}


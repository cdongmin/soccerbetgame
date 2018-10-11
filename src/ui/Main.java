package ui;

import model.*;

import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;

public class Main {
    private static ArrayList<Team> teams = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        Season season = new CurrentSeason();
        season.makeSeason(2018);

        System.out.println("Welcome!");
        lineBreaker();

        System.out.println("===Participating Teams===");
        Team calgary = new Team("Calgary Reds", Color.red);
        teams.add(calgary);
        Player player1 = new Player("Min", 19, 5, "Defender");
        Player player2 = new Player("Anna", 20, 7, "Midfielder");
        Player player3 = new Player("Alan", 19, 9, "Attacker");
        Player player4 = new Player("Louis", 19, 1, "Goalkeeper");
        calgary.printTeam();
        calgary.assignTeam(player3);
        calgary.assignTeam(player2);
        calgary.assignTeam(player1);
        calgary.assignTeam(player4);
        lineBreaker();

        Team toronto = new Team("Toronto Blues", Color.blue);
        teams.add(toronto);
        Player player5 = new Player("John Terry", 37, 26, "Defender");
        Player player6 = new Player("Frank Lampard", 40, 8, "Midfielder");
        Player player7 = new Player("Didier Drogba", 40, 11, "Attacker");
        Player player8 = new Player("Petr Cech", 36, 1, "Goalkeeper");
        toronto.printTeam();
        toronto.assignTeam(player7);
        toronto.assignTeam(player6);
        toronto.assignTeam(player5);
        toronto.assignTeam(player8);
        lineBreaker();

        Team vancouver = new Team("Vancouver Greens", Color.green);
        teams.add(vancouver);
        Player player9 = new Player("Alphonso Davies", 17, 67, "Midfielder");
        Player player10 = new Player("Yordy Reyna", 25, 29, "Attacker");
        Player player11 = new Player("Kendall Waston", 30, 4, "Defender");
        Player player12 = new Player("Stefan Marinovic", 26, 1, "Goalkeeper");
        vancouver.printTeam();
        vancouver.assignTeam(player10);
        vancouver.assignTeam(player9);
        vancouver.assignTeam(player11);
        vancouver.assignTeam(player12);
        lineBreaker();

        Team edmonton = new Team("Edmonton Oranges", Color.orange);
        teams.add(edmonton);
        Player player13 = new Player("Jorginho", 26, 5, "Midfielder");
        Player player14 = new Player("Lorenzo Insigne", 27, 24, "Attacker");
        Player player15 = new Player("Kalidou Koulibaly", 27, 26, "Defender");
        Player player16 = new Player("Kepa", 23, 1, "Goalkeeper");
        edmonton.assignTeam(player14);
        edmonton.assignTeam(player13);
        edmonton.assignTeam(player15);
        edmonton.assignTeam(player16);
        edmonton.printTeam();
        lineBreaker();

        while (true) {
            System.out.println("Would like to view team information? (Answer Y OR N)");
            String yesOrNo = scanner.nextLine();
            if (yesOrNo.equals("Y")) {
                System.out.print("Select a team: ");
                String input = scanner.nextLine();
                Team t = lookForTeam(input, teams);
                t.printTeamPlayers();
            }
            if (yesOrNo.equals("N")) {
                break;
            }
        }

        Bet bet = new Bet();
        while (true) {
            System.out.println("1.Bet 2.See Balance 3.Exit");
            int option = scanner.nextInt();
            scanner.nextLine();
            if (option == 1) {
                System.out.println("Select the team you want to bet on:");
                String selectTeam = scanner.nextLine();
                Team tt = lookForTeam(selectTeam, teams);
                System.out.println("How much money do you want to bet?");
                int betAmount = scanner.nextInt();
                bet.betting(betAmount);
            } else if (option == 2) {
                System.out.println("Your balance is: " + bet.getAmount() + "coins :)");
            } else if (option == 3) {
                break;
            }
        }
        save(bet);
        load();

        System.out.println("Select a team:");
        String input = scanner.nextLine();
        Team t = lookForTeam(input, teams);
        System.out.println("Select a player on the team:");
        String input2 = scanner.nextLine();
        Player p = lookForPlayer(input2, t);
        p.run();
    }

    public static void save(Bet bet) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("inputfile.txt"));
        PrintWriter writer = new PrintWriter("outputfile.txt", "UTF-8");
        lines.add(Integer.toString(bet.getAmount()));
        for (String line : lines) {
            System.out.println("Your current number of coins: " + line);
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

    private static Team lookForTeam(String input, ArrayList<Team> teams) {
        Team returnTeam = null;
        for (Team team : teams) {
            if (Objects.equals(input, team.getTeamName()))
                returnTeam = team;
        }
        return returnTeam;
    }

    private static Player lookForPlayer(String input, Team team) {
        Player aPlayer = null;
        for (Player player : team.getPlayers()) {
            if (Objects.equals(input, player.getPlayerName()))
                aPlayer = player;
        }
        return aPlayer;
    }
}

package ui;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Team> teams = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        makeSeason(2018);
        lineBreaker();

        System.out.println("===Participating Teams===");
        Team vancouver = new Team("Vancouver Greens", Color.green);
        teams.add(vancouver);
        Player player1 = new Player("Player1",19,5,"Defense");
        Player player2 = new Player("Player2",20,7,"Midfield");
        Player player3 = new Player("Player3", 25,9,"Attack");
        vancouver.printTeam();
        vancouver.assignTeam(player1);
        vancouver.assignTeam(player2);
        vancouver.assignTeam(player3);
        lineBreaker();

        Team toronto = new Team("Toronto Blues", Color.blue);
        teams.add(toronto);
        toronto.printTeam();
        lineBreaker();

        Team calgary = new Team("Calgary Reds", Color.red);
        teams.add(calgary);
        calgary.printTeam();
        lineBreaker();

        Team edmonton = new Team("Edmonton Oranges", Color.orange);
        teams.add(edmonton);
        edmonton.printTeam();
        lineBreaker();

        Team winnipeg = new Team("Winnipeg Pinks", Color.pink);
        teams.add(winnipeg);
        winnipeg.printTeam();
        lineBreaker();

        Team halifax = new Team("Halifax Sky Blues", Color.cyan);
        teams.add(halifax);
        halifax.printTeam();
        lineBreaker();

        Team saskatoon = new Team("Saskatoon Yellows", Color.yellow);
        teams.add(saskatoon);
        saskatoon.printTeam();
        lineBreaker();

        Team ottawa = new Team("Ottawa Greys", Color.gray);
        teams.add(ottawa);
        ottawa.printTeam();
        lineBreaker();

        while(true) {
            System.out.println("Would like to view team information? (Answer Y OR N)");
            String yesorno = scanner.nextLine();
            if(yesorno == "Y") {
                System.out.print("Select a team: ");
                String input = scanner.nextLine();
                Team t = lookForTeam(input);
                t.printTeamPlayers();
                break;
            }
            if(yesorno=="N"){
                break;
            }
        }
        //Bet.startBet();
    }

    private static void makeSeason(int year){
        System.out.println("Welcome to Season "+year);
    }

    private static void lineBreaker(){
        System.out.println("");
    }

    private static Team lookForTeam(String input){
        Team nullTeam = null;
        for(Team team:teams){
            if(input==team.getTeamName(team))
                return team;
        }
        return nullTeam;
    }

}

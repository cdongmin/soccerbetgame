package ui;

public class Seasons {
    public static void main(String[] args) {
        makeSeason();
        lineBreaker();
        Teams.makeTeamVan();
        Players.makePlayers();
        lineBreaker();
        Teams.makeTeamTor();
        Players.makePlayers();
        lineBreaker();
        Teams.makeTeamCal();
        Players.makePlayers();
        lineBreaker();
        Teams.makeTeamEdm();
        Players.makePlayers();
        lineBreaker();
        Teams.makeTeamWin();
        Players.makePlayers();
        lineBreaker();
        Teams.makeTeamHal();
        Players.makePlayers();
        lineBreaker();
        Teams.makeTeamSas();
        Players.makePlayers();
        lineBreaker();
        Teams.makeTeamOtt();
        Players.makePlayers();
    }

    private static void makeSeason(){
        System.out.print("Welcome to Season 20");
        System.out.println("18 ~ 19");
    }

    private static void lineBreaker(){
        System.out.println("");
    }
}

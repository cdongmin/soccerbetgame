package ui;

public class Seasons {
    public static void main(String[] args) {
        makeSeason();
        lineBreaker();
        Team.makeTeamVan();
        Players.makePlayers();
        lineBreaker();
        Team.makeTeamTor();
        Players.makePlayers();
        lineBreaker();
        Team.makeTeamCal();
        Players.makePlayers();
        lineBreaker();
        Team.makeTeamEdm();
        Players.makePlayers();
        lineBreaker();
        Team.makeTeamWin();
        Players.makePlayers();
        lineBreaker();
        Team.makeTeamHal();
        Players.makePlayers();
        lineBreaker();
        Team.makeTeamSas();
        Players.makePlayers();
        lineBreaker();
        Team.makeTeamOtt();
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

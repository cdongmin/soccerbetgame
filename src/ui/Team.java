package ui;

import java.awt.Color;

public class Team {
    private String teamName;
    private String color;

    public Team(String teamName){
        this.teamName = teamName;
    }

    public static void makeTeamVan(){
        //setColor(green);
        System.out.println("Vancouver Greens");
    }
    public static void makeTeamTor(){
        System.out.println("Toronto Blues");
    }
    public static void makeTeamCal(){
        System.out.println("Calgary Reds");
    }
    public static void makeTeamEdm(){
        System.out.println("Edmonton Oranges");
    }
    public static void makeTeamWin(){
        System.out.println("Winnipeg Purples");
    }
    public static void makeTeamHal(){
        System.out.println("Halifax Browns");
    }
    public static void makeTeamSas(){
        System.out.println("Saskatoon Yellows");
    }
    public static void makeTeamOtt(){
        System.out.println("Ottawa Greys");
    }

}

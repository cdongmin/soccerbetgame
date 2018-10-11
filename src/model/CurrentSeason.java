package model;

import model.Season;

public class CurrentSeason implements Season {
    public void makeSeason(int year){
        System.out.println("Season: "+year);
    }
}

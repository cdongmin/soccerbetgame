package model;

public class CurrentSeason {
    private int year;

    public CurrentSeason(int year) {
        this.year = year;
    }

    public void makeSeason() {
        System.out.println("Season: " + year);
    }
}

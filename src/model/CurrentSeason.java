package model;

public class CurrentSeason {
    private int year;

    public CurrentSeason(int year) {
        this.year = year;
    }

    public String makeSeason() {
        return ("Season: " + year);
    }
}

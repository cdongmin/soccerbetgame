package ui;

public class Players {
    private String playerName;
    private int age;
    private int backNumber;
    private String position;
    private int numApperances;
    private int numGoals;
    private int numAssists;

    public static void makePlayers() {
        for(int i=1;i<=20;i++){
            System.out.print("Player"+i+" ");
            if (i<10)
                System.out.print(" ");
            if (i % 5 == 0)
                System.out.println("");
        }
    }
}

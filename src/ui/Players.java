package ui;

public class Players {
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

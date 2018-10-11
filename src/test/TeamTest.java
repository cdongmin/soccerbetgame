package test;

import org.junit.jupiter.api.BeforeEach;
import model.Player;
import model.Team;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TeamTest {
    private String aTeamName = "aTeam";
    private Color color = Color.blue;
    private Team t;
    private String aPlayerName = "aPlayer";
    private int anAge = 19;
    private int aNumber = 5;
    private String aPosition = "Attack";
    private Player p;

    @BeforeEach
    public void setup() {
        t = new Team(aTeamName, color);
    }

    @Test
    public void testConstructor() {
        assertEquals(aTeamName, t.getTeamName());
        assertEquals(color, t.getColor());
    }

    @Test
    public void testAssignTeam() {
        p = new Player(aPlayerName, anAge, aNumber, aPosition);
        t.assignTeam(p);
        assertEquals(p, t.returnOneTeamPlayer(1));
    }

}

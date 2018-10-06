package test;

import org.junit.jupiter.api.BeforeEach;
import ui.Player;
import ui.Team;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static ui.Main.load;
import static ui.Main.save;

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

    @Test
    public void testSave() throws IOException {
        ArrayList<Team> teams = new ArrayList<>();
        teams.add(t);
        save(teams);
        List<String> lines = Files.readAllLines(Paths.get("outputfile.txt"));
        assertEquals("aTeam", lines.get(0));
    }

    @Test
    public void testLoad() throws IOException{
        ArrayList<Team> teams = new ArrayList<>();
        teams.add(t);
        save(teams);
        load();
        List<String> lines = Files.readAllLines(Paths.get("outputfile.txt"));
        assertEquals("aTeam", lines.get(0));
    }
}

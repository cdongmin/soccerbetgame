package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import model.Bet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ui.Main.load;
import static ui.Main.save;

public class TestBet {
    Bet bet;
    @BeforeEach
    public void setup(){
        bet = new Bet();
    }
    @Test
    public void testSave() throws IOException {
        bet.betting(2000);
        save(bet);
        List<String> lines = Files.readAllLines(Paths.get("outputfile.txt"));
        assertEquals("8000", lines.get(0));
    }

    @Test
    public void testLoad() throws IOException{
        bet.betting(5000);
        save(bet);
        load();
        List<String> lines = Files.readAllLines(Paths.get("outputfile.txt"));
        assertEquals("5000", lines.get(0));
    }
}

/*
package test;

import Exceptions.InvalidInputException;
import Exceptions.OutOfMoneyException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import model.Bet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static ui.Main.load;
import static ui.Main.saveBet;

public class TestBet {
    Bet bet;

    @BeforeEach
    public void setup() {
        bet = new Bet();
    }

    @Test
    public void testSave() throws IOException {
        try {
            bet.betting(2000);
        } catch (Exception e) {
            fail("no");
        }
        saveBet(bet);
        List<String> lines = Files.readAllLines(Paths.get("betstats.txt"));
        assertEquals("Your current number of coins: 8000", lines.get(0));
    }

    @Test
    public void testLoad() throws IOException {
        try {
            bet.betting(5000);
        } catch (Exception e) {
            fail("no");

        }
        saveBet(bet);
        load();
        List<String> lines = Files.readAllLines(Paths.get("betstats.txt"));
        assertEquals("Your current number of coins: 5000", lines.get(0));
    }

    @Test
    public void testLoadInsufficientFunds() throws IOException {
        try {
            bet.betting(11000);
            fail("no");
        } catch (OutOfMoneyException e) {
            System.out.println("No money");
        } catch (InvalidInputException e) {
            fail("no");
        }
    }
}
*/
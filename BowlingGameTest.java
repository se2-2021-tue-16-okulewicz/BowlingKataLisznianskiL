import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BowlingGameTest {


    @Test
    public void GutterGameTest()
    {
        // 10 frames of zeros.
        final char[] scoreInput = {'0','0', '0','0', '0','0', '0','0', '0','0',
                                  '0','0', '0','0', '0','0', '0','0', '0','0'};

        final int expectedOutput = 0;

        BowlingGame bg = new BowlingGame();
        bg.enterThrows(scoreInput);

        int score = bg.calculateScore();

        Assertions.assertEquals(expectedOutput, score);
    }

    @Test
    public void AllOnesGameTest()
    {
        // 10 frames of 1s.
        final char[] scoreInput = {'1','1', '1','1', '1','1', '1','1', '1','1',
                                  '1','1', '1','1', '1','1', '1','1', '1','1'};

        final int expectedOutput = 20;

        BowlingGame bg = new BowlingGame();
        bg.enterThrows(scoreInput);

        int score = bg.calculateScore();

        Assertions.assertEquals(expectedOutput, score);
    }

    @Test
    public void SpareInFirstThen3GameTest()
    {
        final char[] scoreInput = {'0','/', '3','0', '0','0', '0','0', '0','0',
                                  '0','0', '0','0', '0','0', '0','0', '0','0'};

        final int expectedOutput = 16;

        BowlingGame bg = new BowlingGame();
        bg.enterThrows(scoreInput);

        int score = bg.calculateScore();

        Assertions.assertEquals(expectedOutput, score);
    }

    @Test
    public void StrikeInFirstThen3Then4GameTest()
    {
        final char[] scoreInput = {'X', '3','4', '0','0', '0','0', '0','0',
                '0','0', '0','0', '0','0', '0','0', '0','0'};

        final int expectedOutput = 24;

        BowlingGame bg = new BowlingGame();
        bg.enterThrows(scoreInput);

        int score = bg.calculateScore();

        Assertions.assertEquals(expectedOutput, score);
    }

    @Test
    public void PerfectGameTest()
    {
        final char[] scoreInput = { 'X','X','X','X','X','X',
                                    'X','X','X','X','X','X'};

        final int expectedOutput = 300;

        BowlingGame bg = new BowlingGame();
        bg.enterThrows(scoreInput);

        int score = bg.calculateScore();

        Assertions.assertEquals(expectedOutput, score);
    }
}
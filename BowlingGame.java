
public class BowlingGame {

    private final int maxPins = 10;
    private final int maxFrames = 10;

    private final char strike = 'X';
    private final char spare = '/';

    private final int maxFrameThrows = 2;
    //private final int maxLastFrameThrows = 3;

    public Frame[] game = new Frame[maxFrames];


    public BowlingGame()
    {
        int i=0;
        for(; i<maxFrames-1;++i)
        {
            game[i] = new Frame(maxFrameThrows);
        }
        game[i] = new Frame(maxFrameThrows+1);
    }

    // The size of gameThrows ranges from 12 - 21
    // where 12 is the best game (12 strikes) and 21 is the maximum number of "throws"
    //
    // This function converts and integer array into the objectified format.
    public void enterThrows(char[] gameThrows)
    {
        int j=0;
        int i=0;
        for(; j<maxFrames-1; ++j)
        {
            if (gameThrows[i] == strike) {
                game[j].Throws[0].setPins(maxPins);
                ++i;
            } else {
                if (gameThrows[i + 1] != spare) {
                    game[j].Throws[0].setPins(Character.getNumericValue(gameThrows[i]));
                    game[j].Throws[1].setPins(Character.getNumericValue(gameThrows[i + 1]));
                } else {
                    int prev = Character.getNumericValue(gameThrows[i]);
                    game[j].Throws[0].setPins(Character.getNumericValue(gameThrows[i]));
                    game[j].Throws[1].setPins(maxPins - prev);
                }
                i+=2;
            }
        }
        // LastFrame Assignment

        if (gameThrows[i] == strike) {

            game[j].Throws[0].setPins(maxPins);

            if(gameThrows[i+1] == strike)
            {
                game[j].Throws[1].setPins(maxPins);
                if(gameThrows[i+2] == strike)
                {
                    game[j].Throws[2].setPins(maxPins);
                }
            }
            else
            {
                //Character.getNumericValue(gameThrows[i])
                game[j].Throws[1].setPins(Character.getNumericValue(gameThrows[i+1]));

                if(gameThrows[i+2] == spare)
                {
                    int prev = Character.getNumericValue(gameThrows[i+1]);

                    game[j].Throws[2].setPins(maxPins - prev);
                }
                else
                {
                    game[j].Throws[2].setPins(Character.getNumericValue(gameThrows[i+2]));
                }
            }
        }
        else {
            game[j].Throws[0].setPins(Character.getNumericValue(gameThrows[i]));

            if(gameThrows[i+1] == spare)
            {
                int prev = Character.getNumericValue(gameThrows[i]);

                game[j].Throws[2].setPins(maxPins - prev);

                if(gameThrows[i+1] == strike)
                {
                    game[j].Throws[2].setPins(maxPins);
                }
                else
                {
                    game[j].Throws[2].setPins(Character.getNumericValue(gameThrows[i+2]));
                }

            }
            else
            {
                game[j].Throws[1].setPins(Character.getNumericValue(gameThrows[i+1]));
            }
        }

    }


    public int calculateScore()
    {
        int score = 0;

        // last frame score
        score += game[maxFrames-1].calculateFrameScore();

        for(int i=maxFrames-2; i>=0; --i)
        {
            // Strike situation
            if(game[i].Throws[0].getPins() == 10)
            {
                score += 10;

                // Again strike
                if(game[i+1].Throws[0].getPins() == 10)
                {
                    score += 10;

                    // SPECIAL - This situation arises in the 9th frame when two strikes are scored.
                    if(i<8)
                    {
                        score += game[i+2].Throws[0].getPins();
                    }
                    else
                    {
                        score += game[i+1].Throws[1].getPins();
                    }

                }
                // Again spare
                else if (game[i+1].Throws[0].getPins() + game[i+1].Throws[1].getPins() == 10)
                {
                    score += 10;
                }
                // Normal rolls
                else
                {
                    score += game[i+1].calculateFrameScore();
                }
            }
            // Spare situation
            else if(game[i].Throws[0].getPins() + game[i].Throws[1].getPins() == 10)
            {
                score += 10;

                // Again strike
                if(game[i+1].Throws[0].getPins() == 10)
                {
                    score += 10;
                }
                // Normal rolls
                else
                {
                    score += game[i+1].Throws[0].getPins();
                }
            }
            // Normal roll
            else
            {
                score += game[i].calculateFrameScore();
            }
        }


        return score;
    }


}

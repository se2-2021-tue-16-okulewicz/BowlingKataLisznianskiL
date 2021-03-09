

public class Frame {

    public Throw[] Throws;
    private int numOfThrows;

    public Frame(int not)
    {
        numOfThrows = not;
        Throws = new Throw[numOfThrows];

        for(int i=0;i<numOfThrows;++i)
        {
            Throws[i] = new Throw();
        }
    }

    public int getNumOfThrows()
    {
        return numOfThrows;
    }

    public int calculateFrameScore()
    {
        int score = 0;
        for(int i=0; i<numOfThrows; ++i)
        {
            score+=Throws[i].getPins();
        }
        return score;
    }


}


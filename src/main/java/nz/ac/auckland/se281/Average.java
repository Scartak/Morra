package nz.ac.auckland.se281;

public class Average implements Stratergy {
    
    public int fingers;
    public  int sum;

    @Override
    public void execute() {
        int tempFinger = Utils.getRandomNumber(1, 5);
    }

    @Override
    public int getFinger() {
        return fingers;
    }

    @Override
    public  int getSum() {
        return sum;
    }
    
}

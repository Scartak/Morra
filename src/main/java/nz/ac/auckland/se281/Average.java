package nz.ac.auckland.se281;

public class Average implements Stratergy {
    
    public int fingers;
    public  int sum;

    @Override
    public void execute() {
        // generate random number of fingers and sum
        fingers = 2;

        sum = 3;
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

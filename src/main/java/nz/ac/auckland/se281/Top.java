package nz.ac.auckland.se281;

public class Top implements Stratergy {
    public int fingers;
    public  int sum;

    @Override
    public void execute() {
        // generate random number of fingers and sum
        fingers = Utils.getRandomNumber(1, 5);

        sum = Utils.getRandomNumber(fingers+1, fingers+5);
    }

    @Override
    public int getFinger() {
        return fingers;
    }

    @Override
    public int getSum() {
        return sum;
    }
    
}

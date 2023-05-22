package nz.ac.auckland.se281;

public class Random implements Stratergy{

    public int fingers;
    public  int sum;

    @Override
    public void execute() {
        // generate random number of fingers and sum and set the sum = fingers + random number
        int tempFinger = Utils.getRandomNumber(1, 5);
        int tempSum = Utils.getRandomNumber(tempFinger+1, tempFinger+5);

        this.fingers = tempFinger;
        this.sum = tempSum;
        
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

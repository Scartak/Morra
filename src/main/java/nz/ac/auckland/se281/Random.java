package nz.ac.auckland.se281;

public class Random implements Stratergy{

    public int fingers;
    public  int sum;

    @Override
    public void execute() {
        // generate random number of fingers and sum
        int rand1 = Utils.getRandomNumber(1, 5);
        int rand2 = Utils.getRandomNumber(rand1+1, rand1+5);

        this.fingers = rand1;
        this.sum = rand2;
        
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

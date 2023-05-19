package nz.ac.auckland.se281;

public class Random implements Stratergy{
    
    public int fingers = Utils.getRandomNumber(1, 5);
    public  int sum = Utils.getRandomNumber(fingers+1, fingers+5);

    @Override
    public void execute() {
        // int rand1 = Utils.getRandomNumber(1, 5);
        // this.fingers = rand1;
        // int rand2 = Utils.getRandomNumber(1, 5);
        // this.sum = rand2;
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

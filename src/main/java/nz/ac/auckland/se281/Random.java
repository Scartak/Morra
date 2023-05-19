package nz.ac.auckland.se281;

public class Random implements Stratergy{
    @Override
    public void execute() {
        int rand1 = Utils.getRandomNumber(1, 5);
        int rand2 = Utils.getRandomNumber(1, 5);
    }

    @Override
    public int getFinger() {
        int fingers = Utils.getRandomNumber(1, 5);
        return fingers;
    }

    @Override
    public int getSum() {
       int fingers = getFinger();
      int sum = Utils.getRandomNumber(fingers+1, fingers+5);
        return sum;
    }
    
}

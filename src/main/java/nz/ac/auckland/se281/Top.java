package nz.ac.auckland.se281;

public class Top implements Stratergy {
    public int fingers;
    public  int sum;
    int top;    

    public Top(int mostCommonFing){
        this.top = mostCommonFing;
    }

    @Override
    public void execute() {
        // generate random number of fingers 
        int tempFingers = Utils.getRandomNumber(1, 5);
        int tempSum = tempFingers + top;

        this.fingers = tempFingers;
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

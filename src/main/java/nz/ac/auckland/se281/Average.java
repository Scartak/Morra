package nz.ac.auckland.se281;

import java.lang.reflect.Array;

public class Average implements Stratergy {

    Morra game;
    

    public int fingers;
    public  int sum;
    public int avg;

    public Average(int avg){
        this.avg = avg;

    }
    //create a morra object
    


    
    @Override
    public void execute() {
        int tempFinger = Utils.getRandomNumber(1, 5);
        int tempSum = avg + tempFinger;
        this.fingers = tempFinger;
        this.sum = tempSum;
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

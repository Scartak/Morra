package nz.ac.auckland.se281;

import java.lang.reflect.Array;

public class Average implements Stratergy {
    
    public int fingers;
    public  int sum;
    //create a morra object
    
    
    @Override
    public void execute() {
        int tempFinger = Utils.getRandomNumber(1, 5);
        //get the method getSumAverage from morra class
        int tempSum = morra.getSum();
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

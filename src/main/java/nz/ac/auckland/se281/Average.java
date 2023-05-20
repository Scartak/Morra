package nz.ac.auckland.se281;

import java.lang.reflect.Array;

public class Average implements Stratergy {

    Morra game;
    

    public int fingers;
    public  int sum;
    //create a morra object
    


    
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

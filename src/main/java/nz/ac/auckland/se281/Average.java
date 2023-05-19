package nz.ac.auckland.se281;

import java.lang.reflect.Array;

public class Average implements Stratergy {

    Morra game;
    

    public int fingers;
    public  int sum;
    //create a morra object
    

    public Average(Morra game){
        this.game = game;
    }
    
    @Override
    public void execute() {
        int tempFinger = Utils.getRandomNumber(1, 5);
        double tempSum = game.getAverageSum();
        this.sum = (int) Math.round(tempSum);
        this.fingers = tempFinger;


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

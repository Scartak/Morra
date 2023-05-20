package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Player {
    public ArrayList <Integer> fingersList = new ArrayList<Integer>();
    int fingers;

    public Player(int fingers) {
        this.fingers = fingers;
        //add the fingers to the list
        fingersList.add(fingers);
    }

    public double getAvgFingers(){
        double sum = 0;
        for (int i = 0; i < fingersList.size(); i++) {
            sum += fingersList.get(i);
        }
        return sum / fingersList.size();
    }

}

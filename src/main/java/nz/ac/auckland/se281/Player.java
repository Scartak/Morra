package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Player {
    public ArrayList <Integer> fingersList = new ArrayList<Integer>();
    int fingers;

    public void sendToPlayer(int fingers){
        this.fingers = fingers;
        fingersList.add(fingers);
    }
    
    // public Player(int fingers) {
    //     this.fingers = fingers;
    //     //add the fingers to the list
    //     fingersList.add(fingers);
    // }

    public double getAvgFingers(){
        double sum = 0;
        if(fingersList.size() > 1){

        for (int i: fingersList){
            sum += i;
        }
    }
    return sum /(fingersList.size());
    }

}

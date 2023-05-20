package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Player {
    public ArrayList <Integer> fingersList = new ArrayList<Integer>();
    int fingers;

    public void sendToPlayer(int fingers){
        this.fingers = fingers;
        fingersList.add(fingers);
    }
    

    public double getAvgFingers(){
        double sum = 0;
        if(fingersList.size() > 1){

        for (int i: fingersList){
            sum += i;
        }
    }
    return sum /(fingersList.size());
    }

    //Get THE most common number of fingerS
    public int getMostCommonFingers(){
        int maxCount = 0;
        int maxFingers = 0;
        for (int i: fingersList){
            int count = 0;
            for (int j: fingersList){
                if (i == j){
                    count++;
                }
            }
            if (count > maxCount){
                maxCount = count;
                maxFingers = i;
            }
        }
        return maxFingers;
    }


}

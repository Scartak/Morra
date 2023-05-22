package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Player {

    //Create an array list to store the number of fingers the player has chosen
    public ArrayList <Integer> fingersList = new ArrayList<Integer>();
    int fingers;

    // sends the current player finger choice to the array list
    public void sendToPlayer(int fingers){
        this.fingers = fingers;
        fingersList.add(fingers);
    }
    
    //Get the average number of fingers the player has chosen
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

        //Loop through the array list and count the number of times each number appears
        for (int i: fingersList){
            int count = 0;
            for (int j: fingersList){
                if (i == j){
                    count++;
                }
            }
            //If the count is greater than the max count, set the max count to the count and the max fingers to the number
            if (count > maxCount){
                maxCount = count;
                maxFingers = i;
            }
        }
        return maxFingers;
    }
}

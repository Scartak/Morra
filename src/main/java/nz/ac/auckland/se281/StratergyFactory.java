package nz.ac.auckland.se281;

public class StratergyFactory {


    public static Stratergy getStratergy(String stratergy, Player player) {

        double avgFing = player.getAvgFingers();
        int avg = (int)Math.round(avgFing);
        switch(stratergy){
            case "Easy":
                return new Random();
               case "Medium":
                return new Average(avg);
             case "Hard":
                    return new Top();
             }
             return null;
    }
    
}

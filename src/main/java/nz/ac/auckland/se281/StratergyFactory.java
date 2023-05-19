package nz.ac.auckland.se281;

public class StratergyFactory {
    public static Stratergy getStratergy(String stratergy) {
        switch(stratergy){
            case "Easy":
                return new Random();
               case "Medium":
                return new Average();
             case "Hard":
                    return new Top();
             }
             return null;
    }
    
}

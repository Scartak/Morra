package nz.ac.auckland.se281;

public class StratergyFactory {

  public static Stratergy getStratergy(String stratergy, Player player) {

    // Get the average number of fingers
    double avgFing = player.getAvgFingers();
    int avg = (int) Math.round(avgFing);

    // Get the most common number of fingers
    int mostCommonFing = player.getMostCommonFingers();

    // Create a switch statement to get the stratergy
    switch (stratergy) {
      case "Easy":
        return new Random();
      case "Medium":
        return new Average(avg);
      case "Hard":
        return new Top(mostCommonFing);
    }
    return null;
  }
}

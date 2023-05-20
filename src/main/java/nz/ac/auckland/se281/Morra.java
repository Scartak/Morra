package nz.ac.auckland.se281;

import java.util.ArrayList;

import javax.swing.text.html.Option;

import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {
  
  public String [] options;
  public int rounds;
  Stratergy Jarvis;
  Difficulty difficulty;
  int playerFingers;
  Player player;
  //Create a public list of all the sums 
  public  ArrayList <Integer> allSumList = new ArrayList<Integer>();

  public Morra() {

  }

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    MessageCli.WELCOME_PLAYER.printMessage(options);
    this.options = options;
    this.rounds = 1;
    this.difficulty = difficulty;
        //Creates a new player object
        Player player = new Player(getPlayerFingers());

    if(difficulty == Difficulty.EASY) {
      Jarvis = StratergyFactory.getStratergy("Easy", player);
    }
    else if (difficulty == Difficulty.MEDIUM) {
      Jarvis = StratergyFactory.getStratergy("Medium", player);
    }
    else if (difficulty == Difficulty.HARD) {
      Jarvis = StratergyFactory.getStratergy("Hard", player);
    }
      
  }

  public void play() {

    MessageCli.START_ROUND.printMessage(Integer.toString(rounds));

    MessageCli.ASK_INPUT.printMessage();

    String input = Utils.scanner.nextLine();

    // Convert the input string to valid integers and float for fingers and sum

    String fingerString = input.split(" ")[0];
    String sumString = input.split(" ")[1];

    //check if fingerString is an integer
    if(Utils.isInteger(fingerString) == false) {
      MessageCli.INVALID_INPUT.printMessage();
      play();
      return;
    }

    if(Utils.isInteger(sumString) == false) {
      MessageCli.INVALID_INPUT.printMessage();
      play();
      return;
    }

    // Sets the input to integers
    int humanFingers = Integer.parseInt(input.split(" ")[0]);
    int humanSum = Integer.parseInt(input.split(" ")[1]);


    this.playerFingers = humanFingers;
    // Check if the input is valid
    if(humanFingers < 1 || humanFingers > 5 || humanSum < 1 || humanSum > 10 ) {
      MessageCli.INVALID_INPUT.printMessage();
      play();
      return;
    }

    //Bring the name variable in play()
    String name = options[0];
    
    if(difficulty == Difficulty.EASY) {
   

    Jarvis.execute();
    int jarvisFinger = Jarvis.getFinger();
    int jarvisSum = Jarvis.getSum();


    //Print the info of the hand
    MessageCli.PRINT_INFO_HAND.printMessage(name, fingerString, sumString);

    MessageCli.PRINT_INFO_HAND.printMessage("Jarvis", String.valueOf(jarvisFinger), String.valueOf(jarvisSum));

    int winSum = humanFingers + jarvisFinger;

    if(humanSum == winSum){
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("HUMAN_WINS");
    }
    else if( jarvisSum == winSum){
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("AI_WINS");
    }
    else{
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
    }
  }

  else if(difficulty == Difficulty.MEDIUM) {
    //if rounds is less than 3, jarvis would be easy
    if(rounds < 3){
      Jarvis = new Random();
    }
    Jarvis.execute();
    int jarvisFinger = Jarvis.getFinger();
    int jarvisSum = Jarvis.getSum();

    MessageCli.PRINT_INFO_HAND.printMessage(name, fingerString, sumString);

    MessageCli.PRINT_INFO_HAND.printMessage("Jarvis", String.valueOf(jarvisFinger), String.valueOf(jarvisSum));

    int winSum = humanFingers + jarvisFinger;

    if(humanSum == winSum){
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("HUMAN_WINS");
    }
    else if( jarvisSum == winSum){
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("AI_WINS");
    }
    else{
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
    }
    
    allSumList.add(humanFingers);
  }
  rounds++;
  }

  public int getPlayerFingers() {
    return playerFingers;
}
  

  public void showStats() {}



}

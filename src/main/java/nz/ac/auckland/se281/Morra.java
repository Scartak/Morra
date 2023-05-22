package nz.ac.auckland.se281;

import java.util.ArrayList;

import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {
  
  //initialising variables

  private String [] options;
  private int rounds;
  private Stratergy strategy;
  private Difficulty difficulty;
  private int playerFingers;
  private int playerPoints;
  private int jarvisPoints;
  private Player player;
  private int pointsToWin;
  private String name;
  private int askAgain ;

  //Create a public list of all the sums 
  public  ArrayList <Integer> allSumList = new ArrayList<Integer>();

  public Morra() {
    askAgain = 0;

  }

  //Create a new game
  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    // the player is welcomed
    MessageCli.WELCOME_PLAYER.printMessage(options);

    // the new game is initialised
    this.options = options;
    this.rounds = 1;
    this.playerPoints = 0;
    this.jarvisPoints = 0;
    this.difficulty = difficulty;
    this.name = options[0];

    //Creates a new player object and initialises properties of player
    Player player = new Player();
    this.player = player;
    this.pointsToWin = pointsToWin;

    // Creates a new Stratergy for the AI Jarvis based on the difficulty the player chose
    if(difficulty == Difficulty.EASY) {
      strategy = StratergyFactory.getStratergy("Easy", player);
    }
    else if (difficulty == Difficulty.MEDIUM) {
      strategy = StratergyFactory.getStratergy("Medium", player);
    }
    else if (difficulty == Difficulty.HARD) {
      strategy = StratergyFactory.getStratergy("Hard", player);
    }
      
  }

  public void play() {
    
    //check if the game is started or not
    if(rounds == 0){
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }
    
    //Get the input from the player depending on the conditions
    if(askAgain == 0){
    MessageCli.START_ROUND.printMessage(Integer.toString(rounds));
    }

    MessageCli.ASK_INPUT.printMessage();

    String input = Utils.scanner.nextLine();

    //check how many words the input has
    if(input.split(" ").length != 2) {
      MessageCli.INVALID_INPUT.printMessage();
      askAgain++;
      play();
      return;
    }

    // Convert the input string to valid integers and float for fingers and sum
    String fingerString = input.split(" ")[0];
    String sumString = input.split(" ")[1];

    //check if fingerString is an integer
    if(Utils.isInteger(fingerString) == false) {
      MessageCli.INVALID_INPUT.printMessage();
      askAgain++;
      play();
      return;
    }

    //check if sumString is an integer
    if(Utils.isInteger(sumString) == false) {
      MessageCli.INVALID_INPUT.printMessage();
      askAgain++;
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
      askAgain++;
      play();
      return;
    }
    
    askAgain = 0;

    //Bring the name variable in play()
    String name = options[0];
    

    //Implements the easy difficulty
    if(difficulty == Difficulty.EASY) {
    strategy.execute();
    int jarvisFinger = strategy.getFinger();
    int jarvisSum = strategy.getSum();

    //Print the info of the hand
    MessageCli.PRINT_INFO_HAND.printMessage(name, fingerString, sumString);

    MessageCli.PRINT_INFO_HAND.printMessage("Jarvis", String.valueOf(jarvisFinger), String.valueOf(jarvisSum));

    //Get the winning number
    int winSum = humanFingers + jarvisFinger;

    //Implements the logic for winning the round
    if(humanSum == jarvisSum){
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
    }
    else if(humanSum == winSum){
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("HUMAN_WINS");
      playerPoints++;
    }
    else if( jarvisSum == winSum){
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("AI_WINS");
      jarvisPoints++;
    }
    else{
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
    }
  }

  // Implements the medium difficulty 

  else if(difficulty == Difficulty.MEDIUM) {

    //if rounds is less than 3, jarvis would be set to easy
    if(rounds <= 3){
      strategy = new Random();
    }
    else{
      strategy = StratergyFactory.getStratergy("Medium", player);
    }

    //Get the numbers for jarvis
    strategy.execute();
    int jarvisFinger = strategy.getFinger();
    int jarvisSum = strategy.getSum();

    //Print the info of the hand
    MessageCli.PRINT_INFO_HAND.printMessage(name, fingerString, sumString);

    MessageCli.PRINT_INFO_HAND.printMessage("Jarvis", String.valueOf(jarvisFinger), String.valueOf(jarvisSum));

    //Get the winning number
    int winSum = humanFingers + jarvisFinger;

    //Implements the logic for winning the round
    if(humanSum == jarvisSum){
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
    }
    else if(humanSum == winSum){
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("HUMAN_WINS");
      playerPoints++;
    }
    else if( jarvisSum == winSum){
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("AI_WINS");
      jarvisPoints++;
    }
    else{
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
    } 
    
    //send the fingers human chose into the arraylist and send it to the player class
    allSumList.add(humanFingers);
    player.sendToPlayer(humanFingers);;

  }

  else if(difficulty == Difficulty.HARD){

    //if rounds is less than 3, jarvis would be easy
    if(rounds <= 3){
      strategy = new Random();
    }
    else{
      strategy = StratergyFactory.getStratergy("Hard", player);
    }
    
    //Get the numbers for jarvis
    strategy.execute();
    int jarvisFinger = strategy.getFinger();
    int jarvisSum = strategy.getSum();

    //Print the info of the hand
    MessageCli.PRINT_INFO_HAND.printMessage(name, fingerString, sumString);

    MessageCli.PRINT_INFO_HAND.printMessage("Jarvis", String.valueOf(jarvisFinger), String.valueOf(jarvisSum));

    //Get the winning number
    int winSum = humanFingers + jarvisFinger;

    //Implements the logic for winning the round
    if(humanSum == jarvisSum){
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
    }
    else if(humanSum == winSum){
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("HUMAN_WINS");
      playerPoints++;
    }
    else if( jarvisSum == winSum){
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("AI_WINS");
      jarvisPoints++;
    }
    else{
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
    }
    
      //send the fingers human chose into the arraylist and send it to the player class
    allSumList.add(humanFingers);
    player.sendToPlayer(humanFingers);;
  }

  // Implements the master difficulty for top stratergy
  else if(difficulty == Difficulty.MASTER){

    //if rounds is less than 3, jarvis would be easy otherwise the stratergy would alternateberween medium and hard
    if(rounds <= 3){
      strategy = new Random();
    }
    else if(rounds % 2 == 0){
      strategy = StratergyFactory.getStratergy("Medium", player);
    }
    else if(rounds % 2 != 0){
      strategy = StratergyFactory.getStratergy("Hard", player);
    }

    //Get the numbers for jarvis     
    strategy.execute();
    int jarvisFinger = strategy.getFinger();
    int jarvisSum = strategy.getSum();

    //Print the info of the hand
    MessageCli.PRINT_INFO_HAND.printMessage(name, fingerString, sumString);

    MessageCli.PRINT_INFO_HAND.printMessage("Jarvis", String.valueOf(jarvisFinger), String.valueOf(jarvisSum));

    //Get the winning number
    int winSum = humanFingers + jarvisFinger;

    //Implements the logic for winning the round
    if(humanSum == jarvisSum){
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
    }
    else if(humanSum == winSum){
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("HUMAN_WINS");
      playerPoints++;
    }
    else if( jarvisSum == winSum){
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("AI_WINS");
      jarvisPoints++;
    }
    else{
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
    }
    
    //send the fingers human chose into the arraylist and send it to the player class
    allSumList.add(humanFingers);
    player.sendToPlayer(humanFingers);
  }

  rounds++;

  //implements the logic to win the game
  if(jarvisPoints == pointsToWin){
   MessageCli.END_GAME.printMessage("Jarvis", Integer.toString(rounds-1));
   rounds = 0;
  }
  else if(playerPoints == pointsToWin){
    MessageCli.END_GAME.printMessage(name, Integer.toString(rounds-1));
    rounds = 0;
  } 
  }

  //gets the number of fingers the player chose
  public int getPlayerFingers() {
    return playerFingers;
}
  
  //displays the amount of rounds needed to win the game
  public void showStats() {
    if(rounds == 0){
      MessageCli.GAME_NOT_STARTED.printMessage();
    }
      else{
      MessageCli.PRINT_PLAYER_WINS.printMessage(name, Integer.toString(playerPoints), Integer.toString(pointsToWin-playerPoints));
      MessageCli.PRINT_PLAYER_WINS.printMessage("Jarvis",Integer.toString(jarvisPoints), Integer.toString(pointsToWin-jarvisPoints));
    }
  }



}

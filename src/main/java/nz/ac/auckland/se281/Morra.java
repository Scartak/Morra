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
  int playerPoints;
  int jarvisPoints;
  Player player;
  int pointsToWin;
  String name;
  int askAgain = 0;
  //Create a public list of all the sums 
  public  ArrayList <Integer> allSumList = new ArrayList<Integer>();

  public Morra() {

  }

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    MessageCli.WELCOME_PLAYER.printMessage(options);
    this.options = options;
    this.rounds = 1;
    this.playerPoints = 0;
    this.jarvisPoints = 0;
    this.difficulty = difficulty;
    this.name = options[0];
    //Creates a new player object
    Player player = new Player();
    this.player = player;
    this.pointsToWin = pointsToWin;


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

    if(rounds == 0){
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

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
    
    if(difficulty == Difficulty.EASY) {
   

    Jarvis.execute();
    int jarvisFinger = Jarvis.getFinger();
    int jarvisSum = Jarvis.getSum();


    //Print the info of the hand
    MessageCli.PRINT_INFO_HAND.printMessage(name, fingerString, sumString);

    MessageCli.PRINT_INFO_HAND.printMessage("Jarvis", String.valueOf(jarvisFinger), String.valueOf(jarvisSum));

    int winSum = humanFingers + jarvisFinger;

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

  else if(difficulty == Difficulty.MEDIUM) {
    //if rounds is less than 3, jarvis would be easy
    if(rounds <= 3){
      Jarvis = new Random();
    }
    else{
      Jarvis = StratergyFactory.getStratergy("Medium", player);
    }

    Jarvis.execute();
    int jarvisFinger = Jarvis.getFinger();
    int jarvisSum = Jarvis.getSum();

    MessageCli.PRINT_INFO_HAND.printMessage(name, fingerString, sumString);

    MessageCli.PRINT_INFO_HAND.printMessage("Jarvis", String.valueOf(jarvisFinger), String.valueOf(jarvisSum));

    int winSum = humanFingers + jarvisFinger;

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
    
    allSumList.add(humanFingers);
    player.sendToPlayer(humanFingers);;

  }

  else if(difficulty == Difficulty.HARD){
    //if rounds is less than 3, jarvis would be easy
    if(rounds <= 3){
      Jarvis = new Random();
    }
    else{
      Jarvis = StratergyFactory.getStratergy("Hard", player);
    }
    
    Jarvis.execute();
    int jarvisFinger = Jarvis.getFinger();
    int jarvisSum = Jarvis.getSum();

    MessageCli.PRINT_INFO_HAND.printMessage(name, fingerString, sumString);

    MessageCli.PRINT_INFO_HAND.printMessage("Jarvis", String.valueOf(jarvisFinger), String.valueOf(jarvisSum));

    int winSum = humanFingers + jarvisFinger;

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
    
    allSumList.add(humanFingers);
    player.sendToPlayer(humanFingers);;
  }

  else if(difficulty == Difficulty.MASTER){
    if(rounds <= 3){
      Jarvis = new Random();
    }
    else if(rounds % 2 == 0){
      Jarvis = StratergyFactory.getStratergy("Medium", player);
    }
    else if(rounds % 2 != 0){
      Jarvis = StratergyFactory.getStratergy("Hard", player);
    }
     
    Jarvis.execute();
    int jarvisFinger = Jarvis.getFinger();
    int jarvisSum = Jarvis.getSum();

    MessageCli.PRINT_INFO_HAND.printMessage(name, fingerString, sumString);

    MessageCli.PRINT_INFO_HAND.printMessage("Jarvis", String.valueOf(jarvisFinger), String.valueOf(jarvisSum));

    int winSum = humanFingers + jarvisFinger;

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
  
    
    allSumList.add(humanFingers);
    player.sendToPlayer(humanFingers);
  }

  rounds++;
  if(jarvisPoints == pointsToWin){
   MessageCli.END_GAME.printMessage("Jarvis", Integer.toString(rounds-1));
   rounds = 0;
  }
  else if(playerPoints == pointsToWin){
    MessageCli.END_GAME.printMessage(name, Integer.toString(rounds-1));
    rounds = 0;
  }

  
  }

  public int getPlayerFingers() {
    return playerFingers;
}
  

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

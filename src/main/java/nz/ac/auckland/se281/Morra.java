package nz.ac.auckland.se281;

import javax.swing.text.html.Option;

import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {
  
  public String [] options;
  public int rounds;
  Stratergy Jarvis;

  public Morra() {}

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    MessageCli.WELCOME_PLAYER.printMessage(options);
    this.options = options;
    this.rounds = 0;
    if(difficulty == Difficulty.EASY) {
      Jarvis = StratergyFactory.getStratergy("Easy");
    }
      
  }

  public void play() {
    rounds++;

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
    int fingers = Integer.parseInt(input.split(" ")[0]);
    int sum = Integer.parseInt(input.split(" ")[1]);

    // Check if the input is valid
    if(fingers < 1 || fingers > 5 || sum < 1 || sum > 10 ) {
      MessageCli.INVALID_INPUT.printMessage();
      play();
      return;
    }

    //Bring the name variable in play()
    String name = options[0];

    //Print the info of the hand
    MessageCli.PRINT_INFO_HAND.printMessage(name, fingerString, sumString);

    MessageCli.PRINT_INFO_HAND.printMessage("Jarvis", String.valueOf(Jarvis.getFinger()), String.valueOf(Jarvis.getSum()));
  }

  public void showStats() {}
}

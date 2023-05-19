package nz.ac.auckland.se281;

import javax.swing.text.html.Option;

import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {
  
  public String [] options;
  public int rounds;


  public Morra() {}

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    MessageCli.WELCOME_PLAYER.printMessage(options);
    this.options = options;
    this.rounds = 0;
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
    try {
      int fingers = Integer.parseInt(fingerString);
    } catch (NumberFormatException e) {
      MessageCli.INVALID_INPUT.printMessage();
      play();
      return;
    }

    //check if sumString is an integer
    try {
      int sum = Integer.parseInt(sumString);
    } catch (NumberFormatException e) {
      MessageCli.INVALID_INPUT.printMessage();
      play();
      return;
    }
    int fingers = Integer.parseInt(input.split(" ")[0]);
    int sum = Integer.parseInt(input.split(" ")[1]);

    if(fingers < 1 || fingers > 5 || sum < 1 || sum > 10 ) {
      MessageCli.INVALID_INPUT.printMessage();
      play();
      return;
    }

    String name = options[0];

    MessageCli.PRINT_INFO_HAND.printMessage(name, fingerString, sumString);
    

  }

  public void showStats() {}
}

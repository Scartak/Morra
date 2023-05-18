package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {

  public Morra() {}

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    MessageCli.WELCOME_PLAYER.printMessage(options);
  }

  public void play() {
    MessageCli.START_ROUND.printMessage("1");
    MessageCli.ASK_INPUT.printMessage();
    String input = Utils.scanner.nextLine();
    

  }

  public void showStats() {}
}

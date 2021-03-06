package com.thoughtworks;

import java.util.Scanner;

public class App {
  /**
   * GuessTarget provides the answer;
   * PlayerGuess provides methods to get input, compareInputWithTarget;
   */

  private static final int GUESS_TIME = 6;
  private static final String DIVIDER = "=============================";
  private static boolean hitTarget = false;

  public static void main(String[] args) {
    GuessGame game1 = new GuessGame("src/main/resources/answer.txt");
    Player player = new Player();
    //Do not close Scanner with System.in, otherwise the System.in stream will be closed; leave it to JVM.
    Scanner scan = new Scanner(System.in);
    int times = GUESS_TIME;
    for (int i = 0; i < GUESS_TIME; i++) {
      System.out.println("Please enter your guess(4 digits int)");
      String num = scan.next();
      System.out.println("Your guess is " + num);
      player.setGuessInput(num);
      System.out.println(DIVIDER);
      try {
        GameResult result = new GameResult(game1, player);
        result.output();
        result.instruct();
      } catch (WrongInputException e) {
        System.out.println(e.getMessage());
        i--;
        continue;
      }
      if (player.isWinner()) {
        hitTarget = true;
        break;
      } else {
        times--;
        System.out.printf("You have %d times left. ", times);
      }
    }
    endGameReport(game1);
  }

  private static void endGameReport(GuessGame game) {
    System.out.println(DIVIDER);
    if (hitTarget) {
      System.out.println("Congratulations, you win!");
    } else {
      System.out.printf("Unfortunately, you have no chance, the answer is %s!", game.toString());
    }
  }
}

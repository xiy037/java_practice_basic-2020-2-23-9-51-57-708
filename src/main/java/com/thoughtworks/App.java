package com.thoughtworks;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
  /**
   *   GuessTarget provides the answer;
   *   PlayerGuess provides methods to get input, compareInputWithTarget;
   */

  private static final int GUESS_TIME = 6;
  private static final String DIVIDER = "=============================";
  private static String target;
  private static boolean hitTarget = false;

  public static void main(String[] args) {
    GuessTarget game1 = new GuessTarget("src/main/resources/answer.txt");
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
      GameResult result = new GameResult(game1, player);
      result.output();
      result.instruct();
      if (player.isWinner()) {
        hitTarget = true;
        break;
      } else {
        times--;
        System.out.printf("You have %d times left. ", times);
      }
    }

    if (hitTarget) {
      System.out.println("Congratulations, you win!");
    } else {
      System.out.printf("Unfortunately, you have no chance, the answer is %s!", game1.toString());
    }

  }
}

package com.thoughtworks;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
  /**
   *   GuessTarget provides the answer;
   *   PlayerGuess provides methods to get input, compareInputWithTarget;
   */


  public static void main(String[] args) {
    GuessTarget game1 = new GuessTarget("src/main/resources/answer.txt");
    Player player = new Player();
    //Do not close Scanner with System.in, otherwise the System.in stream will be closed; leave it to JVM.
    Scanner scan = new Scanner(System.in);
    System.out.println("Please enter your guess(4 digits int)");
    String num = scan.next();
    System.out.println("Your guess is " + num);
    player.setGuessInput(num);

    System.out.println("=========================");
    for (Integer integer : player.getAllRight()) {
      System.out.println(integer);
    }
    GameResult result = new GameResult(game1, player);
    result.output();
    result.instruct();

  }
}

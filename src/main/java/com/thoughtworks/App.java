package com.thoughtworks;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
  /**
   *   GuessTarget provides the answer;
   *   PlayerGuess provides method to get input, compareInputWithTarget;
   */


  public static void main(String[] args) {
    GuessTarget game1 = new GuessTarget("src/main/resources/answer.txt");
    ArrayList<Integer> answer = game1.getAnswer();
    for (Integer x : answer) {
      System.out.println(x);
    }
    System.out.println("=========================");
    PlayerGuess player = new PlayerGuess();
    //Do not close Scanner with System.in, otherwise the System.in stream will be closed; leave it to JVM.
    Scanner scan = new Scanner(System.in);
    System.out.println("Please enter your guess(4 digits int)");
    Integer num = scan.nextInt();
    System.out.println("Your guess is " + num);
    player.setInput(num);

    System.out.println("=========================");
    System.out.println(player.winGame(game1));

  }
}

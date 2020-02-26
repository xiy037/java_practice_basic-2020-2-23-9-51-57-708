package com.thoughtworks;

import java.util.ArrayList;

public class GameResult implements printResult {
  private Player player;
  private GuessGame target;
  public ArrayList<Integer> countA;
  public ArrayList<Integer> countB;

  public GameResult(GuessGame t, Player p) throws WrongInputException {
    target = t;
    player = p;
    player.checkGuessAgainstAnswer(target);
    countA = player.getAllRight();
    countB = player.getOnlyNumRight();
  }

  @Override
  public void output() {
    String output = countA.size() + "A" +countB.size() + "B";
    System.out.println(output);
  }

  @Override
  public void instruct() {
    String result = "";
    int sizeB = countB.size();
    if (player.isWinner()) {
      result = allCorrect();
    } else if (countA.size() == 0 && sizeB == 0) {
      result = allWrong();
    } else {
      result = partiallyCorrect();
    }
    System.out.println(result);
  }

  private String allCorrect() {
    return "Win, all correct!";
  }

  private String allWrong() {
    return "all wrong";
  }

  private String partiallyCorrect() {
    String str = "";
    int sizeA = countA.size();
    int sizeB = countB.size();
    if (sizeA == 0 && sizeB == target.getAnswer().size()) {
      str = sizeB + " numbers position wrong";
    } else {
      if (sizeA >= 2) {
        for (int i = 0; i < (sizeA - 2); i++) {
          str = str + countA.get(i) + ", ";
        }
        str += String.format("%d and %d correct", countA.get(sizeA - 2), countA.get(sizeA - 1));
      } else if (sizeA == 1) {
        str += countA.get(0) + " correct";
      }

      if (sizeB >= 2) {
        if (sizeA > 0) {
          str += ", ";
        }
        for (int i = 0; i < (sizeB - 2); i++) {
          str = str + countB.get(i) + ", ";
        }
        str += String.format("%d and %d wrong position", countB.get(sizeB - 2), countB.get(sizeB - 1));
      } else if (sizeB == 1) {
        if (sizeA > 0) {
          str += ", ";
        }
        str += countB.get(0) + " wrong position";
      }
    }
    return str;
  }
}

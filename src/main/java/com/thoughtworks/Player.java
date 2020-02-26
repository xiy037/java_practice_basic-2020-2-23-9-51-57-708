package com.thoughtworks;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Player {
  private ArrayList<Integer> guessInput = new ArrayList<>();
  private int answerLength;
  private ArrayList<Integer> allRight = new ArrayList<>();
  private boolean win;
  private int modCount;

  public ArrayList<Integer> getAllRight() {
    return allRight;
  }

  public ArrayList<Integer> getOnlyNumRight() {
    return onlyNumRight;
  }

  private ArrayList<Integer> onlyNumRight = new ArrayList<>();

  public ArrayList<Integer> getGuessInput() {
    return guessInput;
  }

  public void setGuessInput(String numStr) {
    String[] numArr = numStr.split("");
    for (String s : numArr) {
      guessInput.add(Integer.parseInt(s));
    }
  }

  //只有全对的时候返回true，其它时候都是false；
  public boolean winGame(GuessTarget game) {
    if (modCount == 0) {
      win = true;
      ArrayList<Integer> target = game.getAnswer();
      answerLength = target.size();
      if (isRightFormat()) {
        for (int i = 0; i < answerLength; i++) {
          boolean completeEqual = guessInput.get(i).equals(target.get(i));
          if (target.contains(guessInput.get(i)) && !completeEqual) {
            onlyNumRight.add(guessInput.get(i));
          }
          if (completeEqual) {
            allRight.add(guessInput.get(i));
          } else {
            win = false;
          }
        }
      } else {
        win = false;
        System.out.println("wrong input format");
      }
      modCount++;
    }
    return win;
  }

  private boolean isRightFormat() {
    Set<Integer> checkSet = new HashSet<>(guessInput);
    return checkSet.size() == answerLength;
  }
}

package com.thoughtworks;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PlayerGuess {
  private ArrayList<Integer> input = new ArrayList<>();
  private int answerLength;
  public ArrayList<Integer> allRight = new ArrayList<>();
  public ArrayList<Integer> onlyNumRight = new ArrayList<>();

  public ArrayList<Integer> getInput() {
    return input;
  }

  public void setInput(Integer number) {
    String numStr = Integer.toString(number);
    String[] numArr = numStr.split("");
    for (String s : numArr) {
      input.add(Integer.parseInt(s));
    }
  }

  //只有全对的时候返回true，其它时候都是false；
  public boolean winGame(GuessTarget game) {
    boolean win = true;
    ArrayList<Integer> target = game.getAnswer();
    answerLength = target.size();
    if (isRightFormat()) {
      for (int i = 0; i < answerLength; i++) {
        boolean completeEqual = input.get(i).equals(target.get(i));
        if (target.contains(input.get(i)) && !completeEqual) {
          onlyNumRight.add(input.get(i));
        }
        if (completeEqual) {
          allRight.add(input.get(i));
        } else {
          win = false;
        }
      }
    } else {
      win = false;
    }
    return win;
  }

  private boolean isRightFormat() {
    Set<Integer> checkSet = new HashSet<>(input);
    return checkSet.size() == answerLength;
  }
}

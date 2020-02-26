package com.thoughtworks;

import java.util.ArrayList;

public class App {

  public static void main(String[] args) {
    Guess game1 = new Guess("src/main/resources/answer.txt");
    ArrayList<Integer> answer = game1.answer;
    for (Integer x : answer) {
      System.out.println(x);
    }
  }
}

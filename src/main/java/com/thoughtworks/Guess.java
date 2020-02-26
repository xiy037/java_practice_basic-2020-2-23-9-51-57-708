package com.thoughtworks;

import java.io.File;
import java.util.*;

/**
 * Guess will get or produce 4
 */
public class Guess {
  public ArrayList<Integer> answer = new ArrayList<>();
  private boolean isTarget = false;
  private final int ANSWER_LENGTH = 4;

  public Guess(String path) {
    try (Scanner scanner = new Scanner(new File(path))) {
      while(scanner.hasNextInt()) {
        answer.add(scanner.nextInt());
      }
      if(!isCorrectFormat()) {
        getRandomAnswer();
      }
      //txt里面如果有重复数字，也要重新生成
    } catch (Exception e) {
      System.out.println("Exception: " + e.getMessage());
      getRandomAnswer();
    }
  }

  private boolean isCorrectFormat() {
    Set<Integer> checkSet = new HashSet<>(answer);
    return checkSet.size() == 4;
  }


  private void getRandomAnswer() {
    System.out.println("Will produce Random answer by system");
    Set<Integer> randomSet = new HashSet<>();
    for (int i = 0; i < ANSWER_LENGTH; i++) {
      Random producer = new Random();
      Integer num = producer.nextInt(10);
      if (!randomSet.add(num)) {
        i--;
      }
    }
    answer = new ArrayList<Integer>(randomSet);
  }


}

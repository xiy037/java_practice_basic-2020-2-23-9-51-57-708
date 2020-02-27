package com.thoughtworks;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Guess will get or produce 4
 */
public class GuessGame {
  private ArrayList<Integer> answer = new ArrayList<>();
  private final int ANSWER_LENGTH = 4;

  public GuessGame(String path) {
    try (Scanner scanner = new Scanner(new File(path)).useDelimiter("")) {
      while(scanner.hasNext()) {
        //只读int，其它不读跳过；
        try {
          int num = scanner.nextInt();
//          System.out.println(num);
          answer.add(num);
        } catch (Exception e) {
//          System.out.println("Not int, skip!");
          scanner.skip("\\D");
        }
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
    return checkSet.size() == ANSWER_LENGTH;
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
    answer = new ArrayList<>(randomSet);
  }

  public ArrayList<Integer> getAnswer() {
    return answer;
  }

  @Override
  public String toString() {
    String listString = answer.stream().map(Object::toString)
            .collect(Collectors.joining(""));
    return listString;
  }
}

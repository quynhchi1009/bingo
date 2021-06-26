package edu.hm.cs.bka.dev2.bingo;

import com.google.common.collect.Sets;
import java.util.Set;

/**
 * Demo.
 */
public class BingoDemo {

  private static final Set<Integer> NUMBERS =
      Sets.newHashSet(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22,
          23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41);

  /**
   * Beispielprogramm.
   *
   * @param args nicht genutzt
   */
  public static void main(String[] args) {
    Bingo bingo = new Bingo(NUMBERS, 5);

    try {
      while (true) {
        System.out.println(bingo);
        int drawn = InputHelper.askForInteger("Nächste Zahl");
        bingo.add(drawn);
      }
    } catch (BingoException e) {
      System.out.println("BINGO!"); // Spiel ist vorbei!
    }
  }

}

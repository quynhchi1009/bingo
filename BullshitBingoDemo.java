package edu.hm.cs.bka.dev2.bingo;

import com.google.common.collect.Sets;
import java.util.Set;

/**
 * Demo.
 */
public class BullshitBingoDemo {

  // Erzeugt ein Array mit den Zahlen 1..40.
  private static final Set<String> WORDS = Sets.newHashSet("abstract", "compare", "final",
      "class", "get", "extends", "previous", "next", "set", "List", "Set",
      "Queue", "Deque", "Iterable", "Iterator", "konkret", "foreach", "remove", "HashSet",
      "Map", "HashMap", "throw", "catch", "finally", "Raw Type", "Erasure");

  /**
   * Beispielprogramm.
   *
   * @param args nicht genutzt.
   */
  public static void main(String[] args) {
  //    Bingo bingo = new Bingo(WORDS, 5);
  //
  //    try {
  //      while (true) {
  //        System.out.println(bingo);
  //        String drawn = InputHelper.askForString("Nächstes Wort");
  //        bingo.add(drawn);
  //      }
  //    } catch (BingoException e) {
  //      System.out.println("BINGO!"); // Spiel ist vorbei!
  //    }
  }
}

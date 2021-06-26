package edu.hm.cs.bka.dev2.bingo;

import java.util.Scanner;

/**
 * Hilfklasse zum Abfragen von Zahlen von der Kommandozeile.
 */
public class InputHelper {

  private static final Scanner in = new Scanner(System.in);

  /**
   * Fragt eine Ganzzahl ab.
   *
   * @param prompt Prompt vor Eingabe
   * @return Ganzzahl, Eingabe von der Kommandozeile.
   */
  public static int askForInteger(String prompt) {
    Integer result = null;
    do {
      System.out.print(prompt + " > ");
      String input = in.nextLine();
      try {
        result = Integer.parseInt(input);
      } catch (NumberFormatException e) {
        System.out.println("Ungueltige Eingabe!");
      }
    } while (result == null);
    return result;
  }

 
  /**
   * Fragt einen String ab.
   *
   * @param prompt Prompt vor Eingabe
   * @return String, Eingabe von der Kommandozeile.
   */

  public static String askForString(String prompt) {
    String result = null;
    do {
      System.out.print(prompt + " > ");
      String input = in.nextLine().trim();
      result = input.trim();
      if (result.length() == 0) {
        System.out.println("Ungueltige Eingabe!");
      }
    } while (result == null || result.length() == 0);
    return result;
  }

}

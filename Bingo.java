package edu.hm.cs.bka.dev2.bingo;

import java.util.*;
import org.apache.commons.lang3.StringUtils;

/**
 * Bingo-Feld.
 */
public class Bingo {

  private final List<List<Integer>> card = new ArrayList<>();

  private final boolean[][] crossed;

  /**
   * Konstruktor. Erzeugt eine zufällige Bingo-Karte
   *
   * @param values   Menge möglicher Werte
   * @param cardSize Feldgröße (Kantenlänge)
   */
  public Bingo(Set<Integer> values, int cardSize) {
    if (values.size() < cardSize * cardSize) {
      throw new RuntimeException("Nicht genügend Werte");
    }

    crossed = new boolean[cardSize][cardSize];
    List<Integer> copy = new ArrayList<>(values);
    Collections.shuffle(copy);

    // TODO: Hier sollten zufällig Werte aus dem übergebenen Set eingesetzt werden!
    for (int i = 0; i < cardSize; i++) {
      List<Integer> row = new ArrayList<>();
      for (int j = 0; j < cardSize; j++) {
        row.add(copy.get(j + cardSize * i));
      }
      card.add(row);
    }
  }

  /**
   * Überprüft, wenn ein Wert ausgerufen wird, ob er ausgekreuzt werden kann.
   *
   * @param i Wert
   * @throws BingoException Wenn eine Reihe ausgekreuzt ist.
   */
  public void add(Integer i) throws BingoException {
    cross(i);
    if (checkForBingo()) {
      throw new BingoException("Bingo!");
    }
  }

  /**
   * Sucht das übergebene Element in auf der Karte und setzt den entsprechenden Eintrag im Array
   * <code>crossed</code> auf true.
   *
   * @param drawn gezogenes Element
   */
  private void cross(Integer drawn) {
    // TODO: Hier fehlt die Implementierung!
    for (int i = 0; i < crossed.length; i++) {
      for (int j = 0; j < crossed.length; j++) {
        if (card.get(i).get(j).equals(drawn)) {
          crossed[i][j] = true;
        }
      }
    }

  }

  /* Ab hier muss nichts geändert werden! */

  /**
   * Überrpüft, ob eine Zeile, Spalte oder Diagonale ausgestrichen ist.
   *
   * @return true, wenn das Spiel beendet ist.
   */
  private boolean checkForBingo() {
    boolean isRowCrossed = false;
    boolean isColumnCrossed = false;
    boolean isFirstDiagonalCrossed = true;
    boolean isSecondDiagonalCrossed = true;
    for (int i = 0; i < crossed.length; i++) {
      isRowCrossed = isRowCrossed || checkRow(i);
      isColumnCrossed = isColumnCrossed || checkColumn(i);
      isFirstDiagonalCrossed &= crossed[i][i];
      isSecondDiagonalCrossed &= crossed[i][crossed.length - i - 1];
    }
    return isRowCrossed || isColumnCrossed || isFirstDiagonalCrossed || isSecondDiagonalCrossed;
  }

  /**
   * Überprüft, ob eine Spalte komplett ausgestrichen ist.
   *
   * @param column Spaltennummer
   * @return true, wenn die Spalte ausgestrichen ist
   */
  private boolean checkColumn(int column) {
    boolean result = true;
    for (boolean[] booleans : crossed) {
      result = result && booleans[column];
    }
    return result;
  }

  /** Überrpüft, ob eine Zeile komplett ausgestrichen ist.
   *
   * @param row Zeile
   * @return true, wenn die Zeile ausgestrichen ist
   */
  private boolean checkRow(int row) {
    boolean result = true;
    for (int i = 0; i < crossed.length; i++) {
      result = result && crossed[row][i];
    }
    return result;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(StringUtils.repeat('-', 12 * card.size()));
    for (int row = 0; row < card.size(); row++) {
      sb.append("\n");
      for (int column = 0; column < card.size(); column++) {
        sb.append(format(card.get(row).get(column), crossed[row][column]));
      }
    }
    sb.append("\n");
    sb.append(StringUtils.repeat('-', 12 * card.size()));
    return sb.toString();
  }

  /**
   * Gibt Element aus, optional ausgestrichen.
   *
   * @param element Element
   * @param crossed Flag für gekreuzte Elemente
   *
   * @return Formatierte Ausgabe
   */
  private String format(Object element, boolean crossed) {
    String result = element.toString();
    result = StringUtils.abbreviateMiddle(result, "..", 8);
    char pad = crossed ? 'X' : ' ';
    result = StringUtils.center(result, 10, pad);
    return " " + result + " ";
  }
}

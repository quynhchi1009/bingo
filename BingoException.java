package edu.hm.cs.bka.dev2.bingo;

/**
 * Signalisiert einen Gewinn.
 */
public class BingoException extends Exception {
  public BingoException(String msg) {
    super(msg);
  }
}

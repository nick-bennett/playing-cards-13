package edu.cnm.deepdive.playingcards.model;

public enum Suit {

  CLUBS("\u2663", Color.BLACK),
  DIAMONDS("\u2662", Color.RED),
  HEARTS("\u2661", Color.RED),
  SPADES("\u2660", Color.BLACK);

  private final String symbol;
  private final Color color;

  Suit(String symbol, Color color) {
    this.symbol = symbol;
    this.color = color;
  }

  public String getSymbol() {
    return symbol;
  }

  public Color getColor() {
    return color;
  }

  public enum Color {
    BLACK, RED
  }

}

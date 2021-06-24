package edu.cnm.deepdive;

public class Card {

  private final Rank rank;
  private final Suit suit;

  public Card(Rank rank, Suit suit) {
    this.rank = rank;
    this.suit = suit;
  }

  public Rank getRank() {
    return rank;
  }

  public Suit getSuit() {
    return suit;
  }

  @Override
  public String toString() {
    return rank.getSymbol() + suit.getSymbol();
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    boolean eq = false;
    if (obj == this) {
      eq = true;
    } else if (obj instanceof Card) {
      Card other = (Card) obj;
      eq = ((rank == other.rank) && (suit == other.suit));
    }
    return eq;
  }

}

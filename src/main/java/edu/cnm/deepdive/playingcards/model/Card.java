package edu.cnm.deepdive.playingcards.model;

import java.util.Objects;

public class Card implements Comparable<Card> {

  private final Rank rank;
  private final Suit suit;
  private final int hash;
  private final String representation;

  public Card(Rank rank, Suit suit) {
    this.rank = rank;
    this.suit = suit;
    hash = Objects.hash(rank, suit);
    representation = rank.getSymbol() + suit.getSymbol();
  }

  public Rank getRank() {
    return rank;
  }

  public Suit getSuit() {
    return suit;
  }

  @Override
  public String toString() {
    return representation;
  }

  @Override
  public int hashCode() {
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    boolean eq = false;
    if (obj == this) {
      eq = true;
    } else if (obj instanceof Card) {
      Card other = (Card) obj;
      eq = ((hash == other.hash)
          && (rank == other.rank)
          && (suit == other.suit));
    }
    return eq;
  }

  @Override
  public int compareTo(Card other) {
    int comparison = suit.compareTo(other.suit);
    if (comparison == 0) {
      comparison = rank.compareTo(other.rank);
    }
    return comparison;
  }

}

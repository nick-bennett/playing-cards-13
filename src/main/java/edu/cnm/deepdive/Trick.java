package edu.cnm.deepdive;

import edu.cnm.deepdive.playingcards.model.Card;
import edu.cnm.deepdive.playingcards.model.Rank;
import edu.cnm.deepdive.playingcards.model.Suit;
import edu.cnm.deepdive.playingcards.model.Suit.Color;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Trick {

  public static void main(String[] args) {
    Random rng = new SecureRandom();
    List<Card> deck = getDeck(rng);
    List<Card> redPile = new ArrayList<>();
    List<Card> blackPile = new ArrayList<>();
    sortCards(deck, redPile, blackPile);
    swapCards(redPile, blackPile, rng);
    Collections.sort(redPile);
    Collections.sort(blackPile);
    printContents(redPile, Color.RED);
    printContents(blackPile, Color.BLACK);
  }

  private static List<Card> getDeck(Random rng) {
    List<Card> deck = new ArrayList<>();
    for (Suit suit : Suit.values()) {
      for (Rank rank : Rank.values()) {
        deck.add(new Card(rank, suit));
      }
    }
    Collections.shuffle(deck, rng);
    return deck;
  }

  private static void sortCards(List<Card> deck, List<Card> redPile, List<Card> blackPile) {
    for (Iterator<Card> iter = deck.iterator(); iter.hasNext(); ) {
      Card selector = iter.next();
      Card card = iter.next();
      if (selector.getSuit().getColor() == Color.RED) {
        redPile.add(card);
      } else {
        blackPile.add(card);
      }
    }
  }

  private static void swapCards(List<Card> redPile, List<Card> blackPile, Random rng) {
    int numToSwap = rng.nextInt(Math.min(redPile.size(), blackPile.size()) + 1);
    // Could use Collections.shuffle(redPile, rng) and Collection.shuffle(blackPile, rng).
    for (int i = 0; i < numToSwap; i++) {
      blackPile.add(redPile.remove(0));
      redPile.add(blackPile.remove(0));
    }
  }

  private static void printContents(List<Card> pile, Color color) {
    int colorCount = 0;
    for (Card card : pile) {
      if (card.getSuit().getColor() == color) {
        colorCount++;
      }
    }
    System.out.printf("%1$s pile contains %2$d %1$s cards: %3$s%n", color, colorCount, pile);
  }

}

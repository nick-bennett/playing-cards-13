package edu.cnm.deepdive;

import edu.cnm.deepdive.general.util.MergeSorter;
import edu.cnm.deepdive.general.util.QuickSorter;
import edu.cnm.deepdive.playingcards.model.Card;
import edu.cnm.deepdive.playingcards.model.Rank;
import edu.cnm.deepdive.playingcards.model.Suit;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

public class SortTest {

  public static void main(String[] args) {
    Card[] cards = generate(4_000_000);
    Card[] cards2 = Arrays.copyOf(cards, cards.length);
    Card[] cards3 = Arrays.copyOf(cards, cards.length);

    long startTime = System.currentTimeMillis();
    new MergeSorter().sort(cards);
    long elapsed = System.currentTimeMillis() - startTime;
    System.out.println(elapsed);

    startTime = System.currentTimeMillis();
    new QuickSorter().sort(cards2);
    elapsed = System.currentTimeMillis() - startTime;
    System.out.println(elapsed);

    startTime = System.currentTimeMillis();
    Arrays.sort(cards3);
    elapsed = System.currentTimeMillis() - startTime;
    System.out.println(elapsed);

    assert Arrays.equals(cards, cards2);
    assert Arrays.equals(cards, cards3);
  }

  private static Card[] generate(int size) {
    Random rng = new Random();
    Rank[] ranks = Rank.values();
    Suit[] suits = Suit.values();
    return Stream
        .generate(() -> new Card(ranks[rng.nextInt(ranks.length)],
            suits[rng.nextInt(suits.length)]))
        .limit(size)
        .toArray(Card[]::new);
  }

}

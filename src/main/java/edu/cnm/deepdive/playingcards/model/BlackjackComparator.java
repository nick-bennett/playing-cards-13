package edu.cnm.deepdive.playingcards.model;

import edu.cnm.deepdive.general.model.Hand;
import java.util.Comparator;
import java.util.Map;

public class BlackjackComparator implements Comparator<BlackjackHand> {

  private static final int HARD_SOFT_INCREMENT = 10;
  private static final int BLACKJACK_HAND_SIZE = 2;
  private static final int HAND_VALUE_LIMIT = 21;
  private static final Map<Rank, Integer> RANK_VALUES = Map.ofEntries(
      Map.entry(Rank.ACE, 1),
      Map.entry(Rank.TWO, 2),
      Map.entry(Rank.THREE, 3),
      Map.entry(Rank.FOUR, 4),
      Map.entry(Rank.FIVE, 5),
      Map.entry(Rank.SIX, 6),
      Map.entry(Rank.SEVEN, 7),
      Map.entry(Rank.EIGHT, 8),
      Map.entry(Rank.NINE, 9),
      Map.entry(Rank.TEN, 10),
      Map.entry(Rank.JACK, 10),
      Map.entry(Rank.QUEEN, 10),
      Map.entry(Rank.KING, 10)
  );

  @Override
  public int compare(BlackjackHand hand1, BlackjackHand hand2) {
    return value(hand1) - value(hand2);
  }

  protected int value(Hand<Card> hand) {
    int total = 0;
    boolean soft = false;
    for (Card card : hand) {
      total += RANK_VALUES.get(card.getRank());
      if (card.getRank() == Rank.ACE && total <= HAND_VALUE_LIMIT - HARD_SOFT_INCREMENT) {
        soft = true;
        total += HARD_SOFT_INCREMENT;
      } else if (total > HAND_VALUE_LIMIT && soft) {
        soft = false;
        total -= HARD_SOFT_INCREMENT;
      }
    }
    if (total > HAND_VALUE_LIMIT) {
      // TODO Include logic for dealer bust vs. player bust (dealer wins)
      // e.g if (hand.isDealer()) {...}
      total = -1;
    } else if (total == HAND_VALUE_LIMIT && hand.size() == BLACKJACK_HAND_SIZE) {
      // TODO Include logic for dealer Blackjack vs. player Blackjack (dealer wins)
      total++;
    }
    return total;
  }

}

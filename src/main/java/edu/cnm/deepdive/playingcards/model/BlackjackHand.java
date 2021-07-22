package edu.cnm.deepdive.playingcards.model;

import edu.cnm.deepdive.general.model.Hand;
import java.util.Collection;

public class BlackjackHand extends Hand<Card> {

  private final boolean dealer;

  public BlackjackHand(boolean dealer) {
    super();
    this.dealer = dealer;
  }

  public BlackjackHand(boolean dealer, Collection<Card> source) {
    super(source);
    this.dealer = dealer;
  }

  public boolean isDealer() {
    return dealer;
  }

}

package LLD._1_Cards.model;

import java.util.Map;
import LLD._1_Cards.model.CardType;
import LLD._1_Cards.model.CardColor;

public class Deck {
    private Map<CardType, CardGroup> cards;

    public Deck(){
        cards.put(CardType.Diamond, new CardGroup(CardColor.Red, "Diamond"));
        cards.put(CardType.Spade, new CardGroup(CardColor.Black, "Spade"));
        cards.put(CardType.Heart, new CardGroup(CardColor.Red, "Heart"));
        cards.put(CardType.Club, new CardGroup(CardColor.Black, "Club"));
    }
}

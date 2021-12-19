package cardgames;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class CardDeck {

    private ArrayList<Card> deck = new ArrayList<Card>();

    public CardDeck(int n) {
        if (n <= 1 || n > 13) {
            throw new IllegalArgumentException("Input argument has to be between 1 and 13");
        }
        for (int i = 0; i < 4; i++) {
            char suit;
            if (i == 0) {
                suit = 'S';
            } else if (i == 1) {
                suit = 'H';
            } else if (i == 2) {
                suit = 'D';
            } else {
                suit = 'C';
            }
            for (int j = 1; j <= n; j++) {
                deck.add(new Card(suit, j));
            }
        }
    }

    public CardDeck() {
    }

    public ArrayList<Card> getDeck() {
        ArrayList<Card> returnedDeck = new ArrayList<Card>();
        for (Card card : deck) {
            returnedDeck.add(card);
        }
        return returnedDeck;
    }

    public Card getCard(int i) {
        if (i < 0 || i > deck.size() - 1) {
            throw new IllegalArgumentException(
                    "Cannot get a card with an index lower than 0 or higher than the size of the deck.");
        }
        return deck.get(i);
    }

    public void addCard(Card card) {
        if (!deck.contains(card)) {
            deck.add(card);
        }
    }

    public Card handCard() {
        if (deck.isEmpty()) {
            throw new IllegalArgumentException("There are no cards to hand out");
        }
        Card card = deck.get(deck.size() - 1);
        deck.remove(deck.size() - 1);
        return card;
    }

    public void shuffle() {
        Collections.shuffle(deck, new Random());
    }

    public void shuffle(int seed) {
        Collections.shuffle(deck, new Random(seed));
    }
}

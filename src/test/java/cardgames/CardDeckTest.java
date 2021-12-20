package cardgames;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CardDeckTest {

    private CardDeck deck;

    @BeforeEach
    public void setup() {
        deck = null;
    }

    @Test
    public void testConstructor() {
        deck = new CardDeck(4);
        assertEquals(16, deck.getDeck().size());

        assertThrows(IllegalArgumentException.class, () -> {
            CardDeck deck2 = new CardDeck(14);
            System.out.println(deck2);
        });
    }

    @Test
    public void testAddCard() {
        deck = new CardDeck(4);
        deck.addCard(new Card('S', 13));
    }

    @Test
    public void testGetCard() {
        deck = new CardDeck(4);
        Card card = deck.getCard(3);
        assertEquals("S4", card.toString());

        card.turnCard();
        assertEquals("??", card.toString());

        assertThrows(IllegalArgumentException.class, () -> {
            deck.getCard(20);
        });
    }

    @Test
    public void testHandCard() {
        deck = new CardDeck(4);
        Card card = deck.handCard();
        assertEquals("C4", card.toString());

        CardDeck emptyDeck = new CardDeck();
        assertThrows(IllegalArgumentException.class, () -> {
            Card cursedCard = emptyDeck.handCard();
            System.out.println(cursedCard);
        });
    }

    @Test
    public void testShuffle_random() {
        deck = new CardDeck(4);
        testShuffle(false);
        testShuffle(false);
    }

    @Test
    public void testShuffle_seeded() {
        deck = new CardDeck(4);
        testShuffle(true);
        testShuffle(true);
    }

    private void testShuffle(boolean isSeeded) {
        CardDeck shuffledDeck = new CardDeck();
        if (isSeeded) {
            CardDeck shuffledDeck2 = new CardDeck();
            for (int i = 0; i < deck.getDeck().size(); i++) {
                shuffledDeck.addCard(deck.getCard(i));
                shuffledDeck2.addCard(deck.getCard(i));
            }
            int seed = 3;
            shuffledDeck.shuffle(seed);
            shuffledDeck2.shuffle(seed);
            int sameCardCount = 0;
            for (int i = 0; i < deck.getDeck().size(); i++) {
                if (shuffledDeck.getCard(i).toString().equals(shuffledDeck2.getCard(i).toString())) {
                    sameCardCount++;
                }
            }
            if (sameCardCount != deck.getDeck().size()) {
                fail("Shuffled deck does not have the same sequence");
            }
        } else {
            for (int i = 0; i < deck.getDeck().size(); i++) {
                shuffledDeck.addCard(deck.getCard(i));
            }
            shuffledDeck.shuffle();
            int sameCardCount = 0;
            for (int i = 0; i < deck.getDeck().size(); i++) {
                if (deck.getCard(i).toString().equals(shuffledDeck.getCard(i).toString())) {
                    sameCardCount++;
                }
            }
            if (sameCardCount == deck.getDeck().size()) {
                fail("Shuffled deck has the same sequence");
            }
        }
    }
}

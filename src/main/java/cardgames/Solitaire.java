package cardgames;

import java.util.ArrayList;
import java.util.List;

public class Solitaire {

    private CardDeck handPile;
    private CardDeck wastePile = new CardDeck();
    private List<CardDeck> suitPiles = new ArrayList<>();
    private List<CardDeck> tableaus = new ArrayList<>();

    public Solitaire() {
        handPile = new CardDeck(13);
        handPile.shuffle();
        createGame();
    }

    public Solitaire(int seed) {
        handPile = new CardDeck(13);
        handPile.shuffle(seed);
        createGame();
    }

    public void createGame() {
        for (int i = 0; i < 7; i++) {
            tableaus.add(new CardDeck());
        }
        for (int i = 0; i < 4; i++) {
            suitPiles.add(new CardDeck());
        }
        for (int startPointer = 0; startPointer < 7; startPointer++) {
            for (int i = startPointer; i < 7; i++) {
                tableaus.get(i).addCard(handPile.handCard());
                tableaus.get(i).getCard(startPointer).turnCard();
            }
            tableaus.get(startPointer).getCard(startPointer).turnCard();
        }
    }

    // TODO: Fix encapsulation here
    public CardDeck getHandPile() {
        return handPile;
    }

    public CardDeck getWastePile() {
        return wastePile;
    }

    public List<CardDeck> getSuitPiles() {
        return suitPiles;
    }

    public List<CardDeck> getTableaus() {
        return tableaus;
    }

    // TODO: Solitaire logic

    public static void main(String[] args) {
        Solitaire solitaire = new Solitaire();

        // TESTING: prints cards in tableaus
        int i = 0;
        for (CardDeck tableau : solitaire.getTableaus()) {
            System.out.println("\nTableau " + i);
            for (Card card : tableau.getDeck()) {
                System.out.println(card);
            }
            i++;
        }
    }

}

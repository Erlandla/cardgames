package cardgames;

/**
 * Used to keep instances of individual cards.
 * <p>
 * A {@code Card} has three attributes: a suit, a face, and if the card is
 * face-up or face-down. The suit of a card can
 * be the following: Spades, S; Hearts, H; Diamonds, D; and Clubs, C.
 * <p>
 * Unless something else is specified, spades are worth more than hearts, hearts
 * are worth more than diamonds, and diamonds are worth more than clubs.
 * <p>
 * The value of a card can be between 1 and 13, where 1 is ace, and 13 is king
 * <p>
 * For games such as Solitaire, some cards will have to be face-up, while others
 * are face-down. It is therefore necessary to define that.
 */
public class Card {

    private char suit;
    private int face;
    private boolean isFaceUp = true;

    /**
     * Constructor for {@code Card}.
     *
     * @param suit the suit of the card. Has to be 'S', 'H', 'D', or 'C'.
     * @param face the face of the card. Has to be between 1 and 13.
     */
    public Card(char suit, int face) {
        if (suit != 'S' && suit != 'H' && suit != 'D' && suit != 'C') {
            throw new IllegalArgumentException(
                    "Suit argument must either must be one of the following characters: S, H, D, or C");
        }
        if (face < 1 || face > 13) {
            throw new IllegalArgumentException("Face argument has to be between 1 and 13");
        }
        this.suit = suit;
        this.face = face;
    }

    public char getSuit() {
        return suit;
    }

    public int getFace() {
        return face;
    }

    public boolean isFaceUp() {
        return isFaceUp;
    }

    public void turnCard() {
        isFaceUp = !isFaceUp;
    }

    @Override
    public String toString() {
        if (!isFaceUp()) {
            return "??";
        }
        StringBuilder cardString = new StringBuilder();
        cardString.append(suit);
        cardString.append(face);
        return cardString.toString();
    }
}

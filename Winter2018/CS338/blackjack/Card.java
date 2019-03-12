/*
 * A container of suits and values
 */
public class Card {
    private final Suit suit;
    private final Value value;

    /*
     * The Card constructor
     * @param value the card's value
     * @param suit the card's suit
     */
    public Card(Value value, Suit suit) {
        this.suit = suit;
        this.value = value;
    }

    /*
     * Get's a card's suit as a string
     * @return string form of the card's suit
     * @throws UnsupportedOperationException if the card has an invalid suit
     */
    public String suitString() {
        switch(suit) {
            case SPADES: return "Spades";
            case HEARTS: return "Hearts";
            case DIAMONDS: return "Diamonds";
            case CLUBS: return "Clubs";
            default: throw new UnsupportedOperationException("Unexpected card suit");
        }
    }

    /*
     * Get's a card's suit as a short string
     * @return short string form of the card's suit
     * @throws UnsupportedOperationException if the card has an invalid suit
     */
    public String suitShortString() {
        switch(suit) {
            case SPADES: return "S";
            case HEARTS: return "H";
            case DIAMONDS: return "D";
            case CLUBS: return "C";
            default: throw new UnsupportedOperationException("Unexpected card suit");
        }
    }

    /*
     * Get's a card's value as a string
     * @return string form of the card's value
     * @throws UnsupportedOperationException if the card has an invalid value
     */
    public String valueString() {
        switch(value) {
            case TWO: return "2";
            case THREE: return "3";
            case FOUR: return "4";
            case FIVE: return "5";
            case SIX: return "6";
            case SEVEN: return "7";
            case EIGHT: return "8";
            case NINE: return "9";
            case TEN: return "10";
            case JACK: return "Jack";
            case QUEEN: return "Queen";
            case KING: return "King";
            case ACE: return "Ace";
            default: throw new UnsupportedOperationException("Unexpected card value");
        }
    }

    /*
     * Get's a card's value as a short string
     * @return short string form of a card's value
     * @throws UnsupportedOperationException if the card has an invalid value
     */
    public String valueShortString() {
        switch(value) {
            case TWO: return "2";
            case THREE: return "3";
            case FOUR: return "4";
            case FIVE: return "5";
            case SIX: return "6";
            case SEVEN: return "7";
            case EIGHT: return "8";
            case NINE: return "9";
            case TEN: return "T";
            case JACK: return "J";
            case QUEEN: return "Q";
            case KING: return "K";
            case ACE: return "A";
            default: throw new UnsupportedOperationException("Unexpected card value");
        }
    }

    public int numericalValue()
    {
        if (isAce())
        {
            throw new UnsupportedOperationException("Aces cannot be converted to a numerical value easily");
        }
        switch(value)
        {
            case TWO : return 2;
            case THREE : return 3;
            case FOUR : return 4;
            case FIVE: return 5;
            case SIX: return 6;
            case SEVEN: return 7;
            case EIGHT: return 8;
            case NINE: return 9;
            case TEN:
            case JACK:
            case QUEEN:
            case KING: return 10;
            default: throw new UnsupportedOperationException("Unexpected card value");
        }
    }

    public static Value fromNumericalValue(int input)
    {
        switch(input)
        {
            case 1:
            case 11:
                return Value.ACE;
            case 2:
                return Value.TWO;
            case 3:
                return Value.THREE;
            case 4:
                return Value.FOUR;
            case 5:
                return Value.FIVE;
            case 6:
                return Value.SIX;
            case 7:
                return Value.SEVEN;
            case 8:
                return Value.EIGHT;
            case 9:
                return Value.NINE;
            case 10:
                return Value.TEN;
            default:
                throw new UnsupportedOperationException("Cannot convert input to a Value");
        }
    }

    /*
     * Determines if a card is an Ace or not
     * @return a boolean indicating if a card is an Ace or not
     */
    public boolean isAce() {
        return this.value == Value.ACE;
    }

    /*
     * String form of a card
     * @return string form of a card
     */
    @Override
    public String toString() {
        return valueString() + " of " + suitString();
    }

    @Override
    public int hashCode()
    {
        int result = toShortString().hashCode();
        return result;
    }

    /*
     * Short string form of a card
     * @return short string form of a card
     */
    public String toShortString() {
        return valueShortString() + suitShortString();
    }

    /*
     * Normalizes TEN, JACK, QUEEN, and KING to TEN, otherwise the value is left alone
     * @param value the value to normalize
     * @return the normalized value
     */
    public static Value normalizeValue(Value value)
    {
        switch(value)
        {
            case TEN:
            case JACK:
            case QUEEN:
            case KING:
                return Value.TEN;
            default:
                return value;
        }
    }

    /*
     * Determines if an object and this are considered equal
     * @param o an object
     * @return a boolean indicating if the objects are considered equal
     */
    @Override
    public boolean equals(Object o)
    {
        if (o == this)
        {
            return true;
        }
        if (!(o instanceof Card))
        {
            return false;
        }
        Card card = (Card) o;
        Value inValue = normalizeValue(card.value);
        Value thisValue = normalizeValue(this.value);
        return card.suit == this.suit && inValue == thisValue;
    }

    /*
     * Determines if a card and this have the same numerical value
     * @param card the card to check against
     * @return a boolean indicating if card and this have the same numerical value
     */
    public boolean equalsValue(Card card)
    {
        Value inValue = normalizeValue(card.value);
        Value thisValue = normalizeValue(this.value);
        return inValue == thisValue;
    }

    public Value getValue()
    {
        return this.value;
    }
}

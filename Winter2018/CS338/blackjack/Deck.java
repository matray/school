import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * A collection of cards
 */
public class Deck implements Iterable<Card> {
    private ArrayList<Card> deck;

    /*
     * Deck constructor, fills in with all possible Cards
     */
    public Deck()
    {
        deck = new ArrayList<Card>();
        Suit[] suits = {
            Suit.SPADES,
            Suit.HEARTS,
            Suit.DIAMONDS,
            Suit.CLUBS
        };
        Value[] values = {
            Value.TWO,
            Value.THREE,
            Value.FOUR,
            Value.FIVE,
            Value.SIX,
            Value.SEVEN,
            Value.EIGHT,
            Value.NINE,
            Value.TEN,
            Value.JACK,
            Value.QUEEN,
            Value.KING,
            Value.ACE
        };
        for(Value value : values)
        {
            for(Suit suit : suits)
            {
                deck.add(new Card(value, suit));
            }
        }
    }

    /*
     * Shuffles the deck
     */
    public void shuffle()
    {
        Collections.shuffle(deck);
    }

    /*
     * Gets the card at the given index
     * @param index
     * @return the card at the given index
     */
    public Card getCard(int index) {
        return deck.get(index);
    }

    /*
     * Gets the iterator for all cards in a deck
     * @return an iterator for all cards in a deck
     */
    public Iterator<Card> iterator() {
        return new DeckIterator(this);
    }

    /*
     * An iterator for a Deck
     */
    public class DeckIterator implements Iterator<Card> {
        private Deck iterableDeck;
        private int position;

        /*
         * Constructor for the Deck iterator
         */
        public DeckIterator(Deck iterableDeck) {
            this.iterableDeck = iterableDeck;
        }

        /*
         * Determines if a Deck has another Card
         * @return a boolean indicating if a Deck has another Card
         */
        @Override
        public boolean hasNext() {
            return position < iterableDeck.deck.size();
        }

        /*
         * Gets the next Card in the iterator
         * @return the next Cards in the iterator
         * @throws NoSuchElementException if no more cards are left
         */
        @Override
        public Card next() {
            if (position >= iterableDeck.deck.size())
            {
                throw new NoSuchElementException("No more cards left");
            }
            return iterableDeck.getCard(position++);
        }

        /*
         * Removes a card (not implemented)
         * @throws UnsupportedOperationException if called
         */
        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove() not implemented for Deck");
        }
    }
}

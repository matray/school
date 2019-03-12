import java.util.Vector;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * A container of n Cards
 */
public class Hand implements Iterable<Card> {

    private Vector<Card> hand;
    private boolean busted;
    private String name;
    private Logger logger;
    private static int blackjack = 21;
    private static int acesHardValue = 1;
    private static int acesSoftValue = 11;
    private static int outcounter = 0;
    private int counter = 0;
    /*
     * Hand constructor that takes in the hand's name
     * @param the name of the hand
     */
    public Hand(String name)
    {
        outcounter++;
        counter = outcounter;
        hand = new Vector<Card>();
        this.name = name;
        this.logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    }

    public int id()
    {
        return counter;
    }

    /*
     * Adds a card to the hand
     * @param card the card to add
     */
    public void addCard(Card card)
    {
        logger.log(Level.FINE, "Added " + card.toString() + " to the hand");
        hand.add(card);
    }

    /*
     * Computes the value of the hand
     * @param handType specifies what kind of hand to process
     * @return the value of the hand
     * @throws UnsupportedOperationException if the hand value type is unexpected
     */
    private int getValue(HandValueType handType)
    {
        int acesCount = 0;
        int sum = 0;
        for(Card card : hand)
        {
            if (card.isAce())
            {
                acesCount++;
                continue;
            }
            int value = card.numericalValue();
            sum += value;
        }
        // Value is known already if there are no aces
        if (acesCount > 0)
        {

            // Soft values cannot be expanded if there isn't enough room for them
            int difference = blackjack - sum;
            if (difference <= acesCount || difference < acesHardValue)
            {
                sum += acesCount;
            }
            else
            {
                // Handle soft and hard hands because there are now possible permutations
                int acesValue;
                switch(handType)
                {
                    case HARD:
                        acesValue = acesHardValue;
                        break;
                    case SOFT:
                        acesValue = acesSoftValue;
                        break;
                    default:
                        throw new UnsupportedOperationException("Unexpected hand value type");
                }
                acesCount--;
                sum += acesValue;
                sum += acesCount;
            }
        }
        return sum;
    }

    /*
     * Get's the hand's hard value
     * @return the hand's hard value
     */
    public int hardValue()
    {
        return getValue(HandValueType.HARD);
    }

    /*
     * Get's the hand's soft value
     * @return the hand's soft value
     */
    public int softValue()
    {
        return getValue(HandValueType.SOFT);
    }

    public Tuple<HandValueType, Integer> getValue()
    {
        int hardValue = hardValue();
        int softValue = softValue();
        boolean soft = (softValue != hardValue && softValue <= 21);
        if (soft)
            return new Tuple<HandValueType, Integer>(HandValueType.SOFT, softValue);
        return new Tuple<HandValueType, Integer>(HandValueType.HARD, hardValue);
    }

    public boolean isBlackjack()
    {
        if (hand.size() != 2)
        {
            return false;
        }
        int hardValue = hardValue();
        int softValue = softValue();
        if (hardValue == blackjack || softValue == blackjack)
        {
            return true;
        }
        return false;
    }

    /*
     * Determines if the hand is bust
     * @return a boolean indicating if the hand is bust
     */
    public boolean isBust()
    {
        int hardValue = hardValue();
        int softValue = softValue();
        boolean busted = (hardValue > blackjack && softValue > blackjack);
        if (busted)
            logger.log(Level.FINE, "Hand has busted");
        return busted;
    }

    /*
     * Determines if the current hand can be considered a pair
     * @return a boolean indicating if the hand is a pair
     */
    public boolean isPair()
    {
        if (hand.size() != 2)
        {
            return false;
        }
        Card first = hand.get(0);
        Card second = hand.get(1);
        return first.equalsValue(second);
    }

    /*
     * Removes all Cards in the hand
     */
    public void clear()
    {
        hand.removeAllElements();
    }

    /*
     * Removes a specific card in the hand
     * @param card the card to remove
     */
    public void removeCard(Card card)
    {
        hand.removeElement(card);
    }

    /*
     * Get's the number of cards in the hand
     * @return the number of cards in the hand
     */
    public int numberOfCards()
    {
        return hand.size();
    }

    /*
     * Get's the card at the index in the hand
     * @param index the index to use
     * @return the card at the given index
     */
    public Card getCard(int index)
    {
        return hand.get(index);
    }

    /*
     * Get's the hand's card iterator
     * @return the iterator
     */
    public Iterator<Card> iterator()
    {
        return new HandIterator(this);
    }

    @Override
    public String toString()
    {
        String output = "Hand{name=" + name;
        int count = 0;
        for(Card card : hand)
        {
            output += String.format(",card%d=%s", count, card.toShortString());
            count++;
        }
        output += String.format(",hardValue=%d", hardValue());
        output += String.format(",softValue=%d", softValue());
        output += "}";
        return output;
    }

    @Override
    public int hashCode()
    {
        return toString().hashCode();
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Hand hand = (Hand)o;
        if(hand.numberOfCards() != numberOfCards()) return false;
        for(int i = 0; i < hand.numberOfCards(); i++)
        {
            if(hand.getCard(i) != this.getCard(i)) return false;
        }
        return true;
    }

    /*
     * An iterator for looping through the cards in a hand
     */
    public class HandIterator implements Iterator<Card> {
        private Hand iterableHand;
        private int position;

        /*
         * The HandIterator constructor
         * @param iterableHand the hand to iterate over
         */
        public HandIterator(Hand iterableHand)
        {
            this.iterableHand = iterableHand;
        }

        /*
         * Determines if there are more cards to loop through
         * @retun a boolean indicating if there are more cards to loop through
         */
        @Override
        public boolean hasNext()
        {
            return position < iterableHand.hand.size();
        }

        /*
         * Get's the next card in the iterator
         * @return the next card in the iterator
         * @throws NoSuchElementException if there are no cards left
         */
        @Override
        public Card next()
        {
            if (position >= iterableHand.hand.size())
            {
                throw new NoSuchElementException("No more cards left");
            }
            return iterableHand.getCard(position++);
        }

        /*
         * Removes a card, not implemented
         * @throws UnsupportedOperationException if called
         */
        @Override
        public void remove()
        {
            throw new UnsupportedOperationException("remove() not implemented for Hand");
        }
    }
}

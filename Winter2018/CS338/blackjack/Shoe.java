import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.ArrayList;
import java.util.Collections;

public class Shoe {

    private Queue<Card> cards;
    private int numberOfDecks;
    private int penetration;
    private int deltCount;
    private Logger logger;
    private ArrayList<ShoeObserver> observers;

    public Shoe(int penetration, int numberOfDecks)
    {
        observers = new ArrayList<ShoeObserver>();
        this.numberOfDecks = numberOfDecks;
        this.penetration = penetration;
        deltCount = 0;
        logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        reset();
        String message = String.format("Shoe initialized with %d decks", numberOfDecks);
        logger.log(Level.FINE, message);
        message = String.format("Shoe penetration: %d", penetration);
        logger.log(Level.FINE, message);
    }

    public void reset()
    {
        for(ShoeObserver observer : observers)
        {
            observer.clear();
        }
        ArrayList<Card> tempCards = new ArrayList<Card>();
        for(int i = 0; i < numberOfDecks; i++)
        {
            Deck deck = new Deck();
            for(Card card: deck)
            {
                tempCards.add(card);
            }
        }
        Collections.shuffle(tempCards);
        cards = new LinkedList<>();
        for(Card card : tempCards)
        {
            cards.add(card);
        }
    }

    public void addObserver(ShoeObserver observer)
    {
        logger.log(Level.FINE, "Adding observer: " + observer.toString());
        observers.add(observer);
    }

    public void removeObserver(ShoeObserver observer)
    {
        logger.log(Level.FINE, "Removing observer: " + observer.toString());
        observers.remove(observer);
    }

    public Card deal()
    {
        Card card = cards.remove();
        logger.log(Level.FINE, "Dealing " + card.toShortString());
        deltCount++;
        for(ShoeObserver observer : observers)
        {
            observer.update(card);
        }
        return card;
    }

    public boolean isPenetrated()
    {
        return deltCount >= penetration;
    }
}

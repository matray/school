import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.ArrayList;

public class Dealer extends Actor
{
    private ArrayList<DealerObserver> observers;
    public Dealer(String name, Rules rules)
    {
        super(name, rules);
        observers = new ArrayList<DealerObserver>();
        logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    }

    public boolean isPlaying()
    {
        return true;
    }

    public Value getShowingCardValue()
    {
        if (hands.size() != 1)
        {
            throw new UnsupportedOperationException("Dealer seen with 0 or more than one hand");
        }
        return Card.normalizeValue(hands.get(0).getCard(0).getValue());
    }

    @Override
    public boolean hasBank()
    {
        return false;
    }

    @Override
    public int bankroll()
    {
        return 0;
    }

    public void addDealerObserver(DealerObserver observer)
    {
        observers.add(observer);
    }

    public void addHand(Hand hand)
    {
        hands.add(hand);
        Value showing = getShowingCardValue();
        for(DealerObserver observer : observers)
        {
            logger.log(Level.FINE, String.format("Updating that dealer has: %s", showing));
            observer.update(showing);
        }
    }

    public PlayerAction desiredAction(Hand dealerHand)
    {
        int softValue = dealerHand.softValue();
        int hardValue = dealerHand.hardValue();
        boolean soft = (softValue != hardValue && hardValue > 21);
        if (soft)
        {
            if (rules.hitOnSoft17())
            {
                if (softValue == 17)
                    return PlayerAction.HIT;
            }
            if(softValue > 17)
            {
                return PlayerAction.STAND;
            }
            return PlayerAction.HIT;
        }
        if (hardValue >= 17)
        {
            return PlayerAction.STAND;
        }
        return PlayerAction.HIT;
    }
}

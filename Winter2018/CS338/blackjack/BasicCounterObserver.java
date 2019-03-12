import java.util.logging.Logger;
import java.util.logging.Level;
public class BasicCounterObserver extends ShoeObserverBase implements ShoeObserver
{
    private Logger logger;
    private int count;

    public BasicCounterObserver(int minimumBet)
    {
        super(minimumBet);
        logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    }

    @Override
    public void update(Card card)
    {
        if (card.isAce())
        {
            count--;
        }
        else
        {
            int value = card.numericalValue();
            if (value <= 6)
            {
                count++;
            }
            else if (value >= 10)
            {
                count--;
            }
        }
        logger.log(Level.INFO, String.format("Current count: %d", count));
    }

    @Override
    public void clear()
    {
        count = 0;
    }

    @Override
    public PlayerAction recommendation(Hand playerHand, Value dealerShowing)
    {
        int hardValue = playerHand.hardValue();
        int softValue = playerHand.softValue();
        boolean soft = hardValue != softValue;
        int value;
        boolean ispair = playerHand.isPair();
        if (soft)
            value = softValue;
        else
            value = hardValue;
        if (count == 0)
        {
            if(value == 16 && dealerShowing == Value.TEN)
                return PlayerAction.HIT;
            else if(value == 12 && dealerShowing == Value.FOUR)
                return PlayerAction.HIT;
        }
        else if(count == 1)
        {
            if(value == 11 && dealerShowing == Value.ACE)
                return PlayerAction.DOUBLE;
            else if(value == 9 && dealerShowing == Value.TWO)
                return PlayerAction.DOUBLE;
        }
        else if(count == 2)
        {
            if(value == 12 && dealerShowing == Value.THREE)
                return PlayerAction.HIT;
        }
        else if (count == 3)
        {
            if(value == 12 && dealerShowing == Value.FOUR)
                return PlayerAction.HIT;
            else if (value == 9 && dealerShowing == Value.SEVEN)
                return PlayerAction.DOUBLE;
        }
        else if (count == 4)
        {
            if (value == 15 && dealerShowing == Value.TEN)
                return PlayerAction.HIT;
            else if (ispair && value == 20 && dealerShowing == Value.SIX)
                return PlayerAction.SPLIT;
            else if (value == 10 && dealerShowing == Value.TEN)
                return PlayerAction.DOUBLE;
            else if(value == 10 && dealerShowing == Value.ACE)
                return PlayerAction.DOUBLE;
        }
        else if (count == 5)
        {
            if (ispair && value == 20 && dealerShowing == Value.FIVE)
                return PlayerAction.SPLIT;
            else if(value == 16 && dealerShowing == Value.NINE)
                return PlayerAction.HIT;
        }
        else if (count == -1)
        {
            if(value == 13 && dealerShowing == Value.TWO)
                return PlayerAction.HIT;
            else if(value == 12 && dealerShowing == Value.SIX)
                return PlayerAction.HIT;
        }
        else if (count == -2)
        {
            if(value == 12 && dealerShowing == Value.FIVE)
                return PlayerAction.HIT;
            else if (value == 13 && dealerShowing == Value.THREE)
                return PlayerAction.HIT;
        }
        return BasicStrategyDecider.bestDecision(playerHand, dealerShowing);
    }

    @Override
    public int betRecommendation()
    {
        if (count < 14)
            return minimumBet;
        else if (count == 14)
            return 2 * minimumBet;
        else if (count == 15)
            return 4 * minimumBet;
        else
            return 16 * minimumBet;
    }
}

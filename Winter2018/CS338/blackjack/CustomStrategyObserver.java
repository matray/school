import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.io.Serializable;

public class CustomStrategyObserver extends ShoeObserverBase implements ShoeObserver, Serializable
{
    private static final long serialVersionUID = 12919294017592L;
    private Logger logger;
    private int count;
    private ArrayList<StratEntry> strategy;
    private ArrayList<BettingStrategy> betting;

    public CustomStrategyObserver(int minimumBet)
    {
        super(minimumBet);
        strategy = new ArrayList<StratEntry>();
        betting = new ArrayList<BettingStrategy>();
        logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    }

    @Override
    public void update(Card card)
    {
        if (card.isAce())
        {
            count --;
        }
        else
        {
            int value = card.numericalValue();
            if(value <= 6)
            {
                count++;
            }
            else if(value >= 10)
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

    public void addStratEntry(StratEntry entry)
    {
        strategy.add(entry);
    }

    public boolean compare(int actual, Operand op, int desired)
    {
        switch(op)
        {
            case NE:
                return desired != actual;
            case EQ:
                return desired == actual;
            case GT:
                return actual > desired;
            case GE:
                return actual >= desired;
            case LT:
                return actual < desired;
            case LE:
                return actual <= desired;
            default:
                return false;
        }
    }

    public void addBettingStrategy(BettingStrategy bet)
    {
        betting.add(bet);
    }

    @Override
    public int betRecommendation()
    {
        for(BettingStrategy bet : betting)
        {
            if (compare(count, bet.op, bet.count))
            {
                if (bet.bet == BetValue.MINIMUM)
                {
                    return minimumBet;
                }
                else if (bet.bet == BetValue.UNIT)
                {
                    return minimumBet * bet.units;
                }
            }
        }
        return minimumBet;
    }

    @Override
    public PlayerAction recommendation(Hand hand, Value showing)
    {
        int hardValue = hand.hardValue();
        int softValue = hand.softValue();
        boolean soft = (softValue != hardValue && softValue <= 21);
        boolean pair = hand.isPair();
        for (StratEntry entry : strategy)
        {
            if (showing != entry.showing)
                continue;
            if (pair && (entry.type == StrategyType.PAIR || entry.type == StrategyType.PAIR_COUNT))
            {
                Value value = Card.normalizeValue(hand.getCard(0).getValue());

                if (entry.type == StrategyType.PAIR)
                {
                    if (value == entry.value)
                    {
                        return entry.action;
                    }
                }
                else if (entry.type == StrategyType.PAIR_COUNT)
                {
                    if(value == entry.value)
                    {
                        if(compare(count, entry.countOp, entry.count))
                        {
                            return entry.action;
                        }
                    }
                }
            }
            else if (soft && (entry.type == StrategyType.SOFT_VALUE || entry.type == StrategyType.SOFT_VALUE_COUNT))
            {
                if (compare(softValue, entry.op, entry.numValue))
                {
                    if (entry.type == StrategyType.SOFT_VALUE_COUNT)
                    {
                        if (compare(count, entry.countOp, entry.count))
                        {
                            return entry.action;
                        }
                    }
                    else
                    {
                        return entry.action;
                    }
                }
            }
            else if (!soft && (entry.type == StrategyType.HARD_VALUE || entry.type == StrategyType.HARD_VALUE_COUNT))
            {
                if (compare(hardValue, entry.op, entry.numValue))
                {
                    if(entry.type == StrategyType.HARD_VALUE_COUNT)
                    {
                        if (compare(count, entry.countOp, entry.count))
                        {
                            return entry.action;
                        }
                    }
                    else
                    {
                        return entry.action;
                    }
                }
            }
        }
        return BasicStrategyDecider.bestDecision(hand, showing);
    }
}

import java.util.logging.Logger;
import java.util.logging.Level;

public class House
{
    private Rules rules;
    private DealerObserver dealerObserver;
    private Logger logger;

    public House(Rules rules, DealerObserver dealerObserver)
    {
        this.rules = rules;
        this.dealerObserver = dealerObserver;
        logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        String message = String.format(
                "House initialized with rules:\n" +
                "    Hit On Soft 17: %s\n" +
                "    Double After Split Allowed: %s\n" +
                "    Late Surrender Allowed:  %s\n" +
                "    Payout: %s\n" +
                "    Splits: %s",
                String.valueOf(rules.hitOnSoft17()),
                String.valueOf(rules.doubleAfterSplitAllowed()),
                String.valueOf(rules.lateSurrenderAllowed()),
                rules.payout().name(),
                rules.splits().name());
        logger.log(Level.FINE, message);
    }

    public Rules getRules()
    {
        return rules;
    }

    public HouseDecision checkPlayerAction(int bet, Player player, Hand hand, PlayerAction action)
    {
        int bankroll = player.bankroll();
        boolean canIncreaseBet = bankroll >= bet;
        int numHands = player.numHands();
        boolean isPair = hand.isPair();
        if (numHands == 0)
        {
            if(action == PlayerAction.SIT_OUT)
                return HouseDecision.ALLOWED;
            return HouseDecision.DENIED;
        }
        switch(action)
        {
            case SIT_OUT:
                throw new UnsupportedOperationException("Player mid game, cannot sit out");
            case STAND:
                return HouseDecision.ALLOWED;
            case HIT:
                return HouseDecision.ALLOWED;
            case DOUBLE:
                if (canIncreaseBet && (numHands > 1 && rules.doubleAfterSplitAllowed()) || numHands == 1)
                    return HouseDecision.ALLOWED;
                return HouseDecision.NOT_ENOUGH_MONEY;
            case SPLIT:
                if (!isPair)
                    return HouseDecision.DENIED;
                if (!canIncreaseBet)
                    return HouseDecision.NOT_ENOUGH_MONEY;
                switch (rules.splits())
                {
                    case THREE:
                        if (numHands == 4)
                            return HouseDecision.DENIED;
                        return HouseDecision.ALLOWED;
                    case TWO:
                        if (numHands == 3)
                            return HouseDecision.DENIED;
                        return HouseDecision.ALLOWED;
                    case ONE:
                        if (numHands == 2)
                            return HouseDecision.DENIED;
                        return HouseDecision.ALLOWED;
                    case THREEWITHTWOACES:
                        if (hand.getCard(0).getValue() == Value.ACE)
                        {
                            if (numHands == 2)
                                return HouseDecision.DENIED;
                            return HouseDecision.ALLOWED;
                        }
                        if (numHands == 4)
                            return HouseDecision.DENIED;
                        return HouseDecision.ALLOWED;
                    case TWOWITHTWOACES:
                        if (hand.getCard(0).getValue() == Value.ACE)
                        {
                            if (numHands == 2)
                                return HouseDecision.DENIED;
                            return HouseDecision.ALLOWED;
                        }
                        if (numHands == 3)
                            return HouseDecision.DENIED;
                        return HouseDecision.ALLOWED;
                    case ONEWITHTWOACES:
                        if (hand.getCard(0).getValue() == Value.ACE)
                        {
                            if (numHands == 2)
                                return HouseDecision.DENIED;
                            return HouseDecision.ALLOWED;
                        }
                        if (numHands == 2)
                            return HouseDecision.DENIED;
                        return HouseDecision.ALLOWED;
                    default:
                        throw new UnsupportedOperationException("Unknown SplitPossibility");
                }
            default:
                throw new UnsupportedOperationException("Did not implement other options");
        }
    }
}

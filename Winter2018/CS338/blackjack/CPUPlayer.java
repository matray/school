import java.util.logging.Logger;
import java.util.logging.Level;

public class CPUPlayer extends Player
{
    public CPUPlayer(String name, Rules rules, int bankroll, DealerObserver dealerObserver)
    {
        super(name, rules, bankroll, dealerObserver);
        logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    }

    @Override
    public boolean isPlaying()
    {
        return true;
    }

    @Override
    public PlayerAction desiredAction(Hand hand)
    {
        logger.log(Level.FINE, String.format("dealer showing %s", dealerObserver.getShowing()));
        return shoeObserver.recommendation(hand, dealerObserver.getShowing());
    }

    @Override
    public int desiredBet()
    {
        return shoeObserver.betRecommendation();
    }
}

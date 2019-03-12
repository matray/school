public class BasicStrategyObserver extends ShoeObserverBase implements ShoeObserver
{
    public BasicStrategyObserver(int minimumBet)
    {
        super(minimumBet);
    }

    @Override
    public void update(Card card)
    {
    }

    @Override
    public void clear()
    {
    }

    @Override
    public PlayerAction recommendation(Hand playerHand, Value showing)
    {
        return BasicStrategyDecider.bestDecision(playerHand, showing);
    }

    @Override
    public int betRecommendation()
    {
        return minimumBet;
    }
}

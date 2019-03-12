public interface ShoeObserver
{
    public void update(Card card);
    public PlayerAction recommendation(Hand playerHand, Value dealerShowing);
    public int betRecommendation();
    public void clear();
}

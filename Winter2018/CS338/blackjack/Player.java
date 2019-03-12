import java.util.Vector;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.HashMap;

public class Player extends Actor
{
    protected HashMap<Hand, Integer> bets;
    protected DealerObserver dealerObserver;
    protected int bankroll;
    protected ShoeObserver shoeObserver;
    public Player(String name, Rules rules, int bankroll, DealerObserver dealerObserver)
    {
        super(name, rules);
        bets = new HashMap<Hand, Integer>();
        this.dealerObserver = dealerObserver;
        logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        this.bankroll = bankroll;
        String message = String.format("Initial bankroll: %d", bankroll);
        logger.log(Level.FINE, message);
    }

    @Override
    public String toString()
    {
        String output = "Player{name=" + name;
        int count = 0;
        for(Hand hand : hands)
        {
            output += String.format(",Hand%d=%s", count, hand);
        }
        output += "}";
        return output;
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Player player = (Player)o;
        if(bankroll != player.bankroll()) return false;
        if(name != player.getName()) return false;
        if(numHands() != player.numHands()) return false;
        for(int i = 0; i < numHands(); i++)
        {
            if(player.getHand(i) != getHand(i)) return false;
        }
        return true;
    }

    @Override
    public int hashCode()
    {
        int result = name.hashCode();
        for(Hand hand : hands)
        {
            result += hand.hashCode();
        }
        result += bankroll;
        return result;
    }

    public int bankroll()
    {
        return bankroll;
    }

    public void setShoeObserver(ShoeObserver observer)
    {
        this.shoeObserver = observer;
    }

    public boolean isPlaying()
    {
        throw new UnsupportedOperationException("Requires input");
    }

    public void addToBankroll(int value)
    {
        bankroll += value;
        String message = String.format("Adding %d to bankroll, new total is %d", value, bankroll);
        logger.log(Level.FINE, message);
    }

    public void subtractFromBankroll(int value)
    {
        bankroll -= value;
        String message = String.format("Removing %d from bankroll, new total is %d", value, bankroll);
        logger.log(Level.FINE, message);
    }

    public PlayerAction desiredAction(Hand hand)
    {
        throw new UnsupportedOperationException("Requires input");
    }

    public int desiredBet()
    {
        throw new UnsupportedOperationException("Requires input");
    }

    public Integer getBet(Hand hand)
    {
        int index = hands.indexOf(hand);
        return bets.get(index);
    }
}

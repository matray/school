import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class Actor implements Iterable<Hand>
{
    protected Logger logger;
    protected String name;
    protected ArrayList<Hand> hands;
    protected Rules rules;
    public Actor(String name, Rules rules)
    {
        this.name = name;
        this.rules = rules;
        hands = new ArrayList<Hand>();
    }

    public String getName()
    {
        return this.name;
    }

    public abstract boolean isPlaying();

    public abstract boolean hasBank();
    public abstract PlayerAction desiredAction(Hand hand);

    public abstract int bankroll();

    public Iterator<Hand> iterator()
    {
        return new ActorIterator(this);
    }

    public Hand getHand(int index)
    {
        return hands.get(index);
    }

    public void addHand(Hand hand)
    {
        hands.add(hand);
    }

    public void removeHand(Hand hand)
    {
        hands.remove(hand);
    }

    public void clear()
    {
        hands.clear();
    }

    public Integer numHands()
    {
        return hands.size();
    }

    public class ActorIterator implements Iterator<Hand>
    {
        private Actor iterableActor;
        private int position;
        public ActorIterator(Actor iterableActor)
        {
            this.iterableActor = iterableActor;
        }

        @Override
        public boolean hasNext()
        {
            return position < iterableActor.hands.size();
        }

        @Override
        public Hand next()
        {
            if (position >= iterableActor.hands.size())
            {
                throw new NoSuchElementException("No more hands left");
            }
            return iterableActor.getHand(position++);
        }

        @Override
        public void remove()
        {
            throw new UnsupportedOperationException("remove() not implemented for Actor");
        }
    }
}

import java.util.HashMap;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.math.BigInteger;
import javax.swing.*;

public class Table
{
    private static int maxPlayers = 6;
    private Dealer dealer;
    private ArrayList<Player> players;
    private Shoe shoe;
    private House house;
    private int minimumBet;
    private ShoeObserver observer;
    private Logger logger;
    private DealerObserver dealerObserver;
    private int numberOfHands;
    private ProgressMonitor pm;

    public Table(Shoe shoe, House house, int minimumBet, DealerObserver dealerObserver)
    {
        this.shoe = shoe;
        players = new ArrayList<Player>();
        dealer = new Dealer("Main Dealer", house.getRules());
        this.house = house;
        this.minimumBet = minimumBet;
        this.dealerObserver = dealerObserver;
        dealer.addDealerObserver(dealerObserver);
        logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    }

    public void setNumberOfHands(int count)
    {
        numberOfHands = count;
    }

    public void addPlayer(Player player)
    {
        players.add(player);
    }

    public void addObserver(ShoeObserver observer)
    {
        this.observer = observer;
    }

    public void dealToHand(Hand hand)
    {
        Card card = shoe.deal();
        hand.addCard(card);
    }

    public void setProgressMonitor(ProgressMonitor pm)
    {
        this.pm = pm;
    }

    public Integer getPlayerBankroll(int index)
    {
        return players.get(index).bankroll();
    }

    public void play()
    {
        logger.log(Level.INFO, "Opening the table");
        for(int counter = 0; counter < numberOfHands; counter++)
        {
            String countMessage = String.format("Game count: %d", counter);
            logger.log(Level.INFO, countMessage);
            if (counter % 1000 == 0)
            {
                if(pm != null)
                {
                    if(pm.isCanceled())
                    {
                        throw new UnsupportedOperationException("Canceled");
                    }
                    pm.setProgress(counter);
                }
            }
            if(shoe.isPenetrated())
            {
                logger.log(Level.INFO, "Resetting shoe");
                shoe.reset();
            }

            // Determine who is playing
            logger.log(Level.FINE, "Determining who is playing");
            ArrayList<Player> actuallyPlaying = new ArrayList<Player>();
            ArrayList<Integer> initialBets = new ArrayList<Integer>();
            HashMap<Integer, Integer> bets = new HashMap<Integer, Integer>();
            for(Player player : players)
            {
                logger.log(Level.FINE, String.format("Asking player: %s if they are playing", player.getName()));
                logger.log(Level.FINE, String.format("Playing: %s, Bankroll: %d, Minimum Bet: %d", String.valueOf(player.isPlaying()), player.bankroll(), minimumBet));
                if (player.isPlaying() && player.bankroll() > minimumBet)
                {
                    int bet = player.desiredBet();
                    logger.log(Level.FINE, String.format("Desired player bet: %d", bet));
                    if (bet <= player.bankroll())
                    {
                        actuallyPlaying.add(player);
                    }
                }
            }
            if (actuallyPlaying.size() == 0)
            {
                return;
            }
            // Collect bets
            logger.log(Level.FINE, "Collecting bets");
            for(Player player : actuallyPlaying)
            {
                int bet = player.desiredBet();
                logger.log(Level.FINE, String.format("Player %s wants to bet %d", player.getName(), bet));
                player.subtractFromBankroll(bet);
                initialBets.add(bet);
            }
            // Deal
            logger.log(Level.FINE, "Dealing hands");
            ArrayList<Hand> hands = new ArrayList<Hand>();
            for(Player player : actuallyPlaying)
            {
                Hand hand = new Hand(player.getName() + " Initial");
                dealToHand(hand);
                hands.add(hand);
            }
            Hand dealerHand = new Hand(dealer.getName() + "Initial");
            dealToHand(dealerHand);
            for(Hand hand : hands)
            {
                dealToHand(hand);
            }
            dealToHand(dealerHand);
            for(int i = 0; i < hands.size(); i++)
            {
                Hand hand = hands.get(i);
                Player player = actuallyPlaying.get(i);
                player.addHand(hand);
                logger.log(Level.FINE, String.format("Loop debugger: i = %d, hand = %s, bet = %d, player = %s", i, hand.toString(), initialBets.get(i), player.getName()));
                bets.put(hand.id(), initialBets.get(i));
            }
            dealer.addHand(dealerHand);
            // Ask actions
            logger.log(Level.FINE, "Asking for actions");
            for(Player player : actuallyPlaying)
            {
                for(Hand hand : player)
                {
                    PlayerAction action = PlayerAction.HIT;
                    HouseDecision decision = HouseDecision.ALLOWED;
                    while(action != PlayerAction.STAND && decision == HouseDecision.ALLOWED)
                    {
                        logger.log(Level.FINE, String.format("Determining action for player %s", player.getName()));
                        action = player.desiredAction(hand);
                        int tempbet = bets.get(hand.id());
                        logger.log(Level.FINE, String.format("Loop debugger: tempbet = %d", tempbet));
                        logger.log(Level.FINE, String.format("Loop debugger: player = %s", player.getName()));
                        logger.log(Level.FINE, String.format("Loop debugger: hand = %s", hand.toString()));
                        logger.log(Level.FINE, String.format("Loop debugger: action = %s", action));
                        decision = house.checkPlayerAction(tempbet, player, hand, action);
                        if (decision != HouseDecision.ALLOWED)
                        {
                            break;
                        }
                        switch(action)
                        {
                            case STAND:
                                break;
                            case HIT:
                                dealToHand(hand);
                                break;
                            case SPLIT:
                                Hand hand2 = new Hand(player.getName() + " " + Integer.toString(player.numHands() + 1));
                                Card card1 = hand.getCard(0);
                                Card card2 = hand.getCard(1);
                                hand.removeCard(card1);
                                hand2.addCard(card2);
                                dealToHand(hand);
                                dealToHand(hand2);
                                int betSize = bets.get(hand.id());
                                player.addHand(hand2);
                                player.subtractFromBankroll(betSize);
                                bets.put(hand2.id(), betSize);
                                logger.log(Level.FINE, hand.toString());
                                logger.log(Level.FINE, hand2.toString());
                                break;
                            case DOUBLE:
                                int bet = bets.get(hand.id());
                                player.subtractFromBankroll(bet);
                                bets.put(hand.id(), bet*2);
                                dealToHand(hand);
                                logger.log(Level.FINE, hand.toString());
                                break;
                            default:
                                throw new UnsupportedOperationException("Action not supported");
                        }
                    }
                }
            }
            logger.log(Level.FINE, "Getting dealer action");
            PlayerAction dealerAction = PlayerAction.HIT;
            while(dealerAction != PlayerAction.STAND)
            {
                dealerAction = dealer.desiredAction(dealerHand);
                switch(dealerAction)
                {
                    case HIT:
                        dealToHand(dealerHand);
                        break;
                    case STAND:
                        break;
                    default:
                        throw new UnsupportedOperationException("Dealer should only Hit or Stand");
                }
            }
            logger.log(Level.FINE, "Distributing winnings");
            Tuple<HandValueType, Integer> dealerValue = dealerHand.getValue();
            logger.log(Level.INFO, "Dealer Ending Hand: " + dealerHand.toString());
            for(Player player : actuallyPlaying)
            {
                for(Hand hand : player)
                {
                    logger.log(Level.INFO, String.format("Player (%s) Ending Hand: %s", player.getName(), hand.toString()));
                    Tuple<HandValueType, Integer> handValue = hand.getValue();
                    int betSize = bets.get(hand.id());
                    if (dealerHand.isBust() && hand.isBust() || dealerValue.second == handValue.second)
                    {
                        player.addToBankroll(betSize);
                        logger.log(Level.INFO, "PUSHED");
                    }
                    else if(dealerHand.isBust() || (dealerValue.second < handValue.second && !hand.isBust()))
                    {
                        player.addToBankroll(betSize * 2);
                        logger.log(Level.INFO, "MADE MONEY");
                    }
                    else
                    {
                        logger.log(Level.INFO, "LOST MONEY");
                    }
                }
            }
            logger.log(Level.INFO, "Player bankroll statuses:");
            logger.log(Level.INFO, String.format("Total players: %d", actuallyPlaying.size()));
            for(Player player : actuallyPlaying)
            {
                String message = String.format("Player (%s) ended with bankroll %d", player.getName(), player.bankroll());
                logger.log(Level.INFO, message);
                player.clear();
            }
            dealer.clear();
        }
        if(pm != null)
        {
            if(pm.isCanceled())
            {
                throw new UnsupportedOperationException("Canceled");
            }
            pm.setProgress(numberOfHands);
        }
    }
}

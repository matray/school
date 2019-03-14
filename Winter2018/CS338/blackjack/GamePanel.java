import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;
import java.util.logging.Level;

public class GamePanel extends JPanel
{
    public Shoe shoe;
    public Rules rules;
    public DealerObserver dealerObserver;
    public House house;
    public int startingBet;
    public Player p1;
    public PlayerPanel pp1;
    public Player p2;
    public PlayerPanel pp2;
    public Player p3;
    public PlayerPanel pp3;
    public Player p4;
    public PlayerPanel pp4;
    public Player user;
    public PlayerPanel userp;
    public Dealer dealer;
    public PlayerPanel dealerp;
    public int desiredCounters;
    public int desiredCounterCache;
    public int desiredBasic;
    public int desiredBasicCache;
    public int numberOfDecks;
    public int minimumBet;
    public int player_bet;
    public PlayerAction player_action;
    public ControlsPanel controls;
    public Table table;
    private ArrayList<Player> playing;
    private HashMap<Integer, Integer> bets;
    private Hand dealerHand;
    private int userBet;
    private Logger logger;
    public Shoe getShoe()
    {
		int penetration = 290;
		rules = new Rules();
		dealerObserver = new DealerObserver();
		Shoe locshoe = new Shoe(penetration, numberOfDecks);
		house = new House(rules, dealerObserver);
		table = new Table(locshoe, house, minimumBet, dealerObserver);
		ShoeObserver basicObserver = new BasicStrategyObserver(minimumBet);
		ShoeObserver countingObserver = new BasicCounterObserver(minimumBet);
		locshoe.addObserver(basicObserver);
		locshoe.addObserver(countingObserver);
        return locshoe;
    }


    public GamePanel()
    {
        logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        bets = new HashMap<Integer, Integer>();
        startingBet = 1000;
        minimumBet = 5;
        desiredCounters = 0;
        desiredBasic = 0;
        numberOfDecks = 8;
        reset();
    }
    public void reset()
    {
        userBet = minimumBet;
        desiredBasic = desiredBasicCache;
        desiredCounters = desiredCounterCache;
        shoe = getShoe();
        dealer = new Dealer("Dealer", rules);
        dealer.addDealerObserver(dealerObserver);
        setLayout(new GridLayout(4, 3));

        if(desiredCounters > 0 || desiredBasic > 0)
        {

            p1 = new CPUPlayer("CPU 1", rules, startingBet, dealerObserver);
            if(desiredCounters > 0)
            {
                ShoeObserver observer = new BasicCounterObserver(minimumBet);
                shoe.addObserver(observer);
                p1.setShoeObserver(observer);
                desiredCounters--;
            }
            else if(desiredBasic > 0)
            {
                ShoeObserver observer = new BasicStrategyObserver(minimumBet);
                shoe.addObserver(observer);
                p1.setShoeObserver(observer);
                desiredBasic--;
            }
        }
        if(desiredCounters > 0 || desiredBasic > 0)
        {

            p2 = new CPUPlayer("CPU 2", rules, startingBet, dealerObserver);
            if(desiredCounters > 0)
            {
                ShoeObserver observer = new BasicCounterObserver(minimumBet);
                shoe.addObserver(observer);
                p2.setShoeObserver(observer);
                desiredCounters--;
            }
            else if(desiredBasic > 0)
            {
                ShoeObserver observer = new BasicStrategyObserver(minimumBet);
                shoe.addObserver(observer);
                p2.setShoeObserver(observer);
                desiredBasic--;
            }
        }
        if(desiredCounters > 0 || desiredBasic > 0)
        {

            p3 = new CPUPlayer("CPU 3", rules, startingBet, dealerObserver);
            if(desiredCounters > 0)
            {
                ShoeObserver observer = new BasicCounterObserver(minimumBet);
                shoe.addObserver(observer);
                p3.setShoeObserver(observer);
                desiredCounters--;
            }
            else if(desiredBasic > 0)
            {
                ShoeObserver observer = new BasicStrategyObserver(minimumBet);
                shoe.addObserver(observer);
                p3.setShoeObserver(observer);
                desiredBasic--;
            }
        }
        if(desiredCounters > 0 || desiredBasic > 0)
        {

            p4 = new CPUPlayer("CPU 4", rules, startingBet, dealerObserver);
            if(desiredCounters > 0)
            {
                ShoeObserver observer = new BasicCounterObserver(minimumBet);
                shoe.addObserver(observer);
                p4.setShoeObserver(observer);
                desiredCounters--;
            }
            else if(desiredBasic > 0)
            {
                ShoeObserver observer = new BasicStrategyObserver(minimumBet);
                shoe.addObserver(observer);
                p4.setShoeObserver(observer);
                desiredBasic--;
            }
        }
        user = new Player("User", rules, startingBet, dealerObserver);
        controls = new ControlsPanel(this);
        redopaint();
        dealAndPrimeForPlayer();
        redopaint();
    }

    public void redopaint()
    {
        removeAll();
        setOpaque(false);
        add(new JLabel());
        add(new PlayerPanel(dealer));
        add(new JLabel());
        if(p1!= null)
        {
            add(new PlayerPanel(p1));
        }
        else
        {
            add(new JLabel());
        }
        add(new JLabel());
        if(p2!= null)
        {
            add(new PlayerPanel(p2));
        }
        else
        {
            add(new JLabel());
        }
        if(p3!=null)
        {
            add(new PlayerPanel(p3));
        }
        else
        {
            add(new JLabel());
        }
        add(new PlayerPanel(user));
        if(p4!=null)
        {
            add(new PlayerPanel(p4));
        }
        else
        {
            add(new JLabel());
        }
        add(new GameManipulationPanel(this));
        add(controls);
        add(new JLabel());
        validate();
        repaint();
    }

    private void dealToHand(Hand hand)
    {
        Card card = shoe.deal();
        hand.addCard(card);
    }

    public void dealAndPrimeForPlayer()
    {
        bets = new HashMap<Integer, Integer>();
        if(p1 != null)
        {
           int bet = p1.desiredBet();
           p1.subtractFromBankroll(bet);
           Hand hand = new Hand(p1.getName());
           dealToHand(hand);
           dealToHand(hand);
           p1.addHand(hand);
           bets.put(hand.id(), bet);
           pp1 = new PlayerPanel(p1);
           pp1.validate();
           pp1.repaint();
        }
        if(p2 != null)
        {
           int bet = p2.desiredBet();
           p2.subtractFromBankroll(bet);
           Hand hand = new Hand(p2.getName());
           dealToHand(hand);
           dealToHand(hand);
           p2.addHand(hand);
           bets.put(hand.id(), bet);
            pp2 = new PlayerPanel(p2);
            pp2.validate();
            pp2.repaint();
        }
        if(p3 != null)
        {
           int bet = p3.desiredBet();
           p3.subtractFromBankroll(bet);
           Hand hand = new Hand(p3.getName());
           dealToHand(hand);
           dealToHand(hand);
           p3.addHand(hand);
           bets.put(hand.id(), bet);
            pp3 = new PlayerPanel(p3);
            pp3.validate();
            pp3.repaint();
        }
        if(p4 != null)
        {
           int bet = p4.desiredBet();
           p4.subtractFromBankroll(bet);
           Hand hand = new Hand(p4.getName());
           dealToHand(hand);
           dealToHand(hand);
           p4.addHand(hand);
           bets.put(hand.id(), bet);

            pp4 = new PlayerPanel(p4);
            pp4.validate();
            pp4.repaint();
        }
        dealerHand = new Hand(dealer.getName());
        dealToHand(dealerHand);
        dealToHand(dealerHand);
        dealer.addHand(dealerHand);
        dealerp = new PlayerPanel(dealer);
        dealerp.validate();
        dealerp.repaint();
        Hand hand = new Hand(user.getName());
        dealToHand(hand);
        dealToHand(hand);
        user.subtractFromBankroll(userBet);
        user.addHand(hand);
        bets.put(hand.id(), controls.getBet());
        userp = new PlayerPanel(user);
        userp.validate();
        userp.repaint();
        executeActionsToPlayer();
    }

    public void playerLoop(Player p)
    {
        for(Hand hand : p)
        {
            PlayerAction action = PlayerAction.HIT;
            HouseDecision decision = HouseDecision.ALLOWED;
            while(action != PlayerAction.STAND && decision == HouseDecision.ALLOWED)
            {
                action = p.desiredAction(hand);
                int tempbet = bets.get(hand.id());
                decision = house.checkPlayerAction(tempbet, p, hand, action);
                if(decision != HouseDecision.ALLOWED)
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
                        Hand hand2 = new Hand(p.getName() + " " + Integer.toString(p.numHands() + 1));
                        Card card1 = hand.getCard(0);
                        Card card2 = hand.getCard(1);
                        hand.removeCard(card1);
                        hand2.addCard(card2);
                        dealToHand(hand);
                        dealToHand(hand2);
                        int betsize = bets.get(hand.id());
                        p.addHand(hand2);
                        p.subtractFromBankroll(betsize);
                        bets.put(hand2.id(), betsize);
                        break;
                    case DOUBLE:
                        int bet = bets.get(hand.id());
                        p.subtractFromBankroll(bet);
                        bets.put(hand.id(), bet*2);
                        dealToHand(hand);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public void executeActionsToPlayer()
    {
        if(p1 != null)
        {
           playerLoop(p1);
           pp1 = new PlayerPanel(p1);
           pp1.validate();
           pp1.repaint();
        }
        if(p2 != null)
        {
            playerLoop(p2);
            pp2 = new PlayerPanel(p2);
            pp2.validate();
            pp2.repaint();
        }
        if(p3 != null)
        {
            playerLoop(p3);
            pp3 = new PlayerPanel(p3);
            pp3.validate();
            pp3.repaint();
        }
        if(p4 != null)
        {
            playerLoop(p4);
            pp4 = new PlayerPanel(p4);
            pp4.validate();
            pp4.repaint();
        }
        userindex = 0;
        usermax = 1;
        validate();
        redopaint();
        logger.log(Level.FINE, "inside execute actions to player");
    }

    private int userindex;
    private int usermax;
    public void executePlayerAction(PlayerAction action)
    {
        logger.log(Level.FINE, "Execute callback");
        Hand hand = user.getHand(userindex);
        int tempbet = bets.get(hand.id());
        HouseDecision decision = house.checkPlayerAction(tempbet, user, hand, action);
        if(decision != HouseDecision.ALLOWED)
        {
            return;
        }
        switch(action)
        {
            case STAND:
                userindex++;
                if(userindex == usermax)
                    standCB();
            case HIT:
                dealToHand(hand);
                break;
            case SPLIT:
                Hand hand2 = new Hand(user.getName() + " " + Integer.toString(user.numHands() + 1));
                Card card1 = hand.getCard(0);
                Card card2 = hand.getCard(1);
                hand.removeCard(card1);
                hand2.addCard(card2);
                dealToHand(hand);
                dealToHand(hand2);
                int betsize = bets.get(hand.id());
                user.addHand(hand2);
                user.subtractFromBankroll(betsize);
                bets.put(hand2.id(), betsize);
                usermax++;
                break;
            case DOUBLE:
                int bet = bets.get(hand.id());
                user.subtractFromBankroll(bet);
                bets.put(hand.id(), bet*2);
                dealToHand(hand);
                break;
            default:
                break;
        }
        redopaint();
    }

    public void standCB()
    {
        PlayerAction action = PlayerAction.HIT;
        while(action != PlayerAction.STAND)
        {
            action = dealer.desiredAction(dealerHand);
            switch(action)
            {
                case HIT:
                    dealToHand(dealerHand);
                default:
                    break;
            }
        }
        executeBets();
    }

    public void playerHandBetCB(Player p, Tuple<HandValueType, Integer> dealerValue)
    {
        for(Hand hand: p)
        {
            Tuple<HandValueType, Integer> handvalue = hand.getValue();
            int betsize = bets.get(hand.id());
            if(dealerHand.isBust() && hand.isBust() || dealerValue.second == handvalue.second)
            {
                p.addToBankroll(betsize);
            }
            else if(dealerHand.isBust() || (dealerValue.second < handvalue.second && !hand.isBust()))
            {
                p.addToBankroll(betsize*2);
            }
            else
            {
                //push
            }
        }
    }

    public void executeBets()
    {
        Tuple<HandValueType, Integer> dealerValue = dealerHand.getValue();
        if(p1!=null)playerHandBetCB(p1, dealerValue);
        if(p2!=null)playerHandBetCB(p2, dealerValue);
        if(p3!=null)playerHandBetCB(p3, dealerValue);
        if(p4!=null)playerHandBetCB(p4, dealerValue);
        playerHandBetCB(user, dealerValue);
        clearHands();
    }

    public void clearHands()
    {
        if(p1 != null)
        {
           p1.clear();
           pp1 = new PlayerPanel(p1);
           pp1.validate();
           pp1.repaint();
        }
        if(p2 != null)
        {
            p2.clear();
            pp2 = new PlayerPanel(p2);
            pp2.validate();
            pp2.repaint();
        }
        if(p3 != null)
        {
            p3.clear();
            pp3 = new PlayerPanel(p3);
            pp3.validate();
            pp3.repaint();
        }
        if(p4 != null)
        {
            p4.clear();
            pp4 = new PlayerPanel(p4);
            pp4.validate();
            pp4.repaint();
        }
        dealer.clear();
        dealerp = new PlayerPanel(dealer);
        dealerp.validate();
        dealerp.repaint();
        userBet = controls.getBet();
        user.clear();
        userindex=0;
        usermax=1;
        validate();
        repaint();
        dealAndPrimeForPlayer();
    }
}

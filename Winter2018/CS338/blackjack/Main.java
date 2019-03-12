/*
 import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
import java.io.IOException;

public class Main
{
    public static void main(String[] args)
    {
            System.setProperty("java.util.logging.SimpleFormatter.format",
                                "%1$tF %1$tT [%4$s] (%2$s) %5$s%6$s%n");

        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        logger.setUseParentHandlers(false);
        FileHandler file;
        try
        {
            file = new FileHandler("blackjack.log", true);
            logger.addHandler(file);
            SimpleFormatter formatter = new SimpleFormatter();
            file.setFormatter(formatter);
            BasicStrategyDecider.logEverything();
            int numberOfDecks = 8;
            int penetration = 290;
            int startingBet = 10000;
            int minimumBet = 5;
            Rules rules = new Rules();
            DealerObserver dealerObserver = new DealerObserver();
            Shoe shoe = new Shoe(penetration, numberOfDecks);
            House house = new House(rules, dealerObserver);
            Table table = new Table(shoe, house, minimumBet, dealerObserver);
            ShoeObserver basicObserver = new BasicStrategyObserver(minimumBet);
            ShoeObserver countingObserver = new BasicCounterObserver(minimumBet);
            shoe.addObserver(basicObserver);
            shoe.addObserver(countingObserver);
            CPUPlayer cpu1 = new CPUPlayer("CPU1", rules, startingBet, dealerObserver);
            cpu1.setShoeObserver(basicObserver);
            CPUPlayer cpu2 = new CPUPlayer("CPU2", rules, startingBet, dealerObserver);
            cpu2.setShoeObserver(countingObserver);
            table.addPlayer(cpu1);
            table.addPlayer(cpu2);
            table.play();
        }
        catch(SecurityException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        logger.log(Level.FINE, "Should not be hit");
    }
}
*/

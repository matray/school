import java.util.Map;
import java.util.HashMap;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.Iterator;

public class BasicStrategyDecider
{
    //Maps go [playerhand value] then [dealer value]
    private static HashMap<Value, HashMap<Value, PlayerAction>> pairs = pairsMap();
    private static HashMap<Integer, HashMap<Value, PlayerAction>> hards = hardsMap();
    private static HashMap<Integer, HashMap<Value, PlayerAction>> softs = softsMap();
    private static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private static HashMap<Value, HashMap<Value, PlayerAction>> pairsMap()
    {
        HashMap<Value, HashMap<Value, PlayerAction>> map = new HashMap<Value, HashMap<Value, PlayerAction>>();
        HashMap<Value, PlayerAction> mapa8 = new HashMap<Value, PlayerAction>();
        mapa8.put(Value.TWO, PlayerAction.SPLIT);
        mapa8.put(Value.THREE, PlayerAction.SPLIT);
        mapa8.put(Value.FOUR, PlayerAction.SPLIT);
        mapa8.put(Value.FIVE, PlayerAction.SPLIT);
        mapa8.put(Value.SIX, PlayerAction.SPLIT);
        mapa8.put(Value.SEVEN, PlayerAction.SPLIT);
        mapa8.put(Value.EIGHT, PlayerAction.SPLIT);
        mapa8.put(Value.NINE, PlayerAction.SPLIT);
        mapa8.put(Value.TEN, PlayerAction.SPLIT);
        mapa8.put(Value.ACE, PlayerAction.SPLIT);

        map.put(Value.ACE, mapa8);
        map.put(Value.EIGHT, mapa8);

        HashMap<Value, PlayerAction> mapt = new HashMap<Value, PlayerAction>();
        mapt.put(Value.TWO, PlayerAction.STAND);
        mapt.put(Value.THREE, PlayerAction.STAND);
        mapt.put(Value.FOUR, PlayerAction.STAND);
        mapt.put(Value.FIVE, PlayerAction.STAND);
        mapt.put(Value.SIX, PlayerAction.STAND);
        mapt.put(Value.SEVEN, PlayerAction.STAND);
        mapt.put(Value.EIGHT, PlayerAction.STAND);
        mapt.put(Value.NINE, PlayerAction.STAND);
        mapt.put(Value.TEN, PlayerAction.STAND);
        mapt.put(Value.ACE, PlayerAction.STAND);

        map.put(Value.TEN, mapt);

        HashMap<Value, PlayerAction> map9 = new HashMap<Value, PlayerAction>();
        map9.put(Value.TWO, PlayerAction.SPLIT);
        map9.put(Value.THREE, PlayerAction.SPLIT);
        map9.put(Value.FOUR, PlayerAction.SPLIT);
        map9.put(Value.FIVE, PlayerAction.SPLIT);
        map9.put(Value.SIX, PlayerAction.SPLIT);
        map9.put(Value.SEVEN, PlayerAction.STAND);
        map9.put(Value.EIGHT, PlayerAction.SPLIT);
        map9.put(Value.NINE, PlayerAction.SPLIT);
        map9.put(Value.TEN, PlayerAction.STAND);
        map9.put(Value.ACE, PlayerAction.STAND);

        map.put(Value.NINE, map9);

        HashMap<Value, PlayerAction> map7 = new HashMap<Value, PlayerAction>();
        map7.put(Value.TWO, PlayerAction.SPLIT);
        map7.put(Value.THREE, PlayerAction.SPLIT);
        map7.put(Value.FOUR, PlayerAction.SPLIT);
        map7.put(Value.FIVE, PlayerAction.SPLIT);
        map7.put(Value.SIX, PlayerAction.SPLIT);
        map7.put(Value.SEVEN, PlayerAction.SPLIT);
        map7.put(Value.EIGHT, PlayerAction.HIT);
        map7.put(Value.NINE, PlayerAction.HIT);
        map7.put(Value.TEN, PlayerAction.HIT);
        map7.put(Value.ACE, PlayerAction.HIT);

        map.put(Value.SEVEN, map7);

        HashMap<Value, PlayerAction> map6 = new HashMap<Value, PlayerAction>();
        map6.put(Value.TWO, PlayerAction.SPLIT);
        map6.put(Value.THREE, PlayerAction.SPLIT);
        map6.put(Value.FOUR, PlayerAction.SPLIT);
        map6.put(Value.FIVE, PlayerAction.SPLIT);
        map6.put(Value.SIX, PlayerAction.SPLIT);
        map6.put(Value.SEVEN, PlayerAction.HIT);
        map6.put(Value.EIGHT, PlayerAction.HIT);
        map6.put(Value.NINE, PlayerAction.HIT);
        map6.put(Value.TEN, PlayerAction.HIT);
        map6.put(Value.ACE, PlayerAction.HIT);

        map.put(Value.SIX, map6);

        HashMap<Value, PlayerAction> map5 = new HashMap<Value, PlayerAction>();
        map5.put(Value.TWO, PlayerAction.DOUBLE);
        map5.put(Value.THREE, PlayerAction.DOUBLE);
        map5.put(Value.FOUR, PlayerAction.DOUBLE);
        map5.put(Value.FIVE, PlayerAction.DOUBLE);
        map5.put(Value.SIX, PlayerAction.DOUBLE);
        map5.put(Value.SEVEN, PlayerAction.DOUBLE);
        map5.put(Value.EIGHT, PlayerAction.DOUBLE);
        map5.put(Value.NINE, PlayerAction.DOUBLE);
        map5.put(Value.TEN, PlayerAction.HIT);
        map5.put(Value.ACE, PlayerAction.HIT);

        map.put(Value.FIVE, map5);

        HashMap<Value, PlayerAction> map4 = new HashMap<Value, PlayerAction>();
        map4.put(Value.TWO, PlayerAction.HIT);
        map4.put(Value.THREE, PlayerAction.HIT);
        map4.put(Value.FOUR, PlayerAction.HIT);
        map4.put(Value.FIVE, PlayerAction.SPLIT);
        map4.put(Value.SIX, PlayerAction.SPLIT);
        map4.put(Value.SEVEN, PlayerAction.HIT);
        map4.put(Value.EIGHT, PlayerAction.HIT);
        map4.put(Value.NINE, PlayerAction.HIT);
        map4.put(Value.TEN, PlayerAction.HIT);
        map4.put(Value.ACE, PlayerAction.HIT);

        map.put(Value.FOUR, map4);

        HashMap<Value, PlayerAction> map23 = new HashMap<Value, PlayerAction>();
        map23.put(Value.TWO, PlayerAction.SPLIT);
        map23.put(Value.THREE, PlayerAction.SPLIT);
        map23.put(Value.FOUR, PlayerAction.SPLIT);
        map23.put(Value.FIVE, PlayerAction.SPLIT);
        map23.put(Value.SIX, PlayerAction.SPLIT);
        map23.put(Value.SEVEN, PlayerAction.SPLIT);
        map23.put(Value.EIGHT, PlayerAction.HIT);
        map23.put(Value.NINE, PlayerAction.HIT);
        map23.put(Value.TEN, PlayerAction.HIT);
        map23.put(Value.ACE, PlayerAction.HIT);

        map.put(Value.TWO, map23);
        map.put(Value.THREE, map23);

        return map;
    }

    private static HashMap<Integer, HashMap<Value, PlayerAction>> hardsMap()
    {
        HashMap<Integer, HashMap<Value, PlayerAction>> map = new HashMap<Integer, HashMap<Value, PlayerAction>>();
        HashMap<Value, PlayerAction> map5678 = new HashMap<Value, PlayerAction>();
        map5678.put(Value.TWO, PlayerAction.HIT);
        map5678.put(Value.THREE, PlayerAction.HIT);
        map5678.put(Value.FOUR, PlayerAction.HIT);
        map5678.put(Value.FIVE, PlayerAction.HIT);
        map5678.put(Value.SIX, PlayerAction.HIT);
        map5678.put(Value.SEVEN, PlayerAction.HIT);
        map5678.put(Value.EIGHT, PlayerAction.HIT);
        map5678.put(Value.NINE, PlayerAction.HIT);
        map5678.put(Value.TEN, PlayerAction.HIT);
        map5678.put(Value.ACE, PlayerAction.HIT);

        map.put(5, map5678);
        map.put(6, map5678);
        map.put(7, map5678);
        map.put(8, map5678);

        HashMap<Value, PlayerAction> map9 = new HashMap<Value, PlayerAction>();
        map9.put(Value.TWO, PlayerAction.HIT);
        map9.put(Value.THREE, PlayerAction.DOUBLE);
        map9.put(Value.FOUR, PlayerAction.DOUBLE);
        map9.put(Value.FIVE, PlayerAction.DOUBLE);
        map9.put(Value.SIX, PlayerAction.DOUBLE);
        map9.put(Value.SEVEN, PlayerAction.HIT);
        map9.put(Value.EIGHT, PlayerAction.HIT);
        map9.put(Value.NINE, PlayerAction.HIT);
        map9.put(Value.TEN, PlayerAction.HIT);
        map9.put(Value.ACE, PlayerAction.HIT);

        map.put(9, map9);

        HashMap<Value, PlayerAction> map10 = new HashMap<Value, PlayerAction>();
        map10.put(Value.TWO, PlayerAction.DOUBLE);
        map10.put(Value.THREE, PlayerAction.DOUBLE);
        map10.put(Value.FOUR, PlayerAction.DOUBLE);
        map10.put(Value.FIVE, PlayerAction.DOUBLE);
        map10.put(Value.SIX, PlayerAction.DOUBLE);
        map10.put(Value.SEVEN, PlayerAction.DOUBLE);
        map10.put(Value.EIGHT, PlayerAction.DOUBLE);
        map10.put(Value.NINE, PlayerAction.DOUBLE);
        map10.put(Value.TEN, PlayerAction.HIT);
        map10.put(Value.ACE, PlayerAction.HIT);

        map.put(10, map10);

        HashMap<Value, PlayerAction> map11 = new HashMap<Value, PlayerAction>();
        map11.put(Value.TWO, PlayerAction.DOUBLE);
        map11.put(Value.THREE, PlayerAction.DOUBLE);
        map11.put(Value.FOUR, PlayerAction.DOUBLE);
        map11.put(Value.FIVE, PlayerAction.DOUBLE);
        map11.put(Value.SIX, PlayerAction.DOUBLE);
        map11.put(Value.SEVEN, PlayerAction.DOUBLE);
        map11.put(Value.EIGHT, PlayerAction.DOUBLE);
        map11.put(Value.NINE, PlayerAction.DOUBLE);
        map11.put(Value.TEN, PlayerAction.DOUBLE);
        map11.put(Value.ACE, PlayerAction.HIT);

        map.put(11, map11);

        HashMap<Value, PlayerAction> map12 = new HashMap<Value, PlayerAction>();
        map12.put(Value.TWO, PlayerAction.HIT);
        map12.put(Value.THREE, PlayerAction.HIT);
        map12.put(Value.FOUR, PlayerAction.STAND);
        map12.put(Value.FIVE, PlayerAction.STAND);
        map12.put(Value.SIX, PlayerAction.STAND);
        map12.put(Value.SEVEN, PlayerAction.HIT);
        map12.put(Value.EIGHT, PlayerAction.HIT);
        map12.put(Value.NINE, PlayerAction.HIT);
        map12.put(Value.TEN, PlayerAction.HIT);
        map12.put(Value.ACE, PlayerAction.HIT);

        map.put(12, map12);

        HashMap<Value, PlayerAction> map13141516 = new HashMap<Value, PlayerAction>();
        map13141516.put(Value.TWO, PlayerAction.STAND);
        map13141516.put(Value.THREE, PlayerAction.STAND);
        map13141516.put(Value.FOUR, PlayerAction.STAND);
        map13141516.put(Value.FIVE, PlayerAction.STAND);
        map13141516.put(Value.SIX, PlayerAction.STAND);
        map13141516.put(Value.SEVEN, PlayerAction.HIT);
        map13141516.put(Value.EIGHT, PlayerAction.HIT);
        map13141516.put(Value.NINE, PlayerAction.HIT);
        map13141516.put(Value.TEN, PlayerAction.HIT);
        map13141516.put(Value.ACE, PlayerAction.HIT);

        map.put(13, map13141516);
        map.put(14, map13141516);
        map.put(15, map13141516);
        map.put(16, map13141516);

        HashMap<Value, PlayerAction> map17 = new HashMap<Value, PlayerAction>();
        map17.put(Value.TWO, PlayerAction.STAND);
        map17.put(Value.THREE, PlayerAction.STAND);
        map17.put(Value.FOUR, PlayerAction.STAND);
        map17.put(Value.FIVE, PlayerAction.STAND);
        map17.put(Value.SIX, PlayerAction.STAND);
        map17.put(Value.SEVEN, PlayerAction.STAND);
        map17.put(Value.EIGHT, PlayerAction.STAND);
        map17.put(Value.NINE, PlayerAction.STAND);
        map17.put(Value.TEN, PlayerAction.STAND);
        map17.put(Value.ACE, PlayerAction.STAND);

        map.put(17,  map17);

        return map;
    }

    private static HashMap<Integer, HashMap<Value, PlayerAction>> softsMap()
    {
        HashMap<Integer, HashMap<Value, PlayerAction>> map = new HashMap<Integer, HashMap<Value, PlayerAction>>();

        HashMap<Value, PlayerAction> map1314 = new HashMap<Value, PlayerAction>();
        map1314.put(Value.TWO, PlayerAction.HIT);
        map1314.put(Value.THREE, PlayerAction.HIT);
        map1314.put(Value.FOUR, PlayerAction.HIT);
        map1314.put(Value.FIVE, PlayerAction.DOUBLE);
        map1314.put(Value.SIX, PlayerAction.DOUBLE);
        map1314.put(Value.SEVEN, PlayerAction.HIT);
        map1314.put(Value.EIGHT, PlayerAction.HIT);
        map1314.put(Value.NINE, PlayerAction.HIT);
        map1314.put(Value.TEN, PlayerAction.HIT);
        map1314.put(Value.ACE, PlayerAction.HIT);

        map.put(13, map1314);
        map.put(14, map1314);

        HashMap<Value, PlayerAction> map1516 = new HashMap<Value, PlayerAction>();
        map1516.put(Value.TWO, PlayerAction.HIT);
        map1516.put(Value.THREE, PlayerAction.HIT);
        map1516.put(Value.FOUR, PlayerAction.DOUBLE);
        map1516.put(Value.FIVE, PlayerAction.DOUBLE);
        map1516.put(Value.SIX, PlayerAction.DOUBLE);
        map1516.put(Value.SEVEN, PlayerAction.HIT);
        map1516.put(Value.EIGHT, PlayerAction.HIT);
        map1516.put(Value.NINE, PlayerAction.HIT);
        map1516.put(Value.TEN, PlayerAction.HIT);
        map1516.put(Value.ACE, PlayerAction.HIT);

        map.put(15, map1516);
        map.put(16, map1516);

        HashMap<Value, PlayerAction> map17 = new HashMap<Value, PlayerAction>();
        map17.put(Value.TWO, PlayerAction.HIT);
        map17.put(Value.THREE, PlayerAction.DOUBLE);
        map17.put(Value.FOUR, PlayerAction.DOUBLE);
        map17.put(Value.FIVE, PlayerAction.DOUBLE);
        map17.put(Value.SIX, PlayerAction.DOUBLE);
        map17.put(Value.SEVEN, PlayerAction.HIT);
        map17.put(Value.EIGHT, PlayerAction.HIT);
        map17.put(Value.NINE, PlayerAction.HIT);
        map17.put(Value.TEN, PlayerAction.HIT);
        map17.put(Value.ACE, PlayerAction.HIT);
        map.put(17, map17);

        HashMap<Value, PlayerAction> map18 = new HashMap<Value, PlayerAction>();
        map18.put(Value.TWO, PlayerAction.STAND);
        map18.put(Value.THREE, PlayerAction.DOUBLE);
        map18.put(Value.FOUR, PlayerAction.DOUBLE);
        map18.put(Value.FIVE, PlayerAction.DOUBLE);
        map18.put(Value.SIX, PlayerAction.DOUBLE);
        map18.put(Value.SEVEN, PlayerAction.STAND);
        map18.put(Value.EIGHT, PlayerAction.STAND);
        map18.put(Value.NINE, PlayerAction.HIT);
        map18.put(Value.TEN, PlayerAction.HIT);
        map18.put(Value.ACE, PlayerAction.HIT);

        map.put(18, map18);

        HashMap<Value, PlayerAction> map192021 = new HashMap<Value, PlayerAction>();
        map192021.put(Value.TWO, PlayerAction.STAND);
        map192021.put(Value.THREE, PlayerAction.STAND);
        map192021.put(Value.FOUR, PlayerAction.STAND);
        map192021.put(Value.FIVE, PlayerAction.STAND);
        map192021.put(Value.SIX, PlayerAction.STAND);
        map192021.put(Value.SEVEN, PlayerAction.STAND);
        map192021.put(Value.EIGHT, PlayerAction.STAND);
        map192021.put(Value.NINE, PlayerAction.STAND);
        map192021.put(Value.TEN, PlayerAction.STAND);
        map192021.put(Value.ACE, PlayerAction.STAND);

        map.put(19, map192021);
        map.put(20, map192021);
        map.put(21, map192021);

        return map;
    }


    private static int normalizeValue(int value, boolean soft)
    {
        if (soft && value > 21)
        {
            return 21;
        }
        else if (!soft && value > 17)
        {
            return 17;
        }
        return value;
    }

    public static void logMap(String name, Map map)
    {
        Iterator outer = map.entrySet().iterator();
        while(outer.hasNext())
        {
            Map.Entry pair = (Map.Entry)outer.next();
            Iterator inner = ((Map)pair.getValue()).entrySet().iterator();
            while(inner.hasNext())
            {
                Map.Entry innerpair = (Map.Entry)inner.next();
                logger.log(Level.FINE, String.format("map:%s,key0=%s,key1=%s,value=%s", name, pair.getKey(), innerpair.getKey(), innerpair.getValue()));
            }
        }
    }

    public static void logEverything()
    {
        logMap("pairs", pairs);
        logMap("hards", hards);
        logMap("softs", softs);
    }


    public static PlayerAction bestDecision(Hand playerHand, Value dealerShowingin)
    {
        Value dealerShowing = Card.normalizeValue(dealerShowingin);
        logger.log(Level.FINE, String.format("pairs size = %d, hards size = %d, softs size = %d", pairs.size(), hards.size(), softs.size()));
        if (playerHand.isPair())
        {
            Value playerValue = Card.normalizeValue(playerHand.getCard(0).getValue());
            logger.log(Level.FINE, String.format("playerValue pair %s", playerValue));
            HashMap<Value, PlayerAction> map = pairs.get(playerValue);
            logger.log(Level.FINE, String.format("pair inner map size = %d", map.size()));
            logger.log(Level.FINE, String.format("returning %s", map.get(dealerShowing)));
            return map.get(dealerShowing);
        }
        int softValue = playerHand.softValue();
        int hardValue = playerHand.hardValue();
        boolean soft = (softValue != hardValue && softValue <= 21);
        if (softValue > 21 && hardValue > 21) return PlayerAction.STAND;
        if (soft)
        {
            HashMap<Value, PlayerAction> map = softs.get(normalizeValue(softValue, true));
            logger.log(Level.FINE, String.format("soft inner map size = %d", map.size()));
            logger.log(Level.FINE, String.format("returning %s", map.get(dealerShowing)));
            return map.get(dealerShowing);
        }
        else
        {
            HashMap<Value, PlayerAction> map = hards.get(normalizeValue(hardValue, false));
            logger.log(Level.FINE, String.format("hard inner map size = %d", map.size()));
            logger.log(Level.FINE, String.format("returning %s", map.get(dealerShowing)));
            return map.get(dealerShowing);
        }
    }
}

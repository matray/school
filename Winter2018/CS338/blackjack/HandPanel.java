import java.awt.*;
import javax.swing.*;

public class HandPanel extends JPanel
{
    private JLabel pname;
    //name
    //str + n-cards
    public HandPanel(Hand hand, String name)
    {
        setOpaque(false);
        setLayout(new GridLayout(1, 2));
        int numCards = hand.numberOfCards();
        Tuple<HandValueType, Integer> value = hand.getValue();
        boolean blackjack = hand.isBlackjack();
        String strValue;
        if(blackjack)
        {
            strValue = "Blackjack";
        }
        else if(value.first == HandValueType.SOFT)
        {
            strValue = String.format("Soft %d", value.second);
        }
        else
        {
            strValue = String.format("Hard %d", value.second);
        }
        Font font = new Font("Lucida Grande", Font.BOLD, 20);
        JLabel playerName = new JLabel(name, JLabel.CENTER);
        playerName.setForeground(Color.WHITE);
        playerName.setFont(font);
        JPanel namevalpanel = new JPanel(new GridLayout(2, 1));
        namevalpanel.setOpaque(false);
        namevalpanel.add(playerName);
        pname = playerName;

        JPanel cards = new JPanel(new GridLayout(1, numCards+1));
        cards.setOpaque(false);
        JLabel score = new JLabel(strValue, JLabel.CENTER);
        score.setForeground(Color.WHITE);
        score.setFont(font);
        score.setVerticalAlignment(SwingConstants.CENTER);
        namevalpanel.add(score);
        add(namevalpanel);
        int i = 0;
        for(Card card : hand)
        {
            RatioImagePanel cds = new RatioImagePanel(new CardImage(card));
            cds.setPreferredSize(new Dimension(70, 200));
            cards.add(cds);
            i++;
        }
        add(cards);
    }

    public void playerSelected(boolean selected)
    {
        Color color = selected ? Color.YELLOW : Color.WHITE;
        pname.setForeground(color);
    }
}

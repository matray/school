import java.awt.*;
import javax.swing.*;

public class HandPanel extends JPanel
{
    public HandPanel(Hand hand, int x, int y, int width, int height, int gap)
    {
        int numCards = hand.numberOfCards();
        setBounds(x, y, 35+ numCards * (width + gap), height);
        setLayout(null);
        setOpaque(false);
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
        JLabel score = new JLabel(strValue);
        score.setForeground(Color.WHITE);
        score.setFont(new Font("Lucida Grande", Font.BOLD, 20));
        score.setVerticalAlignment(SwingConstants.CENTER);
        score.setHorizontalAlignment(SwingConstants.RIGHT);
        score.setBounds(0, 0, 30, height);
        add(score);
        int i = 0;
        for(Card card : hand)
        {
            ImagePanel cards = new ImagePanel(new CardImage(card));
            cards.setBounds(35 + i * (width + gap), 0, width, height);
            add(cards);
            i++;
        }

    }
}

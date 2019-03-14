import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class DealerPanel extends JPanel
{
    private int index;
    private Player player;

    //row 1 name
    //row 2 n-hands
    //row 3 money
    public DealerPanel(Player player)
    {
        index = 0;
        this.player = player;
        setLayout(new GridLayout(3, 1));
        setOpaque(false);
        int numHands = player.numHands();
        Font font = new Font("Lucida Grande", Font.BOLD, 20);
        JLabel playerName = new JLabel(player.getName(), JLabel.CENTER);
        playerName.setForeground(Color.WHITE);
        playerName.setFont(font);
        add(playerName);
        int i = 0;
        JPanel hands = new JPanel(new GridLayout(1, numHands));
        hands.setOpaque(false);
        for(Hand hand : player)
        {
            HandPanel hp = new HandPanel(hand, String.format("Hand %d", i+1));
            hp.setBounds(0, 0, getWidth(), getHeight());
            hands.add(hp);
            i++;
        }
        add(hands);
        JLabel br = new JLabel(String.format("$%d.00", player.bankroll()), JLabel.CENTER);
        br.setForeground(Color.WHITE);
        br.setFont(font);
        add(br);
    }
}

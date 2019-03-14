import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ControlsPanel extends JPanel
{
    private GamePanel g;

    private JButton hit;
    private JButton stand;
    private JButton split;
    private JButton doubled;
    private JTextField betvalue;
    private int bet;
    private int index;
    public ControlsPanel(GamePanel g)
    {
        this.g = g;
        index = 0;
        setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder(50, 25, 50, 25));
        setLayout(new GridLayout(3, 2, 50, 50));
        JLabel betlabel = new JLabel("Bet: $");
        add(betlabel);
        betvalue = new JTextField(5);
        betvalue.setBackground(Color.WHITE);
        betvalue.setForeground(Color.BLACK);
        betlabel.setBackground(Color.BLACK);
        betlabel.setForeground(Color.WHITE);
        hit = new JButton("Hit");
        hit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                g.executePlayerAction(PlayerAction.HIT);
            }
        });
        stand = new JButton("Stand");
        stand.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                g.executePlayerAction(PlayerAction.STAND);
            }
        });
        split = new JButton("Split");
        split.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                g.executePlayerAction(PlayerAction.SPLIT);
            }
        });
        doubled = new JButton("Double");
        doubled.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                g.executePlayerAction(PlayerAction.DOUBLE);
            }
        });
        Font font = new Font("Lucida Grande", Font.BOLD, 20);
        betvalue.setFont(font);
        betvalue.setFont(font);
        hit.setFont(font);
        stand.setFont(font);
        split.setFont(font);
        doubled.setFont(font);
        hit.setBackground(Color.BLACK);
        stand.setBackground(Color.BLACK);
        split.setBackground(Color.BLACK);
        doubled.setBackground(Color.BLACK);
        hit.setForeground(Color.WHITE);
        stand.setForeground(Color.WHITE);
        split.setForeground(Color.WHITE);
        doubled.setForeground(Color.WHITE);
        hit.setEnabled(true);
        doubled.setEnabled(true);
        stand.setEnabled(true);
        split.setEnabled(true);
        add(betlabel);
        add(betvalue);
        add(hit);
        add(split);
        add(doubled);
        add(stand);
    }
    public int getBet()
    {
        try
        {
            bet = Integer.parseInt(betvalue.getText());
            return bet;
        }
        catch(NumberFormatException e)
        {
            return g.minimumBet;
        }
    }
    public void resetIndex()
    {
        index = 0;
    }

    public void enableHit()
    {
        hit.setEnabled(true);
    }
    public void disableHit()
    {
        hit.setEnabled(false);
    }
    public void enableDouble()
    {
        doubled.setEnabled(true);
    }
    public void disableDouble()
    {
        doubled.setEnabled(false);
    }
    public void enableSplit()
    {
        split.setEnabled(true);
    }
    public void disableSplit()
    {
        split.setEnabled(false);
    }
    public void enableStand()
    {
        stand.setEnabled(true);
    }
    public void diableStand()
    {
        stand.setEnabled(false);
    }
}

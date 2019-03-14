import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GameManipulationPanel extends JPanel
{
    private GamePanel p;
    public GameManipulationPanel(GamePanel p)
    {
        this.p = p;
        setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder(50, 25, 50, 25));
        setLayout(new GridLayout(2, 2, 50, 50));
        JButton newgame = new JButton("New Game");
        newgame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                p.reset();
            }
        });
        JButton exit = new JButton("Exit");
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                CardLayout cl = (CardLayout)(Blackjack.cards.getLayout());
                cl.show(Blackjack.cards, "MAIN");
            }
        });
        Font font = new Font("Lucida Grande", Font.BOLD, 20);
        newgame.setFont(font);
        exit.setFont(font);
        newgame.setBackground(Color.BLACK);
        exit.setBackground(Color.BLACK);
        newgame.setForeground(Color.WHITE);
        exit.setForeground(Color.WHITE);
        add(newgame);
        add(new JLabel());
        add(exit);
        add(new JLabel());
    }
}

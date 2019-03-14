import javax.swing.*;
import java.awt.*;

public class HelperPanel extends JPanel
{
    private GamePanel g;
    public HelperPanel(GamePanel g)
    {
        this.g = g;
        setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder(50, 25, 50, 25));
        setLayout(new GridLayout(2, 2,50,50));
        JButton hit = new JButton("Test your counting");
        JButton stand = new JButton("Counting hint");
        JButton split = new JButton("Book hint");
        JButton doubled = new JButton("Custom strat hint");
        Font font = new Font("Lucida Grande", Font.BOLD, 20);
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
        add(hit);
        add(split);
        add(doubled);
        add(stand);
    }
}

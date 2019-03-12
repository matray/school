import javax.swing.*;
import java.nio.file.*;
import java.awt.*;
import java.io.*;
import javax.imageio.*;

public class Blackjack extends JFrame
{
    public void TerminatingError(String reason)
    {
        JOptionPane.showMessageDialog(null, reason, "Terminating Error", JOptionPane.ERROR_MESSAGE);
        System.exit(1);
    }

    public Image getImage(String path)
    {
        File checker = new File(path);
        if (!checker.exists())
        {
            TerminatingError(String.format("File %s does not exist", path));
        }
        if(!checker.isFile())
        {
            TerminatingError(String.format("File %s is not a normal file", path));
        }
        Image img;
        try {
            img = ImageIO.read(checker);
        }
        catch(IOException e)
        {
            TerminatingError(e.toString());
            return null;
        }
        return img;
    }

    public Blackjack()
    {
        initUI();
    }

    private void initUI()
    {
        setTitle("Blackjack");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds());
        setResizable(false);
        setIconImage(getImage(Paths.get("resources", "icon.jpg").toString()));
        ImagePanel bgImage = new ImagePanel(getImage(Paths.get("resources", "background.png").toString()));
        bgImage.setBounds(0, 0, this.getWidth(), this.getHeight());
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(() -> {
            Blackjack blackjack = new Blackjack();
            blackjack.setVisible(true);
        });
    }
}

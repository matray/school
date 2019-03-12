import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel
{
    private Image image;

    public ImagePanel(Image image)
    {
        this.image = image;
        Dimension size = new Dimension(image.getWidth(null), image.getHeight(null));
        setSize(size);
        setLayout(null);
    }

    public ImagePanel(CardImage cardImage)
    {
        this(cardImage.getImage());
    }

    public void paintComponent(Graphics g)
    {
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
    }
}

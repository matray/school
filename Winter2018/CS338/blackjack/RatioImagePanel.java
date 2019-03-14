import javax.swing.*;
import java.awt.*;

public class RatioImagePanel extends JPanel
{
    private Image image;

    public RatioImagePanel(Image image)
    {
        this.image = image;
        Dimension size = new Dimension(image.getWidth(null), image.getHeight(null));
        setSize(size);
        setLayout(null);
    }

    public RatioImagePanel(CardImage cardImage)
    {
        this(cardImage.getImage());
    }

    public void paintComponent(Graphics g)
    {
        int height = this.getHeight();
        int width = this.getWidth();
        int imgHeight = image.getHeight(null);
        int imgWidth = image.getWidth(null);
        float ratio = (float)imgHeight/(float)imgWidth;
        float desired = (float)height/(float)width;
        boolean heightLimited = desired > ratio;
        if(heightLimited)
        {
            height = (int)(ratio*width);
        }
        else
        {
            width = (int)((1/ratio)*height);
        }
        g.drawImage(image, 0, 0, width, height, null);
    }
}

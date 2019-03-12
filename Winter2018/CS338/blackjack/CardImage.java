import java.io.*;
import javax.imageio.*;
import java.nio.file.*;
import javax.swing.*;
import java.awt.*;

public class CardImage
{
    public static Path resourceLocation = Paths.get("resources", "cards");
    private Card card;
    private Image image;
    public CardImage(Card card)
    {
        this.card = card;
        File checker = new File(Paths.get(resourceLocation.toString(), card.valueShortString() + card.suitShortString() + ".png").toString());
        if (!checker.exists())
        {
            throw new UnsupportedOperationException("Card image cannot be found");
        }
        if(!checker.isFile())
        {
            throw new UnsupportedOperationException("Card image is not a regular file");
        }
        try
        {
            image = ImageIO.read(checker);
        }
        catch(IOException e)
        {
            image = null;
        }
    }

    public CardImage(Card card, Image image)
    {
        this.card = card;
        this.image = image;
    }

    public Image getImage()
    {
        return image;
    }

    public Card getCard()
    {
        return card;
    }
}

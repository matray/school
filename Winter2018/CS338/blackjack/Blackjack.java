import javax.swing.*;
import java.nio.file.*;
import java.awt.*;
import java.io.*;
import javax.imageio.*;
import java.awt.event.*;
public class Blackjack extends JFrame
{

    private static JButton play;
    private static JButton simulate;
    private static JButton tutorial;
    public static ImagePanel cards;
    public static ImagePanel playpanel;
    public static ImagePanel mainpanel;
    public static Image background;
    public static GamePanel gp;

	private void showTutorial() {
		String longMessage = "<html><h1 style=\"color: #5e9ca0;\">Blackjack</h1><h2 style=\"color: #2e6c80;\">Introduction</h2><p>The goal of blackjack is to beat the house. It is a game that can be played with others, but they are not your opponent. To determine who wins a game of blackjack, you need to be the player closest to 21 without going over. When you have exactly 21, you have \"Blackjack\". Every player (including the dealer) starts out with two cards. You can then choose how to act when it is your turn (explained below).</p><h2 style=\"color: #2e6c80;\">Card Values</h2><p>Cards used for Blackjack include all cards in a normal deck (no jokers). The cards 2 through 10 keep their original value. The cards Jack through King are valued at 10. Aces can be either 1 or 11, depending on the context.</p><h2 style=\"color: #2e6c80;\">Actions</h2><h3>Stand</h3><p>Standing is where you choose to do nothing.</p><h3>Hit</h3><p>Hitting is where you request an additional card to be dealt to your hand.</p><h3>Split</h3><p>Splitting can be done with any hand that has two cards of equal value. Splitting a hand causes it to become two hands, an extra card is dealt to each (to bring it to two cards each) and then you choose how to act.</p><h3>Double</h3><p>Doubling a hand means you think you will get a card (or cards) in future actions that will cause you to win. You double your bet, but you can only do this immediately after you get your initial two cards. Some casinos limit doubling to hands that value 9 through 11.</p><h2 style=\"color: #2e6c80;\">Hard and Soft Hands</h2>A hard hand is when there are no aces in your current hand or the Ace's value is forced to be 1 to prevent you from losing. A soft hand is when there is at least one hand in your current hand and the Ace can be values at 11.<h2 style=\"color: #2e6c80;\">Playing against the dealer</h2>The dealer moves in a very set way. They normally have to stop on 17. This only varies from casino to casino if their hand is a soft 17 (most commonly, they have to hit on a soft 17).<h2 style=\"color: #2e6c80;\">Basic Strategy</h2><p>Basic strategy is the great equalizer in Blackjack. Playing with basic strategy causes you to only be 0.5% less likely to beat the house. Playing anything less rigorous than basic strategy is honestly a waste of time and money. Playing a more advanced strategy is desired to tip the odds in your favor. It is essentially a giant matrix of what to do based on your hand and the dealer's hand.</p><h2 style=\"color: #2e6c80;\">Counting</h2><p>Card counting involves giving cards a value to keep track of trends in the deck. This is especially important later in the game as you can then expect what cards are likely to be dealt. The Hi-Lo strategy involves giving cards 2 through 6 a value of +1 and giving cards 10 (including all face cards valued at 10) through A a value of -1. Keeping a running count of the deck gives you the ability to track it. This causes your decision making to deviate from basic strategy. The most common deviations to remember are the Illustrious 18. These 18 deviations account for 80% of the edge you would get over the house when counting. Memorizing all possible deviations can be too complex even for the most experienced players.</p></html>";
        JEditorPane ep = new JEditorPane();
        ep.setContentType("text/html");
        ep.setText(longMessage);
		ep.setEditable(false);
        ep.setPreferredSize(new Dimension(500, 500));
		JScrollPane scrollPane = new JScrollPane(ep);
		scrollPane.getVerticalScrollBar().setValue(0);
        JOptionPane.showMessageDialog(null, scrollPane);
	}
    public static void TerminatingError(String reason)
    {
        JOptionPane.showMessageDialog(null, reason, "Terminating Error", JOptionPane.ERROR_MESSAGE);
        System.exit(1);
    }

    public static Image getImage(String path)
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
        setIconImage(getImage(Paths.get(".", "resources", "icon.jpg").toString()));
        setBounds(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds());
        background = getImage(Paths.get(".", "resources", "background.png").toString());
        //background.setBounds(0, 0, this.getWidth(), this.getHeight());
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        cards = new ImagePanel(background);
        cards.setBounds(0, 0, this.getWidth(), this.getHeight());
        cards.setLayout(new CardLayout());
        setContentPane(cards);
        mainpanel = new ImagePanel(background);
        mainpanel.setBounds(0, 0, this.getWidth(), this.getHeight());
        mainpanel.setLayout(new GridBagLayout());
        JMenuBar menubar = new JMenuBar();
        JMenu filemenu = new JMenu("File");
        JMenu helpmenu = new JMenu("Help");
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener((event) -> System.exit(0));
        JMenuItem about = new JMenuItem("About");
        about.addActionListener((event) -> JOptionPane.showMessageDialog(this, "Blackjack (c) Matthew Long","About", JOptionPane.INFORMATION_MESSAGE));
        filemenu.add(exit);
        helpmenu.add(about);
        menubar.add(filemenu);
        menubar.add(helpmenu);
        setJMenuBar(menubar);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(25, 25, 25, 25);
        Font font = new Font("Lucida Grande", Font.BOLD, 20);
        play = new JButton("Play");
        play.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                GameConfigurationPopUp popup = new GameConfigurationPopUp();
                while(true)
                {
                    Tuple<GameOptionStatus, String> result = popup.show();
                    if (result.first == GameOptionStatus.CANCEL)
                    {
                        return;
                    }
                    if(result.first == GameOptionStatus.SUCCESS)
                    {
                        break;
                    }
                    if(result.first == GameOptionStatus.FAILED)
                    {
                        JOptionPane.showMessageDialog(null, result.second, "Invalid configuration", JOptionPane.ERROR_MESSAGE);
                    }
                }
                gp.desiredCounterCache = popup.numberOfCountingCPU;
                gp.desiredBasicCache = popup.numberOfBasicStratCPU;
                gp.startingBet = popup.bankroll;
                gp.numberOfDecks = 8;
                gp.minimumBet = popup.minimumBet;
                gp.reset();
                //gp.setBounds(0, 0, this.getWidth(), this.getHeight());
                CardLayout cl = (CardLayout)(Blackjack.cards.getLayout());
                cl.show(Blackjack.cards, "PLAY");
            }
        });
        play.setPreferredSize(new Dimension(200, 100));
        play.setFont(font);
        play.setBackground(Color.BLACK);
        play.setForeground(Color.WHITE);
        simulate = new JButton("Simulate");
        simulate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                SimulateConfigurationPopUp popup = new SimulateConfigurationPopUp();
                while(true)
                {
                    Tuple<GameOptionStatus, String> result = popup.show();
                    if (result.first == GameOptionStatus.CANCEL)
                    {
                        return;
                    }
                    if(result.first == GameOptionStatus.SUCCESS)
                    {
                        break;
                    }
                    if(result.first == GameOptionStatus.FAILED)
                    {
                        JOptionPane.showMessageDialog(null, result.second, "Invalid configuration", JOptionPane.ERROR_MESSAGE);
                    }
                }
                ProgressMonitor pm = new ProgressMonitor(null, "Simulating", String.format("Simulating %d hands", popup.numberOfHands), 0, popup.numberOfHands);
                pm.setProgress(0);
                Simulation simulation = new Simulation(popup.numberOfDecks, popup.startingBet, popup.minimumBet, popup.rules, popup.numberOfHands, popup.strategy, pm);
                //new Thread(simulation).start();
            }
        });
        simulate.setPreferredSize(new Dimension(200, 100));
        simulate.setFont(font);
        simulate.setBackground(Color.BLACK);
        simulate.setForeground(Color.WHITE);
        tutorial = new JButton("Tutorial");
        tutorial.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                showTutorial();
            }
        });
        tutorial.setPreferredSize(new Dimension(200, 100));
        tutorial.setFont(font);
        tutorial.setBackground(Color.BLACK);
        tutorial.setForeground(Color.WHITE);
        mainpanel.add(play, constraints);
        mainpanel.add(simulate, constraints);
        mainpanel.add(tutorial, constraints);
        playpanel = new ImagePanel(background);
        playpanel.setBounds(0, 0, this.getWidth(), this.getHeight());
        gp = new GamePanel();
        gp.setBounds(0, 0, this.getWidth(), this.getHeight());
        playpanel.add(gp, constraints);
        cards.add(mainpanel, "MAIN");
        cards.add(playpanel, "PLAY");
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(() -> {
            Blackjack blackjack = new Blackjack();
            blackjack.setVisible(true);
        });
    }
}

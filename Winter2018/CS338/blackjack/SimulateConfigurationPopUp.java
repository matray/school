import javax.swing.*;

public class SimulateConfigurationPopUp
{
    public int startingBet;
    public int minimumBet;
    public int numberOfHands;
    public int numberOfDecks;
    public String strategy;
    public Rules rules;

    public SimulateConfigurationPopUp()
    {
    }

    public Tuple<GameOptionStatus, String> show()
    {
        JTextField bankrollField = new JTextField(5);
        JTextField minimumBetField = new JTextField(5);
        JTextField numberOfHandsField = new JTextField(5);
        JTextField numberOfDecksField = new JTextField(5);

        JRadioButton yes = new JRadioButton("Yes");
        yes.setSelected(true);
        JRadioButton no = new JRadioButton("No");
        ButtonGroup hitgroup = new ButtonGroup();
        hitgroup.add(yes);
        hitgroup.add(no);

        String[] options = {"Basic Strategy", "Hi-Lo Counting"};
        JComboBox box = new JComboBox(options);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Bankroll: $"));
        panel.add(bankrollField);
        panel.add(Box.createHorizontalStrut(15));
        panel.add(new JLabel("Minimum Bet: $"));
        panel.add(minimumBetField);
        panel.add(Box.createHorizontalStrut(15));
        panel.add(new JLabel("Hit on soft 17: "));
        panel.add(yes);
        panel.add(no);
        panel.add(Box.createHorizontalStrut(15));
        panel.add(new JLabel("Number of decks in a shoe: "));
        panel.add(numberOfDecksField);
        panel.add(Box.createHorizontalStrut(15));
        panel.add(new JLabel("Number of hands to play: "));
        panel.add(numberOfHandsField);
        panel.add(Box.createHorizontalStrut(15));
        box.setSelectedIndex(0);
        panel.add(box);
        int result = JOptionPane.showConfirmDialog(null, panel, "Simulation Configuration", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.CANCEL_OPTION)
        {
            return new Tuple(GameOptionStatus.CANCEL, "");
        }
        try
        {
            startingBet = Integer.parseInt(bankrollField.getText());
        }
        catch(NumberFormatException e)
        {
            return new Tuple(GameOptionStatus.FAILED, "Bankroll must be numeric");
        }
        try
        {
            minimumBet = Integer.parseInt(minimumBetField.getText());
        }
        catch(NumberFormatException e)
        {
            return new Tuple(GameOptionStatus.FAILED, "Minimum bet must be numeric");
        }
        if (!yes.isSelected() && !no.isSelected())
        {
            return new Tuple(GameOptionStatus.FAILED, "Hit on soft 17 must be filled in");
        }
        try
        {
            numberOfHands = Integer.parseInt(numberOfHandsField.getText());
        }
        catch(NumberFormatException e)
        {
            return new Tuple(GameOptionStatus.FAILED, "Number of hands must be numeric");
        }
        try
        {
            numberOfDecks = Integer.parseInt(numberOfDecksField.getText());
        }
        catch(NumberFormatException e)
        {
            return new Tuple(GameOptionStatus.FAILED, "Number of decks must be numeric");
        }
        strategy = options[box.getSelectedIndex()];
        if (strategy == "")
        {
            return new Tuple(GameOptionStatus.FAILED, "Strategy must be selected");
        }
        boolean hitOnSoft17 = yes.isSelected();
        rules = new Rules();
        if(!hitOnSoft17)
        {
            rules.setHitOnSoft17(false);
        }
        return new Tuple(GameOptionStatus.SUCCESS, "");
    }
}

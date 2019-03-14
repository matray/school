import javax.swing.*;

public class GameConfigurationPopUp
{
    public int bankroll;
    public int minimumBet;
    public int numberOfCountingCPU;
    public int numberOfBasicStratCPU;
    public int numberOfDecks;
    public Rules rules;

    public GameConfigurationPopUp()
    {
    }

    public Tuple<GameOptionStatus, String> show()
    {
        JTextField bankrollField = new JTextField(5);
        JTextField minimumBetField = new JTextField(5);
        JTextField numberOfCountingCPUPlayersField = new JTextField(5);
        JTextField numberOfBasicStratCPUPlayersField = new JTextField(5);
        JRadioButton yes = new JRadioButton("Yes");
        yes.setSelected(true);
        JRadioButton no = new JRadioButton("No");
        ButtonGroup hitgroup = new ButtonGroup();
        hitgroup.add(yes);
        hitgroup.add(no);
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
        panel.add(new JLabel("Number of Counting CPU Players: "));
        panel.add(numberOfCountingCPUPlayersField);
        panel.add(new JLabel("Number of Basic Strategy CPU Players: "));
        panel.add(numberOfBasicStratCPUPlayersField);
        int result = JOptionPane.showConfirmDialog(null, panel, "Configuration", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.CANCEL_OPTION)
        {
            return new Tuple(GameOptionStatus.CANCEL, "");
        }
        try
        {
            numberOfCountingCPU = Integer.parseInt(numberOfCountingCPUPlayersField.getText());
        }
        catch(NumberFormatException e)
        {
            return new Tuple(GameOptionStatus.FAILED, "Number of counting CPU players must be numeric");
        }
        try
        {
            numberOfBasicStratCPU = Integer.parseInt(numberOfBasicStratCPUPlayersField.getText());
        }
        catch(NumberFormatException e)
        {
            return new Tuple(GameOptionStatus.FAILED, "Number of basic strategy CPU players must be numeric");
        }
        if(numberOfCountingCPU + numberOfBasicStratCPU > 4)
        {
            return new Tuple(GameOptionStatus.FAILED, "Only a maximum of 4 CPU Players supported");
        }
        try
        {
            bankroll = Integer.parseInt(bankrollField.getText());
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
        boolean hitOnSoft17 = yes.isSelected();
        rules = new Rules();
        if(!hitOnSoft17)
        {
            rules.setHitOnSoft17(false);
        }
        return new Tuple(GameOptionStatus.SUCCESS, "");
    }
}

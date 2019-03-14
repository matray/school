import javax.swing.*;

public class Simulation
{
	private int numberOfHands;
	private int startingBet;
	private int minimumBet;
	private int numberOfDecks;
	private Rules rules;
	private String strategy;
	private ProgressMonitor pm;
    private SimulationRunner runner;
    private Table table;
    public Simulation(int numberOfDecks, int startingBet, int minimumBet, Rules rules, int numberOfHands, String strategy, ProgressMonitor pm)
    {
		this.numberOfHands = numberOfHands;
		this.startingBet = startingBet;
		this.minimumBet = minimumBet;
		this.rules = rules;
		this.numberOfDecks = numberOfDecks;
		this.strategy = strategy;
		this.pm = pm;
        runner = new SimulationRunner();
        runner.execute();
	}

    private class SimulationRunner extends SwingWorker<Boolean, Integer>
    {
        public SimulationRunner()
        {
        }
        @Override
        protected void done()
        {
            JOptionPane.showMessageDialog(null, String.format("Finished running simulation, profit seen: $%d", table.getPlayerBankroll(0)), "Simulation Results", JOptionPane.INFORMATION_MESSAGE);
        }

        @Override
        public Boolean doInBackground()
        {
            int penetration = 290;
            DealerObserver dealerObserver = new DealerObserver();
            Shoe shoe = new Shoe(penetration, numberOfDecks);
            House house = new House(rules, dealerObserver);
            table = new Table(shoe, house, minimumBet, dealerObserver);
            ShoeObserver observer;
            if(strategy == "Basic Strategy")
            {
                observer = new BasicStrategyObserver(minimumBet);
            }
            else
            {
                observer = new BasicCounterObserver(minimumBet);
            }
            shoe.addObserver(observer);
            CPUPlayer cpu = new CPUPlayer("CPU", rules, startingBet, dealerObserver);
            cpu.setShoeObserver(observer);
            table.addPlayer(cpu);
            table.setNumberOfHands(numberOfHands);
            table.setProgressMonitor(pm);
            table.play();
            return true;
        }
    }
}

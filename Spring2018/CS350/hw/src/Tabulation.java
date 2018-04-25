import java.util.ArrayList;

public abstract class Tabulation {
    private ArrayList<Form> userInputs;
    Tabulation(ArrayList<Form> userInputs){
        this.userInputs = userInputs;
    }
    public abstract void collect();
    public abstract void printStatistics();
}

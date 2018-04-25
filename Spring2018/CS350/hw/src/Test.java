import java.util.ArrayList;

public class Test extends Survey {
    Test(ArrayList<Question> questionContainer){
        super(questionContainer);
    }

    Test(ArrayList<Question> questionContainer, String message){
        super(questionContainer, message);
    }

    public double grade(){
        return 100;
    }
}

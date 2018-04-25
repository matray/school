import java.util.ArrayList;

public class Form {
    ArrayList<Question> questionContainer;
    boolean finished = false;
    public ArrayList<Question> getQuestionContainer() {
        return questionContainer;
    }
    public void setQuestionContainer(ArrayList<Question> questionContainer) {
        this.questionContainer = questionContainer;
    }
    Form(){
        //empty
    }
    Form(ArrayList<Question> questionContainer){
        this.questionContainer = questionContainer;
    }
    public void save(String fileName){
        // to be implemented
    }
    public void load(String filename){
        // to be implemented
    }
    public void askQuestions(){
        for(Question question : questionContainer){
            question.ask();
        }
        finished = true;
    }
    public boolean isFinished(){
        return finished;
    }
}

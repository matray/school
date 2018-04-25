import java.util.ArrayList;

public class Survey extends Form {
    private String message;

    Survey(ArrayList<Question> questionContainer){
        super(questionContainer);
    }

    Survey(ArrayList<Question> questionContainer, String message){
        super(questionContainer);
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void save(String filename) {
        // not implemented
    }

    public void load(String filename){
        //not implemented
    }
}

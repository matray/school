public class HasCorrectAnswerQuestion extends Question {
    private String correctResponse;
    HasCorrectAnswerQuestion(){
        //empty
    }
    HasCorrectAnswerQuestion(String prompt, String correctResponse){
        super(prompt);
        this.correctResponse = correctResponse;
    }
    public boolean check(){
        return response.equals(correctResponse);
    }
}

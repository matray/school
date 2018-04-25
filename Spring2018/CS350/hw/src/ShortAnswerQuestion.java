public class ShortAnswerQuestion extends EssayQuestion {
    protected static String questionPrompt = "Respond in short answer form.\n";
    protected boolean isInputValid(){
        return response.length() < 100;
    }

    public void ask(){
        prompt();
        acceptResponse();
        if(!isInputValid()){
            throw new RuntimeException("Question was not answered appropriately");
        }
    }
}

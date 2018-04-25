import java.util.ArrayList;

public class MultipleChoiceQuestion extends CanValidateAnswerQuestion {
    protected static String questionPrompt = "Respond with one of the valid inputs listed at the prompt\n";
    private static ArrayList<String> validResponses = new ArrayList<String>(){{add("a");add("b");add("c"); add("d");}};
}

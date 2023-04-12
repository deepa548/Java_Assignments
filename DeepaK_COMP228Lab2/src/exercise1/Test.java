package exercise1;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class Test {
    String q1 = """
            What datatype can double be promoted to?
            (a) None
            (b) int
            (c) string
            (d) float""";
    String q2 = """
            What is collection of related objects called?
            (a) Class
            (b) Field
            (c) Method
            (d) Constructor""";
    String q3 = """
            Which of the following methods can be accessed without creating objects?
            (a) static
            (b) overloaded
            (c) non-static
            (d) Overriding""";
    String q4 = """
            Which of the following is not a modifier type?
            (a) Public
            (b) Private
            (c) Protected
            (d) Semi-protected""";
    String q5 = """
            What does an instance variable describe of an object?
            (a) Behaviour
            (b) Height
            (c) Measurement
            (d) Properties""";
    Question[] questions = {new Question(q1, "a"), new Question(q2, "a"), new Question(q3, "a"),
            new Question(q4, "d"), new Question(q5, "d")};

    public void simulateQuestion() {
        String answer;
        Boolean result;
        int score = 0;
        JFrame frame = new JFrame("Test Result!");

        for (Question question : questions) {
            answer = JOptionPane.showInputDialog(question.promptQ);
            result = checkAnswer(answer);
            String message = generateMessage(result);
            if(result) {
                score ++;
                JOptionPane.showMessageDialog(frame, message + " Your Score is : " + score);
            }else {
                JOptionPane.showMessageDialog(frame, message + " Your Score is : " + score);
            }
        }

        int percentage = (score * 100)  / 5;
        JOptionPane.showMessageDialog(frame, " Your Total Score is : " + score+"/5 \n" +
                "Your Percentage of Correct Answers is : " + percentage);
    }

    public boolean checkAnswer(String answer) {
        boolean result = Boolean.FALSE;
        for (Question question : questions) {
            if (answer.equals(question.answer)) {
                result = Boolean.TRUE;
            }
        }
        return result;
    }

    public String generateMessage( boolean answer) {
        Random rand = new Random();
        int randomNumber = rand.nextInt(4);
        if (answer) {
            return switch (randomNumber) {
                case 0 -> "Good!";
                case 1 -> "Keep up the good work!";
                case 2 -> "Excellent";
                case 3 -> "Nice work!";
                default -> "Wrong Choice";
            };
        } else {
            return switch (randomNumber) {
                case 0 -> "Wrong, try once more";
                case 1 -> "No, please try again";
                case 2 -> "Don't give up";
                case 3 -> "No, keep trying..!";
                default -> "Wrong Choice";
            };
        }
    }



}

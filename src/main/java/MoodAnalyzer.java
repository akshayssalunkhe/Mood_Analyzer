import java.util.Objects;

public class MoodAnalyzer {
    //DECLARING FIELD
    String message = "";

    //DEFAULT CONSTRUCTOR
    public MoodAnalyzer() {
    }

    //PARAMETRISED CONSTRUCTOR
    public MoodAnalyzer(String message) {
        this.message = message;
    }

    //MAIN METHOD
    public static void main(String[] args) {
        System.out.println("Welcome To Mood Analyzer Problem");
    }

    //PARAMETRISED METHOD
    public String analyzeMood(String message) throws MoodAnalysisException {
        this.message = message;
        return analyzeMood();
    }

    //METHOD TO ANALYZE MESSAGE
    public String analyzeMood() throws MoodAnalysisException {
        try {
            if (message.length() == 0)
                throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.EMPTY, "Please Enter Valid Mood ");
            if (message.contains("Sad")) {
                return "SAD";
            } else {
                return "HAPPY";
            }
        } catch (NullPointerException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NULL, "Please Enter Valid Mood");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoodAnalyzer that = (MoodAnalyzer) o;
        return Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message);
    }
}
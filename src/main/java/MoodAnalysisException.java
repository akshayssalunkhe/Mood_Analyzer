//CREATED CUSTOMISED EXCEPTION
public class MoodAnalysisException extends Exception {
    enum ExceptionType {
        EMPTY, NULL;
    }

    ExceptionType type;

    //CONSTRUCTOR
    public MoodAnalysisException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }
}

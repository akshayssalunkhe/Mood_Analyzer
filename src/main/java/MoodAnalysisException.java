//CREATED CUSTOMISED EXCEPTION
public class MoodAnalysisException extends Exception {
    enum ExceptionType {
        EMPTY, NULL, NO_SUCH_CLASS_FOUND, NO_SUCH_METHOD_FOUND, NO_SUCH_FIELD_FOUND;
    }

    ExceptionType type;

    //CONSTRUCTOR
    public MoodAnalysisException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }
}
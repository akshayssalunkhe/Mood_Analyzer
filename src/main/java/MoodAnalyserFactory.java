import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {
    //METHOD TO CREATE OBJECT
    public static Object createMoodAnalyser(Constructor<?> constructor, Object... message) {
        try {
            return constructor.newInstance(message);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    //METHOD TO GET CONSTRUCTOR
    public static Constructor<?> getConstructor(String className, Class<?>... param) throws MoodAnalysisException {
        try {
            Class<?> moodAnalyserClass = Class.forName(className);
            return moodAnalyserClass.getConstructor(param);
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS_FOUND, "Class Not Found");
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD_FOUND, "No Such Method");
        }
    }

    //METHOD TO INVOKE CLASS METHOD
    public static Object invokeMethod(Object result, String analyzeMood) throws MoodAnalysisException {
        try {
            return result.getClass().getMethod(analyzeMood).invoke(result);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD_FOUND, "No Such Method");
        }
        return null;
    }

    public static void setFieldValue(Object result, String fieldName, String fieldValue) throws MoodAnalysisException {
        try {
            if (fieldValue == null) {
                throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NULL, "Field Value Is Null");
            }
            Field field = result.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(result, fieldValue);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_FIELD_FOUND, "No Such Field");
        }
    }
}
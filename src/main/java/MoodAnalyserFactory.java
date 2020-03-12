import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {
    public static MoodAnalyzer createMoodAnalyser() {
        try {
            Class<?> moodAnalyzerClass = Class.forName("MoodAnalyzer");
            Constructor<?> moodAnalyserConstructor = moodAnalyzerClass.getConstructor(String.class);
            Object instance = moodAnalyserConstructor.newInstance();
            return (MoodAnalyzer) instance;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;

public class MoodAnalyzerTest {
    @Test
    public void givenMessage_WhenSad_ThenReturnSad() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am in Sad Mood");
        String mood = null;
        try {
            mood = moodAnalyzer.analyzeMood();
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("SAD", mood);
    }

    @Test
    public void givenMessage_WhenNotSad_ThenReturnHappy() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am in Happy Mood");
        String mood = null;
        try {
            mood = moodAnalyzer.analyzeMood();
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("HAPPY", mood);
    }

    @Test
    public void givenMessage_WhenInputIsNull_ThenThrowException() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        try {
            moodAnalyzer.analyzeMood(null);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NULL, e.type);
        }
    }

    @Test
    public void givenMessage_WhenInputIsEmpty_ThenThrowException() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        try {
            moodAnalyzer.analyzeMood("");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.EMPTY, e.type);
        }
    }

    @Test
    public void givenMoodAnalyserClass_WhenProper_ShouldReturnObject() {
        try {
            MoodAnalyzer moodAnalyzer1 = new MoodAnalyzer();
            Constructor<?> constructor = MoodAnalyserFactory.getConstructor("MoodAnalyzer");
            Object result = MoodAnalyserFactory.createMoodAnalyser(constructor);
            Assert.assertEquals(moodAnalyzer1, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMethodName_WhenImproper_ShouldThrowException() {
        try {
            MoodAnalyserFactory.getConstructor("MoodAnalyzer", Integer.class);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD_FOUND, e.type);
        }
    }

    @Test
    public void givenClassName_WhenImproper_ShouldThrowException() {
        try {
            MoodAnalyserFactory.getConstructor("MoodAnalyser", String.class);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS_FOUND, e.type);
        }
    }

    @Test
    public void givenMoodAnalyserClass_WhenProper_ThenReturnObjectForParameter() {
        try {
            MoodAnalyzer moodAnalyzer1 = new MoodAnalyzer("I am in Happy Mood");
            Constructor<?> constructor = MoodAnalyserFactory.getConstructor("MoodAnalyzer", String.class);
            Object result = MoodAnalyserFactory.createMoodAnalyser(constructor, "I am in Happy Mood");
            Assert.assertEquals(moodAnalyzer1, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMethodName_WhenImproper_ShouldThrowExceptionForParameter() {
        try {
            Constructor<?> constructor = MoodAnalyserFactory.getConstructor("MoodAnalyzer", Integer.class);
            ;
            MoodAnalyserFactory.createMoodAnalyser(constructor, "I am in Happy Mood");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD_FOUND, e.type);
        }
    }

    @Test
    public void givenClassName_WhenImproper_ShouldThrowExceptionForParameter() {
        try {
            Constructor<?> constructor = MoodAnalyserFactory.getConstructor("MoodAnalyzer", String.class);
            MoodAnalyserFactory.createMoodAnalyser(constructor, "I am in happy mood");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS_FOUND, e.type);
        }
    }

    @Test
    public void givenHappyMessage_WhenProper_ShouldReturnHappyMood() {
        try {
            Constructor<?> constructor = MoodAnalyserFactory.getConstructor("MoodAnalyzer", String.class);
            Object result = MoodAnalyserFactory.createMoodAnalyser(constructor, "I am in happy mood");
            Object mood = MoodAnalyserFactory.invokeMethod(result, "analyzeMood");
            Assert.assertEquals("HAPPY", mood);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenHappyMessage_WhenImproper_ShouldThrowException() {
        try {
            Constructor<?> constructor = MoodAnalyserFactory.getConstructor("MoodAnalyzer", String.class);
            Object result = MoodAnalyserFactory.createMoodAnalyser(constructor, "I am in happy mood");
            MoodAnalyserFactory.invokeMethod(result, "analyzeMod");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD_FOUND, e.type);
        }
    }
}
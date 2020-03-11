import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {
    @Test
    public void giveMessage_WhenSad_ThenReturnSad() {
        MoodAnalyzer moodAnalyzer=new MoodAnalyzer("I am in Sad Mood");
        String mood = null;
        try {
            mood = moodAnalyzer.analyzeMood();
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("SAD",mood);
    }

    @Test
    public void giveMessage_WhenNotSad_ThenReturnHappy() {
        MoodAnalyzer moodAnalyzer=new MoodAnalyzer("I am in Happy Mood");
        String mood = null;
        try {
            mood = moodAnalyzer.analyzeMood();
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("HAPPY",mood);
    }

    @Test
    public void giveMessage_WhenInputIsNull_ThenThrowException() {
        MoodAnalyzer moodAnalyzer=new MoodAnalyzer();
        try{
            moodAnalyzer.analyzeMood(null);
        }catch ( MoodAnalysisException e ){
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NULL,e.type);
        }
    }

    @Test
    public void giveMessage_WhenInputIsEmpty_ThenThrowException() {
        MoodAnalyzer moodAnalyzer=new MoodAnalyzer();
        try{
            moodAnalyzer.analyzeMood("");
        }catch ( MoodAnalysisException e ){
            Assert.assertEquals(MoodAnalysisException.ExceptionType.EMPTY,e.type);
        }
    }
}
import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {
    //TEST CASE TO CHECK SAD MOOD
    @Test
    public void giveMessage_WhenSad_ThenReturnSad() {
        MoodAnalyzer moodAnalyzer=new MoodAnalyzer("I am in Sad Mood");
        String mood = moodAnalyzer.analyzeMood();
        Assert.assertEquals("SAD",mood);
    }

    //TEST CASE TO CHECK ANY MOOD
    @Test
    public void giveMessage_WhenNotSad_ThenReturnHappy() {
        MoodAnalyzer moodAnalyzer=new MoodAnalyzer("I am in Happy Mood");
        String mood = moodAnalyzer.analyzeMood();
        Assert.assertEquals("HAPPY",mood);
    }
}
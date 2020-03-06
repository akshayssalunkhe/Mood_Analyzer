import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {
    //CREATED OBJECT OF MOOD ANALYZER CLASS
    MoodAnalyzer moodAnalyzer=new MoodAnalyzer();

    //TEST CASE TO CHECK SAD MOOD
    @Test
    public void giveMessage_WhenSad_ThenReturnSad() {
        String mood = moodAnalyzer.analyzeMood("i am in Sad Mood");
        Assert.assertEquals("SAD",mood);
    }

    //TEST CASE TO CHECK ANY MOOD
    @Test
    public void giveMessage_WhenNotSad_ThenReturnHappy() {
        String mood = moodAnalyzer.analyzeMood("i am in Any Mood");
        Assert.assertEquals("HAPPY",mood);
    }
}
public class MoodAnalyzer {
    public static void main(String[] args) {
        System.out.println("Welcome To Mood Analyzer Problem");
    }

    //METHOD TO ANALYZE MESSAGE
    public String analyzeMood(String message) {
        if (message.contains("Sad")) {
            return "SAD";
        } else {
            return "HAPPY";
        }
    }
}
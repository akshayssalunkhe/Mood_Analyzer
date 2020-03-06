public class MoodAnalyzer {
   //DECLARING FIELDS
    String message="";

    //DEFAULT CONSTRUCTOR
    public MoodAnalyzer() {
   }

   //PARAMETRISED CONSTRUCTOR
   public MoodAnalyzer(String message) {
        this.message=message;
    }

    //MAIN METHOD
    public static void main(String[] args) {
        System.out.println("Welcome To Mood Analyzer Problem");
    }

    //METHOD TO ANALYZE MESSAGE
    public String analyzeMood() {
        if (message.contains("Sad")) {
            return "SAD";
        } else {
            return "HAPPY";
        }
    }
}
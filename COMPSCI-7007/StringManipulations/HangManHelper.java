package StringManipulations;

public class HangManHelper {

    public static String helper(String text, String seq) {
        String originalText = text.replaceAll(".", "_");
        StringBuilder stringBuilderText = new StringBuilder(originalText);
        for (int i = 0; i <= text.length() - 1; i++) {
            for (int j = 0; j <= seq.length() - 1; j++) {
                if (text.charAt(i) == seq.charAt(j)) {
                    stringBuilderText.setCharAt(i, text.charAt(i));
                }
            }
        }
        return stringBuilderText.toString();
    }

    public static void main(String[] args) {
        String text = "ALONGEREXAMPLE";
        String seq = "SOMETHING";
        String result = helper(text, seq);
        System.out.println("Result :" + result);
    }
}

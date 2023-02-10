public class StringCompression {
    /**
     * Chapter 1: Array and Strings
     * Interview Questions: 1.6
     */

    public static String compress(String text) {
        int count = 1;
        StringBuilder stringBuilder = new StringBuilder("");
        char currChar = text.charAt(0);
        for (int i = 1; i < text.length(); i++) {
            if (text.charAt(i) != currChar) {
                stringBuilder.append(currChar);
                stringBuilder.append(count);
                if (stringBuilder.toString().length() > text.length()) {
                    return text;
                }
                currChar = text.charAt(i);
                count = 1;
            } else {
                count++;
            }
        }
        stringBuilder.append(currChar);
        stringBuilder.append(count);
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(compress("aabccccaaa"));
    }
}

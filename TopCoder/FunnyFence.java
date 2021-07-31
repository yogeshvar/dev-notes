public class FunnyFence {
    public static int getLength(String s) {
        int maxLength = -1;
        int length = 1;
        for (int i = 1; i <= s.length(); i++) {
            if (i < s.length() && s.charAt(i) != s.charAt(i - 1)) {
                length++;
            } else {
                maxLength = Math.max(maxLength, length);
                length = 1;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String input = "|-||-|-";
        int result = getLength(input);
        System.out.println("Result :" + result);
    }
}

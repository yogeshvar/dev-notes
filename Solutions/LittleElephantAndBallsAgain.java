public class LittleElephantAndBallsAgain {

    public static int getNumber(String s) {
        char last = ' ';
        int ans = 0;
        int seq = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (last == c) {
                ans++;
            } else {
                ans = 0;
            }
            last = c;
            seq = Math.max(seq, ans);
        }
        return s.length() - seq - 1;
    }

    public static void main(String[] args) {
        System.out.println(getNumber("RGBRBRGRGRBBBGRBRBRGBGBBBGRGBBBBRGBGRRGGRRRGRBBBBR"));
    }
}

import java.util.Arrays;

class CompletelyDifferentStringChallenge {
    public int count(int S, String[] forbidden) {
        int ans = 1;
        int n = forbidden[0].length();
        for (int i = 0; i < n; i++) {
            boolean[] here = new boolean[S];
            for (String s : forbidden)
                here[s.charAt(i) - 'a'] = true;
            int cnt = 0;
            System.out.println("" + Arrays.toString(here));
            for (int j = 0; j < S; j++)
                if (!here[j])
                    cnt++;
            ans *= cnt;
        }
        return ans;
    }

}

public class CompletelyDifferentString {
    public static void main(String[] args) {
        CompletelyDifferentStringChallenge challenge = new CompletelyDifferentStringChallenge();
        int S = 3;
        String[] forbidden = { "ab" };
        int result = challenge.count(S, forbidden);
        System.out.println("Result :" + result);
    }
}

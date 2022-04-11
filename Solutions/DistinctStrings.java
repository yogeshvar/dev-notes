
// Not Solved.
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class DistinctStrings {

    static Set<String> s = new HashSet<String>();

    public static String[] generateRecursive(int L, String letters, int N) {
        if (s.size() >= N) {
            return s.stream().limit(N).toArray(String[]::new);
        } else {
            for (int i = 1; i < L; i++) {
                s.add(letters.charAt(0) + letters.substring(i));
            }
            StringBuilder sb = new StringBuilder(letters);
            if (letters.length() == N) {
                generateRecursive(L, letters, N);
            } else {
                sb.deleteCharAt(0);
                generateRecursive(L, sb.toString(), N);
            }
        }
        return s.stream().limit(N).toArray(String[]::new);
    }

    public static String[] generate(int L, String letters, int N) {
        String[] r = new String[N];
        Set<String> s = new HashSet<String>();
        Random ran = new Random();
        int len = letters.length();
        while (s.size() < N) {
            StringBuilder z = new StringBuilder();
            while (z.length() < L) {
                z.append(letters.charAt(ran.nextInt(len)));
            }
            s.add(z.toString());
        }
        int i = 0;
        for (String x : s) {
            r[i++] = x;
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(generate(5, "qwertyuiopasdfghjklzxcvbnm", 10)));
        System.out.println(Arrays.toString(generateRecursive(5, "abcde", 10)));
    }
}

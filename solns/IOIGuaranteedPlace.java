import java.util.Arrays;

class IOIChallenge {
    public int[] solve(int N, int[] day1scores, int[] day2scores) {
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            int curr = day1scores[i] + day2scores[i];
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (day1scores[j] + 300 > curr) {
                    count++;
                }
            }
            result[i] = count;
        }
        return result;
    }
}

public class IOIGuaranteedPlace {
    public static void main(String[] args) {
        int[] day1scores = { 0, 300, 0, 0 };
        int[] day2scores = { 0, 0, 0, 0 };
        IOIChallenge ioiChallenge = new IOIChallenge();
        int[] result = ioiChallenge.solve(4, day1scores, day2scores);
        System.out.println("Result " + Arrays.toString(result));
    }
}

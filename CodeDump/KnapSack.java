class KnapStackClass {
    static int max(int a, int b) {
        return Math.max(a, b);
    }

    public int getResult(int[] values, int[] weights, int capacity, int n) {
        int[][] K = new int[n + 1][capacity + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (i == 0 || j == 0)
                    K[i][j] = 0;
                else if (weights[i - 1] <= j) {
                    K[i][j] = max(values[i - 1] + K[i - 1][j - weights[i - 1]], K[i - 1][j]);
                } else {
                    K[i][j] = K[i - 1][j];
                }
            }

        }
        return K[n][capacity];
    }
}

public class KnapSack {
    public static void main(String[] args) {
        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = val.length;
        KnapStackClass knapStackClass = new KnapStackClass();
        int result = knapStackClass.getResult(val, wt, W, n);
        System.out.println("Result : " + result);

    }
}

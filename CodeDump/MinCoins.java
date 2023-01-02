import java.util.Arrays;

class MinCoins {
    public static int minCoins(int coins[], int m, int V) {
        int table[] = new int[V + 1];
        table[0] = 0;
        for (int i = 1; i < V; i++)
            table[i] = Integer.MAX_VALUE;

        for (int i = 1; i < V; i++) {
            table[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= V; i++) {
            for (int j = 0; j < m; j++)
                if (coins[j] <= i) {
                    int sub_res = table[i - coins[j]];
                    if (sub_res != Integer.MAX_VALUE
                            && sub_res + 1 < table[i])
                        table[i] = sub_res + 1;

                }

        }

        if (table[V] == Integer.MAX_VALUE)
            return -1;

        System.out.println(Arrays.toString(table));

        return table[V];
    }

    public static void main(String[] args) {
        int coins[] = { 9, 6, 5, 1 };
        int m = coins.length;
        int V = 11;
        System.out.println("Minimum coins required is "
                + minCoins(coins, m, V));
    }
}
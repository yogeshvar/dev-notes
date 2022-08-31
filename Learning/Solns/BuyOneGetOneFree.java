
// 90% Success Rate.
import java.util.Arrays;

class BuyOneGetOneChallenge {
    public int buy(int[] prices) {
        Arrays.sort(prices);
        int sum = 0;
        boolean isOdd = prices.length % 2 == 0 ? false : true;
        if (isOdd) {
            for (int i = 0; i < prices.length; i = i + 2) {
                sum += prices[i];
            }
        } else {
            for (int i = prices.length / 2; i < prices.length; i++) {
                sum += prices[i];
            }
        }
        return sum;
    }
}

public class BuyOneGetOneFree {
    public static void main(String[] args) {
        BuyOneGetOneChallenge challenge = new BuyOneGetOneChallenge();
        int[] prices = { 100, 100, 100, 100, 100, 100 };
        int result = challenge.buy(prices);
        System.out.println("Result " + result);
    }
}

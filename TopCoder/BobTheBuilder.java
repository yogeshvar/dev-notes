
// Not Solved.
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class BobTheBuilder {

    public static HashSet<Integer> primeFactors(int n) {
        HashSet<Integer> h = new HashSet<>();
        while (n % 2 == 0) {
            h.add(2);
            n /= 2;
        }

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                h.add(i);
                n /= i;
            }
        }
        if (n > 2)
            h.add(n);

        return h;
    }

    public static boolean split(int num, int parts) {
        ArrayList<Integer> splitParts = new ArrayList<>();
        if (num < parts) {
            System.out.println(-1);
        } else if (num % parts == 0) {
            for (int i = 0; i < num; i++) {
                splitParts.add(num / parts);
            }
        } else {
            int zp = num - (parts % num);
            int pp = num / parts;
            for (int i = 0; i < num; i++) {
                if (i >= zp) {
                    splitParts.add(pp + 1);
                } else {
                    splitParts.add(pp);
                }
            }
        }
        return new HashSet<Integer>(splitParts).size() <= 1;
    }

    /**
     * 
     * @param B - Tower height
     * @param K - Bricks package for one dollar
     * @param H - Target Height
     * @return - Min. K packs.
     * 
     * @apiNote: Method 1: if tower height is greater than target height. - equal
     *           parts => B / B % K Method 2: Factorization of B.
     */
    public static int minimumPrice(int B, int K, int H) {
        HashSet<Integer> factors = primeFactors(B);
        Iterator<Integer> factor = factors.iterator();
        while (factor.hasNext()) {
            boolean isEqualParts = split(K, factor.next());
            System.out.println(isEqualParts);
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(minimumPrice(65, 5, 6));
    }
}

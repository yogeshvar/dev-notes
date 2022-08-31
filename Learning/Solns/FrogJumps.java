public class FrogJumps {
    public static int canMeet(long x1, long y1, long x2, long y2, long k1, long k2) {
        long dx = Math.abs(x2 - x1);
        long dy = Math.abs(y2 - y1);
        long k = gcd(k1, k2);
        return dx % k == 0 && dy % k == 0 ? 1 : 0;
    }

    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        long x1 = 10, y1 = 10, x2 = 18, y2 = 13, k1 = 3, k2 = 4;
        System.out.println("" + canMeet(x1, y1, x2, y2, k1, k2));
    }
}

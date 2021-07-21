package udemyCourse;

public class SumDigits {
    public static void main(String[] args) {
        int result = sumDigits(1452);
        System.out.println(result);
    }

    public static int sumDigits(int n) {
        if (n == 0) {
            return 0;
        }
        return n % 10 + sumDigits(n / 10);
    }
}

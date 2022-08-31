
public class Fibonacci {
    public static void main(String[] args) {
        int result = fibonacci(9);
        System.out.println(result);
    }

    public static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}

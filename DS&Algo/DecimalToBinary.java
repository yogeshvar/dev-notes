package udemyCourse;

class Factorial {
    public static void main(String[] args) {
        int result = DecimalToBinary(13);
        System.out.println(result);
    }

    public static int DecimalToBinary(int n) {
        if (n == 0) {
            return 0;
        } else {
            return n % 2 + 10 * DecimalToBinary(n / 2);
        }
    }

}

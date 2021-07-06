package udemyCourse;

class Factorial {
    public static void main(String[] args) {
        int result = factorial(3);
        System.out.println(result);
    }

    public static int factorial(int n) {
        if (n == 1 || n == 0) {
            return 1;
        } else if (n < 1) {
            return -1;
        } else {
            return n * factorial(n - 1);
        }
    }

}

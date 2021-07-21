package udemyCourse;

public class RecursiveRange {
    public static void main(String[] args) {
        int result = rangeSum(10);
        System.out.println(result);
    }

    public static int rangeSum(int range) {
        if (range == 0) {
            return 0;
        }
        return range + rangeSum(range - 1);
    }
}

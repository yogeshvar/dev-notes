package Arrays.MAANG;

public class DiagonalSum {
    public static void main(String[] args) {
        int[][] arr = { { 1, 2 }, { 3, 4 } };
        sumDiagonal(arr);
    }   

    static void sumDiagonal(int[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][i];
        }
        System.out.println(sum);
    }
}
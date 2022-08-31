public class UpDownHiking {
    public static int maxHeight(int N, int A, int B) {
        int upHike = 0;
        for (int i = 1; i < N + 1; i++) {
            if (A * i < B * (N + 1 - i)) {
                if (i == N + 1 && A * i > B) {
                    break;
                } else {
                    upHike = i * A;
                }
            }
        }
        if (upHike == 0) {
            return 1;
        }
        return upHike;
    }

    public static void main(String[] args) {
        System.out.println(maxHeight(3, 7, 10));
        System.out.println(maxHeight(5, 40, 30));
        System.out.println(maxHeight(2, 50, 1));
        System.out.println(maxHeight(3, 42, 42));
        System.out.println(maxHeight(20, 7, 9));
    }
}

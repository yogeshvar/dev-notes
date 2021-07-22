class Challenge {

    public int alterFix(int[] digits) {
        int r = 0;
        int[] a = new int[10];
        for (int z : digits) {
            System.out.println("" + z);
            a[z]++;
        }
        for (int i = 1; i < 10; i++) {
            if (a[i] == 8)
                return i;
        }
        return r;
    }

    public int fix(int[] digits) {
        for (int i = 0; i < digits.length; i++) {
            if (i == 0 || i % 9 == 0) {
                int[] rows = new int[9];
                int count = 0;
                String str = "";
                for (int j = i; j < i + 9; j++) {
                    rows[count] = digits[j];
                    str += digits[j];
                    count++;
                }
                System.out.println("" + str);
                for (int x = 0; x < rows.length; x++) {
                    if (x != rows[x]) {
                        return findMissing(rows);
                    }
                }
            }
        }
        return 1;
    }

    public int findMissing(int[] row) {
        int sum = 0;
        for (int n : row) {
            sum += n;
        }
        return (row.length * (row.length + 1) / 2) - sum;
    }
}

public class SudokuTypo {
    public static void main(String[] args) {
        Challenge challenge = new Challenge();
        int[] digits = { 8, 6, 1, 2, 3, 4, 9, 5, 3, 4, 7, 9, 5, 6, 1, 2, 8, 3, 3, 2, 5, 9, 7, 8, 1, 6, 4, 9, 5, 8, 1, 4,
                3, 6, 7, 2, 7, 1, 2, 8, 5, 6, 3, 4, 9, 6, 3, 4, 7, 2, 9, 5, 1, 8, 5, 9, 6, 4, 8, 2, 7, 3, 1, 1, 4, 3, 6,
                9, 7, 8, 2, 5, 2, 8, 7, 3, 1, 5, 4, 9, 6 };
        int result = challenge.alterFix(digits);
        System.out.println("Result : " + result);

    }
}
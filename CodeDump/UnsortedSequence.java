import java.util.Arrays;

public class UnsortedSequence {
    public int[] getUnsorted(int[] s) {
        Arrays.sort(s);
        if (s[0] == s[s.length - 1])
            return new int[0];
        int i = s.length - 2;
        while (s[i] == s[i + 1]) {
            --i;
        }
        int temp = s[i];
        s[i] = s[i + 1];
        s[i + 1] = temp;
        return s;
    }

    public static void main(String[] args) {
        UnsortedSequence unsortedSequence = new UnsortedSequence();
        int[] s = { 2, 8, 5, 1, 10, 5, 9, 9, 3, 10, 5, 6, 6, 2, 8, 2, 10 };
        s = unsortedSequence.getUnsorted(s);
        System.out.println("Array " + Arrays.toString(s));
    }
}

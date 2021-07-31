import java.util.Arrays;

public class CopyingHomework {
    public static int[] copy(int[] friendsHomework) {
        int count = 0;
        for (int i = 0; i < friendsHomework.length; i++) {
            if (i == friendsHomework.length - 1) {
                friendsHomework[i] = friendsHomework[i] + count;
            } else {
                friendsHomework[i] = friendsHomework[i] - 1;
                count++;
            }
        }
        return friendsHomework;
    }

    public static void main(String[] args) {
        int[] arr = { 400, 399, 400, 399, 400 };
        System.out.println("Result " + Arrays.toString(copy(arr)));
    }
}

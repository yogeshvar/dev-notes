public class PalindromePerm {
    /**
     * Chapter 1: Array and Strings
     * Interview Questions: 1.4
     */
    public static Boolean checkPermPal(String a) {
        int[] map = new int[128];
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            map[a.charAt(i)]++;
            if (map[a.charAt(i)] % 2 == 0) {
                count--;
            } else {
                count++;
            }
        }

        return count <= 1;
    }

    public static void main(String[] args) {
        System.out.println(checkPermPal("carerac"));
    }
}

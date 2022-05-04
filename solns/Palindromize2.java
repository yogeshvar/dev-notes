public class Palindromize2 {
    public static String minChanges(String s) {
        StringBuffer str = new StringBuffer(s);
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            char a = str.charAt(i), b = str.charAt(j);
            if (a < b) {
                str.setCharAt(j, a);
            } else
                str.setCharAt(i, b);
        }

        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(minChanges("ameba"));
    }
}
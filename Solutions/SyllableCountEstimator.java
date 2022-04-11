

public class SyllableCountEstimator {

    public static int estimate(String word) {
        char[] c = word.toCharArray();
        int tot = 0;
        for (char ch : c) {
            if (ch == 'a')
                tot++;
            if (ch == 'e')
                tot++;
            if (ch == 'i')
                tot++;
            if (ch == 'o')
                tot++;
            if (ch == 'u')
                tot++;
        }
        for (int i = 0; i < c.length - 1; i++) {

            if (c[i] == 'a' && c[i + 1] == 'u')
                tot--;
            if (c[i] == 'o' && c[i + 1] == 'a')
                tot--;
            if (c[i] == 'o' && c[i + 1] == 'o')
                tot--;
            if (i < c.length - 2)
                if (c[i] == 'i' && c[i + 1] == 'o' && c[i + 2] == 'u')
                    tot--;

        }

        if (c[c.length - 1] == 'e')
            tot--;

        if (c.length >= 3)
            if (c[c.length - 1] == 'e' && c[c.length - 2] == 'l')
                if (c[c.length - 3] != 'a' && c[c.length - 3] != 'e' && c[c.length - 3] != 'i' && c[c.length - 3] != 'o'
                        && c[c.length - 3] != 'u')
                    tot++;

        return Math.max(tot, 1);
    }

    public static void main(String[] args) {
        String word = "queued";
        int result = estimate(word);
        System.out.println("Result : " + result);
    }
}

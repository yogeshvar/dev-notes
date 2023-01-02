import java.util.Set;
import java.util.stream.Collectors;

public class OneAway {
    /**
     * Chapter 1: Array and Strings
     * Interview Questions: 1.5
     */

    /**
     * Solution without understanding the question properly!
     * Note: This is a major mistake when tho, I'm done with the problem.
     * 
     * @param a - Given String a
     * @param b - Given String b
     * @return - Is One Edit Away
     */
    public static boolean checkOneAway(String a, String b) {
        Set<Character> setA = a.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
        Set<Character> setB = b.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());

        int count = 0;

        if (setA.size() > setB.size()) {
            setA.removeAll(setB);
            count = setA.size();
        } else {
            setB.removeAll(setA);
            count = setB.size();
        }

        if (count >= 1) {
            return true;
        }

        return false;
    }

    /**
     * Best Solution to check with removal, edits.
     * 
     * @param args
     */

    public static boolean oneEditAway(String a, String b) {
        if (a.length() == b.length()) {
            return checkReplaceEdit(a, b);
        } else if (a.length() == b.length() + 1) {
            return checkRemovalEdit(a, b);
        } else if (a.length() + 1 == b.length()) {
            return checkRemovalEdit(b, a);
        }
        return false;
    }

    private static boolean checkReplaceEdit(String a, String b) {
        int i = 0;
        int editCount = 0;
        while (i < a.length()) {
            if (a.charAt(i) != b.charAt(i)) {
                editCount++;
                i++;
            }
            i++;
        }
        return editCount <= 1;
    }

    private static boolean checkRemovalEdit(String bigger, String smaller) {
        int removalCount = 0;
        int i = 0, j = 0;
        while (i < bigger.length()) {
            if (bigger.charAt(i) != smaller.charAt(j)) {
                removalCount++;
                i++;
            }
            i++;
            j++;
        }
        return removalCount <= 1;

    }

    public static void main(String[] args) {
        System.out.println(oneEditAway("pale", "bake"));
    }
}

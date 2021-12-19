import java.util.Arrays;
import java.util.Hashtable;

/**
 * Chapter 1: Array and Strings
 * Interview Questions: 1.1
 */

class IsUnique {
    public static void main(String[] args) {
        char[] str = { 'm', 'a', 'g', 'i', 'e' };

        var bruteForceResult = bruteForce(str);
        System.out.println("Brute Force Result " + bruteForceResult);

        var hashTableResult = hashTableSoln(str);
        System.out.println("Hash Table Result " + hashTableResult);

        var OptimizeSolnResult = OptimizeSoln(str);
        System.out.println("Optimal Result " + OptimizeSolnResult);
    }

    // O(N^2)
    public static Boolean bruteForce(char[] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < input.length; j++) {
                if (input[i] == input[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    // O(N)
    public static Boolean hashTableSoln(char[] input) {
        Hashtable<Integer, Character> hashtable = new Hashtable<>();
        for (int i = 0; i < input.length; i++) {
            if (hashtable.contains(input[i])) {
                return false;
            } else {
                int hashValue = input[i] % input.length;
                hashtable.put(hashValue, input[i]);
            }
        }
        return true;
    }

    // O(n log n)
    public static Boolean OptimizeSoln(char[] input) {
        Arrays.sort(input); // uses binary sort (n log n)
        for (int i = 0; i < input.length - 1; i++) {
            if (input[i] == input[i + 1]) {
                return false;
            }
        }
        return true;
    }
}

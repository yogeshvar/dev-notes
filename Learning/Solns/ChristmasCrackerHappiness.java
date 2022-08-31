import java.util.Arrays;
import java.util.LinkedHashSet;

public class ChristmasCrackerHappiness {

    private static int[] removeDuplicates(int[] arr1, int[] arr2) {
        LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();

        for (int i = 0; i < arr1.length; i++)
            set.add(arr1[i]);

        for (int i = 0; i < arr2.length; i++)
            set.add(arr2[i]);

        return set.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int solve(int N, int[] winner, int[] loser) {
        int[] totalParticipants = removeDuplicates(winner, loser);
        Arrays.sort(totalParticipants);
        System.out.print("" + Arrays.toString(totalParticipants));
        return N - totalParticipants.length;
    }

    public static void main(String[] args) {
        int N = 12;
        int[] winner = { 3, 1, 4, 1, 5, 9, 2, 6 };
        int[] loser = { 5, 3, 5, 8, 9, 7, 9, 3 };
        System.out.println("" + solve(N, winner, loser));
    }
}
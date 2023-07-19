package Arrays.MAANG;

import java.util.Arrays;

public class FindTopTwoScores {
    public static void main(String[] args) {
        int[] scores = { 99, 98, 98, 97, 97, 96, 95, 94, 93, 91, 90, 89, 89, 88, 87, 86, 85, 84, 83, 82, 81, 80 };
        Arrays.sort(scores);
        int first = scores[scores.length - 1];
        int second = scores[scores.length - 2];
        System.out.println("First: " + first + " Second: " + second);
    }
}

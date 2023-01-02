import java.util.ArrayList;
import java.util.Arrays;

/**
 * [A (0,0), A (0,1)] => [A, B] [B (1,0), B (1,1)] [B, A]
 * 
 * [A A][. B] temp = B result = 2 [A B][. B] temp = A result = 2, 1 [A B][A B]
 * temp = 0 result = 2, 1, 4
 * 
 * A B->A A A A A AAA A.A ABA ABA AB. ABC ABC ABC BBB BBB BB. BBC BBC BBC .BC
 * ABC CCC CCC CCC .CC ACC A.C ABC ABC
 * 
 * A A AA .A BA BA BB BB .B AB
 * 
 * 
 * AA A. AB AB
 * BB BB .B AB
 * 
 * AAA A.A AB.
 * BBB BBB 
 * CCC CCC
 * 
 */
public class TransposeColors {
    public static int[] move(int N) {
        ArrayList<Integer> result = new ArrayList<>();
        char[][] tokenMatrix = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tokenMatrix[i][j] = (char) (i + 'A');
            }
        }

        // [A A] [B B]
        // A (0,0) => temp
        // [. A] [B B]; temp => A
        // [B A] [. B]: temp =>
        char temp = '0';
        for (int i = 0; i < tokenMatrix.length; i++) {
            char firstElementInIth = tokenMatrix[0][0];
            temp = firstElementInIth;
            for (int j = 1; j < tokenMatrix[i].length; j++) {
                result.add(i * N + j);
                char jthElement = tokenMatrix[j][i];
                tokenMatrix[i][j] = jthElement;
            }
            tokenMatrix[i][0] = temp;
        }
        result.add(N * N);

        System.out.println(Arrays.deepToString(tokenMatrix));

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(move(3)));
    }
}

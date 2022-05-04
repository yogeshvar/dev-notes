import java.util.Arrays;

public class HealthFood {
    public static int[] selectMeals(int[] protein, int[] carbs, int[] fat, String[] dietPlans) {
        int result[] = new int[dietPlans.length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 1; j < protein.length; j++) {
                if (bestMeal(protein, carbs, fat, dietPlans[i], j, result[i])) {
                    result[i] = j;
                }
            }
        }
        return result;
    }

    static boolean bestMeal(int protein[], int carbs[], int fat[], String dietPlan, int a, int b) {
        for (int i = 0; i < dietPlan.length(); i++) {
            char character = dietPlan.charAt(i);
            if (character == 'C' || character == 'c') {
                if (carbs[a] == carbs[b]) {
                    continue;
                }
                if (character == 'C') {
                    return carbs[a] > carbs[b];
                } else {
                    return carbs[a] < carbs[b];
                }
            } else if (character == 'P' || character == 'p') {
                if (protein[a] == protein[b]) {
                    continue;
                }
                if (character == 'P') {
                    return protein[a] > protein[b];
                } else {
                    return protein[a] < protein[b];
                }
            } else if (character == 'F' || character == 'f') {
                if (fat[a] == fat[b]) {
                    continue;
                }
                if (character == 'F') {
                    return fat[a] > fat[b];
                } else {
                    return fat[a] < fat[b];
                }
            } else {
                int calorie1 = protein[a] * 5 + carbs[a] * 5 + fat[a] * 9;
                int calorie2 = protein[b] * 5 + carbs[b] * 5 + fat[b] * 9;
                if (calorie1 == calorie2) {
                    continue;
                }
                if (character == 'T') {
                    return calorie1 > calorie2;
                } else {
                    return calorie1 < calorie2;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] p = { 3, 4, 1, 5 };
        int[] c = { 2, 8, 5, 1 };
        int[] f = { 5, 2, 4, 4 };
        String[] d = { "tFc", "tF", "Ftc" };
        System.out.println(Arrays.toString(selectMeals(p, c, f, d)));
    }
}

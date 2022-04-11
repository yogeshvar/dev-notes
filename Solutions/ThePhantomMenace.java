public class ThePhantomMenace {
    public static int find(int[] doors, int[] droids) {
        // Calculate Safety Level.
        int[][] safetyLevels = new int[doors.length][droids.length];
        safetyLevels = calculateSafetyLevels(doors, droids);

        // Find the smallest Safety Level.
        int[] smallestSafetyLevels = new int[safetyLevels.length];
        smallestSafetyLevels = findSmallestSafetyLevels(safetyLevels);

        // Find the optimized Safety Level.
        int optimizedSafetyLevel = smallestSafetyLevels[0];
        for (int i = 0; i < smallestSafetyLevels.length; i++) {
            if (smallestSafetyLevels[i] > optimizedSafetyLevel) {
                optimizedSafetyLevel = smallestSafetyLevels[i];
            }
        }
        return optimizedSafetyLevel;
    }

    private static int[][] calculateSafetyLevels(int[] doors, int[] droids) {
        int[][] weights = new int[doors.length][droids.length];
        for (int i = 0; i < doors.length; i++) {
            for (int j = 0; j < droids.length; j++) {
                weights[i][j] = Math.abs(droids[j] - doors[i]);
            }
        }
        return weights;
    }

    private static int[] findSmallestSafetyLevels(int[][] weights) {
        int[] smallestValues = new int[weights.length];
        for (int i = 0; i < weights.length; i++) {
            int smallest = weights[i][0];
            for (int j = 0; j < weights[0].length; j++) {
                if (weights[i][j] < smallest) {
                    smallest = weights[i][j];
                }
            }
            smallestValues[i] = smallest;
        }
        return smallestValues;
    }

    public static void main(String[] args) {
        int[] doors = { 1, 2, 3, 4 };
        int[] droids = { 5, 6, 7, 8 };
        System.out.println("Result : " + find(doors, droids));
    }
}
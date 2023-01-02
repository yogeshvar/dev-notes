import java.util.Arrays;
import java.util.stream.IntStream;

public class AttributeMatrix {
    public static int[][] getAttributeAffinityMatrix(int[][] frequencyMatrix, int[][] affinityMatrix) {
        int[] costMatrix = getCostMatrix(affinityMatrix);
        int[][] coefficientMatrix = coefficientMethod(frequencyMatrix, costMatrix);
        int[][] AA = calculateAttributeAffinityMatrixByCoefficientMethod(coefficientMatrix);
        return AA;
    }

    private static int[][] coefficientMethod(int[][] frequencyMatrix, int[] costMatrix) {
        int[][] AA = new int[frequencyMatrix.length][frequencyMatrix[0].length];
        for (int i = 0; i < frequencyMatrix.length; i++) {
            for (int j = 0; j < frequencyMatrix[0].length; j++) {
                if (frequencyMatrix[i][j] == 1) {
                    AA[i][j] = 1 * costMatrix[i];
                } else {
                    AA[i][j] = frequencyMatrix[i][j];
                }
            }
        }
        return AA;
    }

    private static int[] getColumn(int[][] matrix, int column) {
        return IntStream.range(0, matrix.length).map(i -> matrix[i][column]).toArray();
    }

    public static int[][] calculateAttributeAffinityMatrixByCoefficientMethod(int[][] coefficientMatrix) {
        int[][] attributeMatrix = new int[coefficientMatrix.length][coefficientMatrix[0].length];
        for (int i = 0; i < attributeMatrix.length; i++) {
            for (int j = 0; j < attributeMatrix[0].length; j++) {
                attributeMatrix[i][j] = calculateAffinityValue(i, j, coefficientMatrix);
            }
        }
        return attributeMatrix;
    }

    public static int calculateAffinityValue(int i, int j, int[][] coefficientMatrix) {
        double affValue = 0;
        double num = 0, dem_part_1 = 0, dem_part_2 = 0;
        int[] column1 = getColumn(coefficientMatrix, i);
        int[] column2 = getColumn(coefficientMatrix, j);
        for (int k = 0; k < coefficientMatrix.length; k++) {
            num += column1[k] * column2[k];
            dem_part_1 += column1[k];
            dem_part_2 += column2[k];
        }
        affValue = Math.ceil(num / Math.sqrt(dem_part_1 * dem_part_2));
        return (int) affValue;
    }

    public static int[][] calculateAttributeAffinityMatrix(int[][] frequencyMatrix, int[] costMatrix) {
        int[][] affinityMatrix = new int[frequencyMatrix.length][frequencyMatrix[0].length];
        for (int i = 0; i < frequencyMatrix.length; i++) {
            for (int j = 0; j < frequencyMatrix[0].length; j++) {
                int[] column1 = getColumn(frequencyMatrix, i);
                int[] column2 = getColumn(frequencyMatrix, j);
                int[] accessFrequency = calculateAff(column1, column2);
                int sum = 0;
                for (int k = 0; k < accessFrequency.length; k++) {
                    if (accessFrequency[k] == 1) {
                        sum += costMatrix[k];
                    }
                }
                affinityMatrix[i][j] = sum;
            }
        }
        return affinityMatrix;
    }

    public static int invert(int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 0;
        }
        return 0;
    }

    public static int[] calculateAff(int[] columnOne, int[] columnTwo) {
        int[] accessFrequency = new int[columnOne.length];
        for (int i = 0; i < columnOne.length; i++) {
            int result = columnOne[i] * columnTwo[i];
            accessFrequency[i] = result;
        }
        return accessFrequency;
    }

    /**
     * Get the cost of the queries across the sites (S1, S2, S3)
     * 
     * @param affinityMatrix
     * @return costMatrix
     */
    public static int[] getCostMatrix(int[][] affinityMatrix) {
        int[] costMatrix = new int[affinityMatrix.length];
        for (int i = 0; i < affinityMatrix.length; i++) {
            int sum = 0;
            for (int j = 0; j < affinityMatrix[0].length; j++) {
                sum += affinityMatrix[i][j];
            }
            costMatrix[i] = sum;
        }
        return costMatrix;
    }

    public static void main(String[] args) {
        int[][] frequencyMatrix = { { 1, 0, 1, 0 }, { 0, 1, 1, 0 }, { 0, 1, 0, 1 }, { 0, 0, 1, 1 } };
        int[][] affinityMatrix = { { 15, 20, 10 }, { 5, 0, 0 }, { 25, 25, 25 }, { 5, 0, 0 } };
        int[][] AA = getAttributeAffinityMatrix(frequencyMatrix, affinityMatrix);
        System.out.println("" + Arrays.deepToString(AA));
    }
}

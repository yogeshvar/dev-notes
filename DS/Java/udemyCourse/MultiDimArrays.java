package udemyCourse;

import java.util.Arrays;

public class MultiDimArrays {
    int arr[][] = null;

    public MultiDimArrays(int rowSize, int columnSize) {
        arr = new int[rowSize][columnSize];
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                arr[i][j] = Integer.MIN_VALUE;
            }
        }
    }

    public void insert(int row, int column, int value) {
        try {
            if (arr[row][column] == Integer.MIN_VALUE) {
                arr[row][column] = value;
                System.out.println("Insert Done!!!");
            } else {
                System.out.println("Value present");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    public void traversal() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.println(arr[i][j] + " ");
            }
        }
    }

    public void prettyTraversal() {
        for (int[] row : arr) {
            System.out.println(Arrays.toString(row));
        }
    }

    public void linearSearch(int value) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == value) {
                    System.out.println("Index: " + i + " " + j);
                    return;
                }
            }
        }
        System.out.println("Key not found");
    }

    public void deleteIndex(int row, int col) {
        try {
            arr[row][col] = Integer.MIN_VALUE;
            System.out.println("Delete Done!!!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

}

class Main {
    public static void main(String[] args) {
        MultiDimArrays multiDimArrays = new MultiDimArrays(3, 3);
        multiDimArrays.insert(0, 0, 10);
        multiDimArrays.insert(1, 0, 20);
        multiDimArrays.insert(2, 0, 30);
        multiDimArrays.insert(1, 1, 1);

        multiDimArrays.prettyTraversal();
    }
}

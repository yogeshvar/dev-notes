package Arrays.MAANG;

public class MiddleFunction {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        middleOpt(arr);
    }

    static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void middleOpt(int[] arr) {
        int[] arr2 = new int[arr.length - 2];
        int index = 1; 
        while (index < arr.length - 1) {
            arr2[index - 1] = arr[index];
            index++;
        }
        printArray(arr2);
    }

    public static void middle(int[] arr) {
        int[] arr2 = new int[arr.length - 2];
        for (int i = 0; i < arr.length; i++) {
            if (i == 0 || i == arr.length - 1) {
                continue;
            } else {
                arr2[i - 1] = arr[i];
            }
        }
        printArray(arr2);
    }
}

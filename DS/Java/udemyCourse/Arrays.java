package udemyCourse;

public class Arrays {
    int arr[] = null;

    public Arrays(int sizeOfArray) {
        arr = new int[sizeOfArray];
        for (int i = 0; i < sizeOfArray; i++) {
            arr[i] = Integer.MIN_VALUE;
        }
    }

    public void insert(int location, int value) {
        try {
            if (arr[location] == Integer.MIN_VALUE) {
                arr[location] = value;
                System.out.println("Insert Done!!!");
            } else {
                System.out.println("Value already present");
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void traversal() {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public void linearSearch(int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                System.out.println("Index: " + i);
                return;
            }
        }
        System.out.println("Key not found");
    }

    public void deleteIndex(int index) {
        try {
            if (arr[index] != Integer.MIN_VALUE) {
                arr[index] = Integer.MIN_VALUE;
                System.out.println("Deleted Successfully");
            } else {
                System.out.println("Value already present");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {
        Arrays arrays = new Arrays(5);
        arrays.insert(0, 10);
        arrays.insert(1, 20);
        arrays.insert(2, 30);
        arrays.traversal();

        arrays.linearSearch(10);
    }

    public static char[] deepToString(MultiDimArrays multiDimArrays) {
        return null;
    }
}

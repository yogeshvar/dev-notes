package Arrays;
public class SingleDimensionArray {
  int arr[] = null;

  public static void main(String[] args) {
    SingleDimensionArray sda = new SingleDimensionArray(10);
    sda.traverseArray();
    sda.insert(0, 10);
    sda.insert(1, 20);
    sda.insert(2, 30);
    sda.insert(3, 40);
    sda.insert(4, 50);
    sda.insert(5, 60);
    sda.insert(6, 70);
    sda.insert(7, 80);
    sda.insert(8, 90);
    sda.insert(1, 100);
    sda.traverseArray();
    sda.searchInArray(50);
    sda.searchInArray(100);
    sda.deleteValue(4);
    sda.traverseArray();
  }

  public SingleDimensionArray(int sizeOfArray) {
    arr = new int[sizeOfArray];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = Integer.MIN_VALUE;
    }
  }

  public void insert(int location, int valueToBeInserted) {
    try {
      if (arr[location] == Integer.MIN_VALUE) {
        arr[location] = valueToBeInserted;
        System.out.println("Successfully inserted \n");
      } else {
        System.out.println("This cell is already occupied \n");
      }
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Invalid index to access array! \n");
    }
  }

  // Array Traversal

  public void traverseArray() {
    try {
      for (int i = 0; i < arr.length; i++) {
        System.out.print(arr[i] + " ");
      }
    } catch (Exception e) {
      System.out.println("Array no longer exists! \n");
    }

  }

  // Search for an element in the given Array
  public void searchInArray(int valueToSearch) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == valueToSearch) {
        System.out.println("Value is found at the index of " + i + "\n");
        return;
      }
    }
    System.out.println(valueToSearch + " is not found \n");
  }

  // Delete value from Array
  public void deleteValue(int valueToDeleteIndex) {
    try {
      arr[valueToDeleteIndex] = Integer.MIN_VALUE;
      System.out.println("The value has been deleted successfully \n");

    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("The value that is provided is not in the range of array \n");

    }
  }

}
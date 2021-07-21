package udemyCourse;

public class BinaryHeap {
    Integer arr[];
    int size;

    public BinaryHeap(int arrSize) {
        arr = new Integer[arrSize + 1];
        this.size = 0;
        System.out.println("Heap created");
    }

    boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public void peek() {
        if (isEmpty()) {
            System.out.println("Heap is empty");
        } else {
            System.out.println("Peek value " + arr[1]);
        }
    }

    public void size() {
        System.out.println("Size of Tree " + size);
    }

    public void levelOrder() {
        for (int i = 1; i <= arr.length - 1; i++) {
            System.out.print(" " + arr[i]);
        }
    }

    public void heapOrder(int index, String heapType) {
        int parent = index / 2;
        if (index <= 1) {
            return;
        }
        if (heapType == "min") {
            if (arr[index] <= arr[parent]) {
                int tmp = arr[index];
                arr[index] = arr[parent];
                arr[parent] = tmp;
            }
        } else if (heapType == "max") {
            if (arr[index] > arr[parent]) {
                int tmp = arr[index];
                arr[index] = arr[parent];
                arr[parent] = tmp;
            }
        }
        heapOrder(parent, heapType);
    }

    public void insert(int value, String heapType) {
        arr[size + 1] = value;
        size++;
        heapOrder(size, heapType);
    }

    public void heapifyTopToBottom(int index, String heapType) {
        int left = index * 2;
        int right = index * 2 + 1;
        int swapChild = 0;
        if (size < left) {
            return;
        }
        if (heapType == "max") {
            if (size == left) {
                if (arr[index] < arr[left]) {
                    int tmp = arr[index];
                    arr[index] = arr[left];
                    arr[left] = tmp;
                }
                return;
            } else {
                if (arr[left] > arr[right]) {
                    swapChild = left;
                } else {
                    swapChild = right;
                }
                if (arr[index] < arr[swapChild]) {
                    int tmp = arr[index];
                    arr[index] = arr[swapChild];
                    arr[swapChild] = tmp;
                }
            }
        } else if (heapType == "min") {
            if (size == left) {
                if (arr[index] > arr[left]) {
                    int tmp = arr[index];
                    arr[index] = arr[left];
                    arr[left] = tmp;
                }
                return;
            } else {
                if (arr[left] < arr[right]) {
                    swapChild = left;
                } else {
                    swapChild = right;
                }
                if (arr[index] > arr[swapChild]) {
                    int tmp = arr[index];
                    arr[index] = arr[swapChild];
                    arr[swapChild] = tmp;
                }
            }
        }
        heapifyTopToBottom(swapChild, heapType);
    }

    public int extractHeadOfBP(String heapType) {
        if (isEmpty()) {
            return -1;
        } else {
            int extractedValue = arr[1];
            arr[1] = arr[size];
            size--;
            heapifyTopToBottom(1, heapType);
            return extractedValue;
        }
    }

    public static void main(String[] args) {
        BinaryHeap binaryHeap = new BinaryHeap(5);
        binaryHeap.insert(10, "max");
        binaryHeap.insert(5, "max");
        binaryHeap.insert(15, "max");
        binaryHeap.insert(20, "max");
        binaryHeap.insert(11, "max");

        binaryHeap.peek();
        binaryHeap.levelOrder();

        binaryHeap.extractHeadOfBP("max");
        binaryHeap.peek();
        binaryHeap.levelOrder();
    }
}

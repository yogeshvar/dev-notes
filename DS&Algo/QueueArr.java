package udemyCourse;

public class QueueArr {
    int[] arr;
    int top;
    int start;

    public QueueArr(int size) {
        this.arr = new int[size];
        this.top = -1;
        this.start = -1;
        System.out.println("Queue created");
    }

    public boolean isFull() {
        if (top == arr.length - 1)
            return true;
        return false;
    }

    public boolean isEmpty() {
        if (top == -1) {
            return true;
        }
        return false;
    }

    public void enqueue(int value) {
        if (this.isFull())
            System.out.println("Queue is full");
        else if (this.isEmpty()) {
            top = 0;
            start++;
            arr[start] = value;
            System.out.println("Enqueued value " + value);
        } else {
            top++;
            arr[top] = value;
            System.out.println("Enqueued value " + value);
        }
    }

    public int dequeue() {
        if (this.isEmpty()) {
            System.out.println("Queue is full");
            return -1;
        } else {
            int result = arr[top];
            top++;
            if (start > top) {
                start = top = -1;
            }
            return result;  
        }
    }
}

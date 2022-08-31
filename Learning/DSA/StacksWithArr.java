
class StacksWithArr {
    int[] arr;
    int top;

    public StacksWithArr(int size) {
        this.arr = new int[size];
        this.top = -1;
        System.out.println("Array created with Size " + size);
    }

    public boolean isEmpty() {
        if (top == -1)
            return true;
        return false;
    }

    public void push(int value) {
        if (this.isFull())
            System.out.println("Stack is full");
        else {
            arr[top + 1] = value;
            top++;
            System.out.println("Stack updated with value " + value);
        }
    }

    public int pop() {
        if (this.isEmpty()) {
            System.out.println("Empty Stack");
            return -1;
        } else {
            int value = arr[top];
            top--;
            return value;
        }
    }

    public void peek() {
        if (this.isEmpty()) {
            System.out.println("Stack is Empty");
        } else {
            System.out.println("Top value is " + arr[top]);
        }
    }

    public boolean isFull() {
        if (top == arr.length - 1)
            return true;
        return false;
    }

    public void print() {
        for (int i = top; i != -1; i--) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        StacksWithArr stacksWithArr = new StacksWithArr(4);
        stacksWithArr.push(0);
        stacksWithArr.push(1);
        stacksWithArr.push(2);
        int value = stacksWithArr.pop();
        System.out.println("Popped out " + value);
        stacksWithArr.peek();
        stacksWithArr.print();
    }
}

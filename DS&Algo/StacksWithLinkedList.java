package udemyCourse;

public class StacksWithLinkedList {
    SingleLinkedList singleLinkedList;

    public StacksWithLinkedList() {
        singleLinkedList = new SingleLinkedList();
    }

    public boolean isEmpty() {
        if (singleLinkedList.head == null) {
            return true;
        }
        return false;
    }

    public void push(int value) {
        singleLinkedList.insertNode(1, value);
    }

    public int pop() {
        if (this.isEmpty()) {
            return -1;
        } else {
            return singleLinkedList.head.value;
        }
    }

    public void peek() {
        if (this.isEmpty()) {
            System.out.println("Stack is Empty");
        } else {
            System.out.println("Top value is " + singleLinkedList.head.value);
        }
    }

    public void print() {
        singleLinkedList.traversal();
    }

    public static void main(String[] args) {
        StacksWithLinkedList StacksWithLinkedList = new StacksWithLinkedList();
        StacksWithLinkedList.push(0);
        StacksWithLinkedList.push(1);
        StacksWithLinkedList.push(2);
        int value = StacksWithLinkedList.pop();
        System.out.println("Popped out " + value);
        StacksWithLinkedList.peek();
        StacksWithLinkedList.print();
    }
}

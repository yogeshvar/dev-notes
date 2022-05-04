
public class Queues {
    SingleLinkedList singleLinkedList;

    public Queues() {
        singleLinkedList = new SingleLinkedList();
    }

    public boolean isEmpty() {
        if (singleLinkedList.head == null) {
            return true;
        }
        return false;
    }

    public void enqueue(int value) {
        singleLinkedList.insertNode(singleLinkedList.size, value);
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Empty Queue");
            return -1;
        } else {
            singleLinkedList.deleteNode(0);
            return singleLinkedList.head.value;
        }
    }

    public void peek() {
        if (isEmpty()) {
            System.out.println("Empty List");
        } else {
            System.out.println("Top value is : " + singleLinkedList.head.value);
        }
    }
}

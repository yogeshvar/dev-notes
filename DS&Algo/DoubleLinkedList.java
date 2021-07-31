
class DoubleNode {
    public int value;
    public DoubleNode next;
    public DoubleNode prev;
}

public class DoubleLinkedList {
    DoubleNode head;
    DoubleNode tail;
    int size;

    public DoubleNode createLinkedList(int value) {
        head = new DoubleNode();
        tail = new DoubleNode();
        DoubleNode doubleNode = new DoubleNode();
        doubleNode.value = value;
        doubleNode.next = null;
        doubleNode.prev = null;
        head = tail = doubleNode;
        size = 1;
        return head;
    }

    public void insertNode(int index, int value) {
        DoubleNode temp = new DoubleNode();
        temp.value = value;
        if (index == 1) {
            temp.next = head;
            temp.prev = null;
            head.prev = temp;
            head = temp;
            size++;
            System.out.println("Insert done at start index : " + index);
        } else if (index == size) {
            temp.next = null;
            temp.prev = tail;
            tail.next = temp;
            tail = temp;
            size++;
            System.out.println("Insert done at end index : " + index);
        } else {
            DoubleNode tempDoubleNode = head;
            int i = 1;
            while (i != index) {
                tempDoubleNode = tempDoubleNode.next;
                i++;
            }
            temp.next = tempDoubleNode.next;
            temp.prev = tempDoubleNode;
            temp.next.prev = temp;
            tempDoubleNode.next = temp;
            size++;
            System.out.println("Insert done at index : " + index);
        }
    }

    public void deleteNode(int index) {
        if (head == null) {
            System.out.println("No list");
        } else if (index == 1) {
            head.next.prev = null;
            head = head.next;
            size--;
            if (size == 0) {
                tail = null;
            }
        } else if (index == size) {
            DoubleNode tempNode = head;
            int i = 1;
            while (i != size - 1) {
                tempNode = tempNode.next;
                i++;
            }
            tempNode.next = null;
            tail = tempNode;
            size--;
            if (size == 0) {
                head = null;
            }
        } else {
            DoubleNode tempNode = head;
            int i = 1;
            while (i < index) {
                tempNode = tempNode.next;
                i++;
            }
            tempNode.next.next.prev = tempNode;
            tempNode.next = tempNode.next.next;
            size--;
        }
    }

    public void traversal() {
        if (head == null) {
            System.out.println("Empty Linked List");
        } else {
            DoubleNode tempHead = head;
            while (tempHead != null) {
                System.out.print(tempHead.value + "->");
                tempHead = tempHead.next;
            }
            System.out.println("");
        }
    }

    public void reverseTraversal() {
        if (tail == null) {
            System.out.println("Empty Linked List");
        } else {
            DoubleNode tempTail = tail;
            while (tempTail != null) {
                System.out.print(tempTail.value + "->");
                tempTail = tempTail.prev;
            }
            System.out.println("");
        }
    }

    public void peekTail() {
        if (tail == null) {
            System.out.println("No tail");
        } else {
            System.out.println("Tail value : " + tail.value);
        }
    }

    public void peekHead() {
        if (head == null) {
            System.out.println("No Head");
        } else {
            System.out.println("Head value : " + head.value);
        }
    }

    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.createLinkedList(1);
        doubleLinkedList.insertNode(1, 2);
        doubleLinkedList.insertNode(1, 3);
        doubleLinkedList.insertNode(1, 4);
        doubleLinkedList.insertNode(doubleLinkedList.size, 5);
        doubleLinkedList.insertNode(3, 8);
        doubleLinkedList.insertNode(3, 8);
        doubleLinkedList.traversal();
        doubleLinkedList.reverseTraversal();
        doubleLinkedList.deleteNode(3);
        doubleLinkedList.traversal();
        doubleLinkedList.reverseTraversal();
    }
}

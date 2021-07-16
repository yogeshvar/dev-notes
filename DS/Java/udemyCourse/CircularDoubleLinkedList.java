package udemyCourse;

public class CircularDoubleLinkedList {
    DoubleNode head;
    DoubleNode tail;
    int size;

    public DoubleNode createCircularLinkedList(int value) {
        head = new DoubleNode();
        tail = new DoubleNode();
        DoubleNode doubleNode = new DoubleNode();
        doubleNode.value = value;
        doubleNode.next = doubleNode;
        doubleNode.prev = doubleNode;
        head = tail = doubleNode;
        size = 1;
        return head;
    }

    public void traversal() {
        if (head == null) {
            System.out.println("Empty List");
        } else {
            DoubleNode tempHead = head;
            int i = 1;
            while (i <= size) {
                System.out.print(tempHead.value + "->");
                tempHead = tempHead.next;
                i++;
            }
            System.out.println("");
        }
    }

    public void insertNode(int index, int value) {
        DoubleNode temp = new DoubleNode();
        temp.value = value;
        if (index == 1) {
            temp.next = head;
            temp.prev = null;
            head.prev = temp;
            head = temp;
            tail.next = head;
            size++;
            System.out.println("Insert done at start index : " + index);
        } else if (index == size) {
            temp.prev = tail;
            temp.next = head;
            tail.next = temp;
            tail = temp;
            size++;
            System.out.println("Insert done at index : " + index);
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
            System.out.println("No List");
        } else if (index == 1) {
            head.next.prev = null;
            head = head.next;
            tail.next = head;
            size--;
            if (size == 0) {
                tail = head;
            }
        } else if (index == size) {
            DoubleNode tempNode = head;
            int i = 1;
            while (i != size - 1) {
                tempNode = tempNode.next;
                i++;
            }
            tempNode.next = head;
            tail = tempNode;
            size--;
            if (size == 0) {
                head = tail;
            }
        } else {
            DoubleNode tempNode = head;
            int i = 1;
            while (i < index - 1) {
                tempNode = tempNode.next;
                i++;
            }
            tempNode.next.next.prev = tempNode;
            tempNode.next = tempNode.next.next;
            size--;
        }
    }

    public void reverseTraversal() {
        if (tail == null) {
            System.out.println("Empty List");
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
        CircularDoubleLinkedList circularDoubleLinkedList = new CircularDoubleLinkedList();
        circularDoubleLinkedList.createCircularLinkedList(1);
        circularDoubleLinkedList.insertNode(1, 0);
        circularDoubleLinkedList.insertNode(1, -1);
        circularDoubleLinkedList.insertNode(circularDoubleLinkedList.size, 2);
        circularDoubleLinkedList.insertNode(circularDoubleLinkedList.size, 3);
        circularDoubleLinkedList.insertNode(2, 20);
        circularDoubleLinkedList.insertNode(3, 30);
        circularDoubleLinkedList.traversal();
        circularDoubleLinkedList.reverseTraversal();

    }
}

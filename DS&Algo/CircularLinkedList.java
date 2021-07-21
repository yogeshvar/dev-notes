package udemyCourse;

public class CircularLinkedList {
    public Node head;
    public Node tail;
    public int size;

    public Node createCircularList(int value) {
        head = tail = new Node();
        Node node = new Node();
        node.value = value;
        node.next = node;
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    public void insertNode(int index, int value) {
        Node temp = new Node();
        temp.value = value;
        if (index == 1) {
            temp.next = head;
            head = temp;
            tail.next = head;
            size++;
            System.out.println("Insert done at index : " + index);
        } else if (index == size) {
            temp.next = head;
            tail.next = temp;
            tail = temp;
            size++;
            System.out.println("Insert done at index : " + index);
        } else {
            Node tempNode = head;
            int i = 1;
            while (i != index - 1) {
                tempNode = tempNode.next;
                i++;
            }
            temp.next = tempNode.next;
            tempNode.next = temp;
            size++;
            System.out.println("Insert done at index : " + index);
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

    public void traversal() {
        if (head == null) {
            System.out.println("Empty Linked List");
        } else {
            Node tempHead = head;
            int i = 1;
            while (i <= size + 1) {
                System.out.print(tempHead.value + "->");
                tempHead = tempHead.next;
                i++;
            }
            System.out.println("");
        }
    }

    public boolean searchNode(int key) {
        Node tempNode = head;
        int i = 1;
        while (i <= size) {
            if (tempNode.value == key) {
                System.out.println("Key found at : " + i);
                return true;
            }
            tempNode = tempNode.next;
            i++;
        }
        System.out.println("Key not found");
        return false;
    }

    public void deleteNode(int index) {
        if (head == null) {
            System.out.println("No List");
        } else if (index == 1) {
            head = head.next;
            tail.next = head;
            size--;
            if (size == 0) {
                tail = head;
            }
        } else if (index == size) {
            Node tempNode = head;
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
            Node tempNode = head;
            int i = 1;
            while (i < index - 1) {
                tempNode = tempNode.next;
                i++;
            }
            tempNode.next = tempNode.next.next;
            size--;
        }
    }

    public void deleteList() {
        head = tail = null;
        System.out.println("List deleted");
    }

    public static void main(String[] args) {
        CircularLinkedList circularLinkedList = new CircularLinkedList();
        circularLinkedList.createCircularList(1);
        circularLinkedList.insertNode(1, 0);
        circularLinkedList.traversal();
        circularLinkedList.insertNode(circularLinkedList.size, 2);
        circularLinkedList.traversal();
        circularLinkedList.insertNode(2, 10);
        circularLinkedList.insertNode(3, 100);
        circularLinkedList.insertNode(circularLinkedList.size, 20);
        circularLinkedList.traversal();
        circularLinkedList.searchNode(20);
        circularLinkedList.deleteNode(1);
        circularLinkedList.traversal();
        circularLinkedList.deleteNode(circularLinkedList.size);
        circularLinkedList.traversal();
        circularLinkedList.deleteNode(3);
        circularLinkedList.traversal();
    }
}

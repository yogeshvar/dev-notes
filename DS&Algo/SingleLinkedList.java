package udemyCourse;

class Node {
    public int value;
    public Node next;
}

public class SingleLinkedList {
    public Node head;
    public Node tail;
    public int size;

    public Node createLinkedList(int value) {
        head = new Node();
        tail = new Node();
        Node node = new Node();
        node.value = value;
        node.next = null;
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
            size++;
            System.out.println("Insert done at index : " + index);
        } else if (index == size) {
            temp.next = null;
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

    public void traversal() {
        if (head == null) {
            System.out.println("Empty Linked List");
        } else {
            Node tempHead = head;
            while (tempHead != null) {
                System.out.print(tempHead.value + "->");
                tempHead = tempHead.next;
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
            size--;
            if (size == 0) {
                tail = null;
            }
        } else if (index == size) {
            Node tempNode = head;
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
            Node tempNode = head;
            int i = 1;
            while (i < index) {
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
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.createLinkedList(1);
        singleLinkedList.insertNode(1, 0);
        singleLinkedList.insertNode(singleLinkedList.size, 2);
        singleLinkedList.insertNode(singleLinkedList.size, 4);
        singleLinkedList.insertNode(singleLinkedList.size, 5);
        singleLinkedList.insertNode(4, 3);
        singleLinkedList.traversal();
        singleLinkedList.peekHead();
        singleLinkedList.deleteNode(4);
        singleLinkedList.traversal();
    }
}
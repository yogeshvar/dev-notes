package udemyCourse;

import java.util.LinkedList;
import java.util.Queue;

class BinarySearch {
    BinaryNode root;

    BinarySearch() {
        root = null;
    }

    // Insert Method
    private BinaryNode insert(BinaryNode currentNode, int value) {
        if (currentNode == null) {
            BinaryNode newNode = new BinaryNode();
            newNode.value = value;
            return newNode;
        } else if (value <= currentNode.value) {
            currentNode.left = insert(currentNode.left, value);
            return currentNode;
        } else {
            currentNode.right = insert(currentNode.right, value);
            return currentNode;
        }
    }

    void insert(int value) {
        root = insert(root, value);
    }

    // PreOrder Traversal

    public void preOrder(BinaryNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    // Inorder Traversal
    public void inOrder(BinaryNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);

    }

    // PostOrder Traversal
    public void postOrder(BinaryNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }

    // Level Order

    void levelOrder() {
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();
            System.out.print(presentNode.value + " ");
            if (presentNode.left != null) {
                queue.add(presentNode.left);
            }
            if (presentNode.right != null) {
                queue.add(presentNode.right);
            }
        }
    }

    // Search Method
    BinaryNode search(BinaryNode node, int value) {
        if (node == null) {
            System.out.println("Value: " + value + " not found in BST");
            return null;
        } else if (node.value == value) {
            System.out.println("Value: " + value + " found in BST");
            return node;
        } else if (value < node.value) {
            return search(node.left, value);
        } else {
            return search(node.right, value);
        }
    }

    // Minimum node
    public static BinaryNode minimumNode(BinaryNode root) {
        if (root.left == null) {
            return root;
        } else {
            return minimumNode(root.left);
        }
    }

    // Delete node
    public BinaryNode deleteNode(BinaryNode root, int value) {
        if (root == null) {
            System.out.println("Value not found in BST");
            return null;
        }
        if (value < root.value) {
            root.left = deleteNode(root.left, value);
        } else if (value > root.value) {
            root.right = deleteNode(root.right, value);
        } else {
            if (root.left != null && root.right != null) {
                BinaryNode temp = root;
                BinaryNode minNodeForRight = minimumNode(temp.right);
                root.value = minNodeForRight.value;
                root.right = deleteNode(root.right, minNodeForRight.value);
            } else if (root.left != null) {
                root = root.left;
            } else if (root.right != null) {
                root = root.right;
            } else {
                root = null;
            }
        }

        return root;

    }

    public void deleteBST() {
        root = null;
        System.out.println("BST has been deleted successfully");
    }

}

public class BinarySearchTree {
    public static void main(String[] args) {
        BinarySearch binarySearchTree = new BinarySearch();

        binarySearchTree.insert(70);
        binarySearchTree.insert(50);
        binarySearchTree.insert(90);
        binarySearchTree.insert(30);
        binarySearchTree.insert(60);
        binarySearchTree.insert(80);
        binarySearchTree.insert(100);
        binarySearchTree.insert(20);
        binarySearchTree.insert(40);

        binarySearchTree.preOrder(binarySearchTree.root);
        System.out.println("");
        binarySearchTree.inOrder(binarySearchTree.root);
        System.out.println("");
        binarySearchTree.postOrder(binarySearchTree.root);
    }
}


import java.util.LinkedList;
import java.util.Queue;

class BinaryNode {
    public int value;
    public BinaryNode right;
    public BinaryNode left;
}

class BinaryTreeLL {
    BinaryNode root;

    public BinaryTreeLL() {
        root = null;
    }

    public void preOrder(BinaryNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + " -> ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void postOrder(BinaryNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.value + " -> ");
    }

    public void inOrder(BinaryNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.value + " -> ");
        inOrder(root.right);
    }

    public void levelOrder() {
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode node = queue.remove();
            System.out.print(node.value + " -> ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public void searchNode(int key) {
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode node = queue.remove();
            if (node.value == key) {
                System.out.println("Found on tree");
                return;
            } else {
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        System.out.println("Value not found");
    }

    public void insertNode(int key) {
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        BinaryNode newNode = new BinaryNode();
        newNode.value = key;
        if (root == null) {
            root = newNode;
        } else {
            queue.add(root);
            while (!queue.isEmpty()) {
                BinaryNode node = queue.remove();
                if (node.left == null) {
                    node.left = newNode;
                    break;
                } else if (node.right == null) {
                    node.right = newNode;
                    break;
                } else {
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
        }
    }

    public BinaryNode getDeepestNode() {
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        BinaryNode node = null;
        while (!queue.isEmpty()) {
            node = queue.remove();
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return node;
    }

    public void deleteDeepestNode() {
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        BinaryNode node = null;
        BinaryNode previousNode = null;
        while (!queue.isEmpty()) {
            previousNode = node;
            node = queue.remove();
            if (node.left == null) {
                previousNode.right = null;
                return;
            } else if (node.right == null) {
                previousNode.left = null;
                return;
            }
            queue.add(node.left);
            queue.add(node.right);
        }
    }

    public void deleteNode(String key) {
        // Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        // queue.add(root);
        // while (!queue.isEmpty()) {
        // BinaryNode node = queue.remove();
        // if (node.value == key) {
        // node.value = getDeepestNode().value;
        // deleteDeepestNode();
        // System.out.println("Deleted Node");
        // return;
        // } else {
        // if (node.left != null) {
        // queue.add(node.left);
        // }
        // if (node.right != null) {
        // queue.add(node.right);
        // }
        // }
        // }
    }

}

public class BinaryTree {
    public static void main(String[] args) {
        BinaryTreeLL binaryTreeLL = new BinaryTreeLL();
        BinaryNode N1 = new BinaryNode();
        N1.value = 1;
        BinaryNode N2 = new BinaryNode();
        N2.value = 2;
        BinaryNode N3 = new BinaryNode();
        N3.value = 3;
        BinaryNode N4 = new BinaryNode();
        N4.value = 4;
        BinaryNode N5 = new BinaryNode();
        N5.value = 5;
        BinaryNode N6 = new BinaryNode();
        N6.value = 6;
        BinaryNode N7 = new BinaryNode();
        N7.value = 7;
        BinaryNode N8 = new BinaryNode();
        N8.value = 8;
        BinaryNode N9 = new BinaryNode();
        N9.value = 9;

        N1.left = N2;
        N1.right = N3;
        N2.left = N4;
        N2.right = N5;
        N4.left = N8;
        N4.right = N9;
        N3.left = N6;
        N3.right = N7;
        binaryTreeLL.root = N1;

        binaryTreeLL.preOrder(binaryTreeLL.root);
        System.out.println("");
        binaryTreeLL.postOrder(binaryTreeLL.root);
        System.out.println("");
        binaryTreeLL.inOrder(binaryTreeLL.root);
        System.out.println("");
        binaryTreeLL.deleteNode("N3");
        binaryTreeLL.levelOrder();
    }

    public static BinaryNode createNode(BinaryNode tempBinaryNode, int nodeValue) {
        tempBinaryNode.value = nodeValue;
        return tempBinaryNode;
    }
}

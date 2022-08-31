import java.util.ArrayList;

class GraphNode {
    public String name;
    public int index;

    public GraphNode(String name, int index) {
        this.name = name;
        this.index = index;
    }
}

class GraphClass {
    ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
    int[][] matrix;

    public GraphClass(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
        matrix = new int[nodeList.size()][nodeList.size()];
    }

    public void addVertices(int i, int j) {
        matrix[i][j] = matrix[j][i] = 1;
    }

    public void print() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print("" + matrix[i][j]);
            }
            System.out.println("");
        }
    }
}

public class Graph {
    public static void main(String[] args) {
        ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
        nodeList.add(new GraphNode("A", 0));
        nodeList.add(new GraphNode("B", 1));
        nodeList.add(new GraphNode("C", 2));
        nodeList.add(new GraphNode("D", 3));
        nodeList.add(new GraphNode("E", 4));

        GraphClass graphClass = new GraphClass(nodeList);
        graphClass.addVertices(0, 1);
        graphClass.addVertices(0, 2);
        graphClass.addVertices(0, 3);
        graphClass.addVertices(1, 4);
        graphClass.addVertices(3, 4);
        graphClass.addVertices(2, 3);
        graphClass.addVertices(3, 4);

        graphClass.print();

    }
}

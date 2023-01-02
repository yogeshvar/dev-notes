import java.util.ArrayList;

public class FindMazeExit {

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    static void printGraph(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.println("\nAdjacency list of vertex" + i);
            System.out.print("head");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(" -> " + adj.get(i).get(j));
            }
            System.out.println();
        }
    }

    static int explore(ArrayList<ArrayList<Integer>> adj, int start, int end) {
        for (int i = 1; i < adj.size(); i++) {
            for (int j = 1; j < adj.get(i).size(); j++) {
                if (start == i && adj.get(i).get(j) == end) {
                    return 1;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int edges = 2;
        int vertices = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(vertices);

        for (int i = 1; i <= vertices + 1; i++)
            adj.add(new ArrayList<Integer>());

        addEdge(adj, 1, 2);
        addEdge(adj, 3, 2);

        printGraph(adj);

        System.out.println(explore(adj, 1, 4));
    }

}

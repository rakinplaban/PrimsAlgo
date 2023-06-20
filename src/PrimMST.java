import java.util.*;

public class PrimMST {
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[][] graph = {
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {8, 11, 0, 0, 0, 0, 0, 1, 6},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };

        HashMap<Integer, Character> node = new HashMap<>();
        node.put(0, 'A');
        node.put(1, 'B');
        node.put(2, 'C');
        node.put(3, 'D');
        node.put(4, 'E');
        node.put(5, 'F');
        node.put(6, 'G');
        node.put(7, 'H');
        node.put(8, 'I');

        primMST(graph, node);
    }

    private static void primMST(int[][] graph, HashMap<Integer, Character> node) {
        int vertices = graph.length;
        int[] key = new int[vertices];  // to store the weight of edges
        int[] parent = new int[vertices];  // to store the parent nodes
        boolean[] inMST = new boolean[vertices];  // to track the vertices included in MST

        Arrays.fill(key, INF);  // initialize all keys with infinity
        Arrays.fill(inMST, false);  // no vertices included in MST initially

        key[0] = 0;  // start with the first node
        parent[0] = -1;  // first node is the root of MST

        for (int i = 0; i < vertices - 1; i++) {
            int u = findMinKeyVertex(key, inMST);
            inMST[u] = true;

            for (int v = 0; v < vertices; v++) {
                if (graph[u][v] != 0 && !inMST[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        printMST(node, parent, key);
    }

    private static int findMinKeyVertex(int[] key, boolean[] inMST) {
        int minKey = INF;
        int minKeyVertex = -1;

        for (int v = 0; v < key.length; v++) {
            if (!inMST[v] && key[v] < minKey) {
                minKey = key[v];
                minKeyVertex = v;
            }
        }

        return minKeyVertex;
    }

    private static void printMST(HashMap<Integer, Character> node, int[] parent, int[] key) {
        System.out.println("V " + node.values());
        System.out.println("T " + Arrays.toString(parent));
        System.out.println("Key " + Arrays.toString(key));

        System.out.print("p [null");
        for (int i = 1; i < parent.length; i++) {
            System.out.print(", " + node.get(parent[i]));
        }
        System.out.println("]");
    }
}

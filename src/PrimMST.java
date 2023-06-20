import java.util.*;

public class PrimMST {
    private int[][] graph;
    private int r;
    private Map<Integer, Character> node = new HashMap<>();
    private Map<Character, Integer> T_ = new HashMap<>();
    private Map<Character, Integer> key = new HashMap<>();
    private Map<Character, Character> parent = new HashMap<>();
    private PriorityQueue<Character> Q = new PriorityQueue<>(Comparator.comparingInt(key::get));

    public PrimMST(int[][] graph, int r) {
        this.graph = graph;
        this.r = r;
        initializeNode();
        initialize();
    }

    private void initializeNode() {
        for (int i = 0; i < graph.length; i++) {
            node.put(i, (char) ('A' + i));
        }
    }

    private void initialize() {
        for (int u = 0; u < node.size(); u++) {
            char nodeChar = node.get(u);
            key.put(nodeChar, Integer.MAX_VALUE);
            parent.put(nodeChar, null);
            Q.add(nodeChar);
        }

        key.put(node.get(r), 0);
    }

    public void minimumSpanningTree() {
        while (!Q.isEmpty()) {
            char u = extractMin(Q);
            T_.put(u, 1);

            for (int v = 0; v < graph.length; v++) {
                char vChar = node.get(v);
                if (!T_.containsKey(vChar) && graph[u - 'A'][v] < key.get(vChar)) {
                    parent.put(vChar, u);
                    key.put(vChar, graph[u - 'A'][v]);
                }
            }
        }

        // Print the minimum spanning tree
        System.out.println("V " + node.values());
        System.out.println("T " + T_.values());
        System.out.println("Key " + key.values());
        System.out.println("p " + parent.values());
    }

    private char extractMin(PriorityQueue<Character> q) {
        char minNode = q.poll();
        return minNode;
    }

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

        PrimMST mst = new PrimMST(graph, 0);
        mst.minimumSpanningTree();
    }
}

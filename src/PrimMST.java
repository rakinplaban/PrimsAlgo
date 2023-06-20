import java.util.*;

public class PrimMST {
    private int[][] graph;
    private int r;
    private Map<Integer, Character> node = new HashMap<>();
    private Map<Character, Integer> T_ = new HashMap<>();
    private Map<Character, Character> parent = new HashMap<>();
    private Map<Character, Integer> key = new HashMap<>();
    private Queue<Character> Q = new PriorityQueue<>(Comparator.comparingInt(key::get));

    public PrimMST(int[][] graph, int r) {
        this.graph = graph;
        this.r = r;
        initializeNode();
        initialize();
    }

    private void initializeNode() {
        int numNodes = graph.length;
        for (int i = 0; i < numNodes; i++) {
            char nodeName = (char) ('A' + i);
            node.put(i, nodeName);
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
        System.out.println("Minimum Spanning Tree:");
        for (char nodeChar : node.values()) {
            if (parent.get(nodeChar) != null) {
                System.out.println(parent.get(nodeChar) + " - " + nodeChar);
            }
        }
    }

    private char extractMin(Queue<Character> q) {
        char minNode = q.poll();
        return minNode;
    }
}
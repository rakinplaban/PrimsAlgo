import java.util.*;

public class PrimMST {
	private int[][] graph;
	private char[] vertices = new char[9];
	private Queue<Integer> Q = new PriorityQueue<Integer>();
	private int[] traverse = new int[9];
	private int[] key = new int[9];
	private char[] parent = new char[9];
	private char src;
	
	public PrimMST(int[][] graph, char[] vertices, char src) {
		this.graph = graph;
		this.vertices = vertices;
		this.src = src;
	}
	
	private int srcPosition(char src_node) {
		for (int i = 0; i < vertices.length; i++) {
			if (vertices[i] == src_node) {
				return i;
			}
		}
		return -1; 
	}
	
	private char idxToNode(int idx) {
		if (idx >= 0 && idx < vertices.length) {
			return vertices[idx];
		}
		return ' ';
	}
	
	public void minimumSpanningTree() {
		for (int u = 0; u < key.length; u++) {
			key[u] = Integer.MAX_VALUE;
			parent[u] = '\0';
			traverse[u] = 0;
		}
		
		Q.add(srcPosition(src));
		key[srcPosition(src)] = 0;
		
		while (!Q.isEmpty()) {
			int u = Q.poll();
			traverse[u] = 1; 

			for (int v = 0; v < vertices.length; v++) {
				if(graph[u][v]!=0) {
					if (graph[u][v] < key[v] && traverse[v]!=1) {
						parent[v] = idxToNode(u);
						key[v] = graph[u][v];
					}
				
					if(traverse[v]==0 && !Q.contains(v)) {
						Q.add(v);
					}else {
						continue;
					}
				}
			}

		}
		
		for (int v = 0; v < vertices.length; v++) {
			System.out.println("V "+ vertices[v]);
            System.out.println("T " + traverse[v]);
            System.out.println("key " + key[v]);
            System.out.println("prev " + parent[v]);
        }
	}
	
//	public int extractMin() {
//		int minNode = -1;
//		int minValue = Integer.MAX_VALUE;
//		
//		for (int v : Q) {
//			if (key[v] < minValue) {
//				minValue = key[v];
//				minNode = v;
//			}
//		}
//		
//		if (minNode != -1) {
//			Q.remove(minNode);
//		}
//		
//		return minNode;
//	}
}

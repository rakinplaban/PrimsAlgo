import java.util.*;

public class PrimMST {
	private int[][] graph;
	private char[] vertics;
	private Queue<Character> Q = new PriorityQueue<Character>();
	private int[] traverse;
	private int[] key;
	private char[] parent;
	private char src;
	
	public PrimMST(int[][] graph,char[] vertics,char src) {
		this.graph = graph;
		this.vertics = vertics;
		this.src = src;
	}
	
	private int srcPosition(char src_node) {
		int idx = 0;
		for(int i=0;i<vertics.length;i++) {
			if(vertics[i]==src_node) {
				idx = i;
			}
		}
		return idx;
	}
	
	public void minimumSpanningTree() {
		for(int i=0;i<vertics.length;i++) {
			Q.add(vertics[i]);
		}
		
		for(int u=0;u<Q.size();u++) {
			key[u] = Integer.MAX_VALUE;
		}
		
//		Q.remove(src);
		key[srcPosition(src)] = 0;
		parent[srcPosition(src)] = ' ';
		
		while(!Q.isEmpty()) {
			char u = ExtractMin();
			Q.remove(u);
			
			for(int v=0;v<vertics.length;v++) {
				if(Q.contains(vertics[v]) && graph[srcPosition(u)][v] != 0) {
					parent[v] = u;
				}
			}
		}
	}
	
	public char ExtractMin() {
		int min_value = Integer.MAX_VALUE;
		char node = ' ';
		for(char v : Q) {
			int idx = srcPosition(v);
			if(key[idx] < min_value) {
				min_value = key[idx];
				node = v;
			}
		}
		
		return node;
	}
}

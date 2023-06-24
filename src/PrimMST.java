import java.util.*;

public class PrimMST {
	private int[][] graph;
	private char[] vertics = new char[9];
	private Queue<Character> Q = new PriorityQueue<Character>();
	private int[] traverse = new int[9];
	private int[] key = new int[9];
	private char[] parent = new char[9];
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
	
	public void initialize() {
		for(int i=0;i<vertics.length;i++) {
			Q.add(vertics[i]);
			key[i] = Integer.MAX_VALUE;
			parent[i] = ' ';
		}
	}
	
	public void minimumSpanningTree() {
		initialize();
		
		
		key[srcPosition(src)] = 0;
		
//		traverse[srcPosition(src)] = 1;
//		Q.remove(src);
//		char source = src;
		
		while(!Q.isEmpty()) {
			char u = ExtractMin(src);
//			Q.remove(u);
			traverse[srcPosition(u)] = 1;
			
			for(int v=0;v<vertics.length;v++) {
				if(traverse[v] == 0 && graph[srcPosition(u)][v] < key[v] && graph[srcPosition(u)][v]!=0) {
					parent[v] = u;
					key[v] = graph[srcPosition(u)][v];
//					traverse[v] = 1;
				}
				System.out.println("V = " + vertics[v]);
	            System.out.println("T = " + traverse[v]);
	            System.out.println("key = " + key[v]);
	            System.out.println("parent = " + parent[v]);
			}
//			source = u;
		}
		
		for (int i=0;i<vertics.length;i++) {
            System.out.println("V = " + vertics[i]);
            System.out.println("T = " + traverse[i]);
            System.out.println("key = " + key[i]);
            System.out.println("parent = " + parent[i]);
        }
		
	}
	
	public char ExtractMin(char source) {
		int min_value = Integer.MAX_VALUE;
		char node = ' ';
		for(char v : Q) {
			int idx = srcPosition(v);
			if(graph[srcPosition(source)][idx] < min_value && graph[srcPosition(source)][idx]!=0) {
				min_value = graph[srcPosition(source)][idx];
				node = v;
			}
		}
		
		return node;
	}
	
}

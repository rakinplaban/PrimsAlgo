import java.util.*;

public class PrimMST {
	private int[][] graph;
	private char[] vertics = new char[9];
	private Queue<Integer> Q = new PriorityQueue<Integer>();
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
	
	private char idx_To_Node(int idx) {
		for(int i=0;i<vertics.length;i++) {
			if(i == idx) {
				return vertics[i];
			}
		}
		return ' ';
	}
	
	public void minimumSpanningTree() {
		for(int u=0;u<key.length;u++) {
			key[u] = Integer.MAX_VALUE;
			parent[u] = '\0';
		}
		Q.add(srcPosition(src));
		key[srcPosition(src)] = 0;
		
		while (!Q.isEmpty()) {
	        int u = ExtractMin();
	        traverse[u] = 1;

	        for (int v = 0; v < vertics.length; v++) {
//	            if(graph[u][v]!=0) {
	            if (graph[u][v] < key[v]) {
	            	parent[v] = idx_To_Node(u);
	            	key[v] = graph[u][v];
	            }

//	            	Q.add(v);
//	            }
	        
				System.out.println("V = " + vertics[v]);
	            System.out.println("T = " + traverse[v]);
	            System.out.println("key = " + key[v]);
	            System.out.println("parent = " + parent[v]);
			}
//			source = u;
		}
		
//		for (int i=0;i<vertics.length;i++) {
//            System.out.println("V = " + vertics[i]);
//            System.out.println("T = " + traverse[i]);
//            System.out.println("key = " + key[i]);
//            System.out.println("parent = " + parent[i]);
//        }
		
	}
	
	public int ExtractMin() {
	    int min_value = Integer.MAX_VALUE;
	    int node = -1;

	    for (int v : Q) {
	        if (key[v] < min_value) {
	            min_value = key[v];
	            node = v;
	        }
	    }
	    
	    if(node!=-1) {
	    	Q.remove(node);
	    }

	    return node;
	}

	
}

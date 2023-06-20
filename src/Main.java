
public class Main {
	public static void main(String[] args) {
	
		int[][] G = {{0,4,0,0,0,0,0,8,0},
				   {4,0,8,0,0,0,0,11,0},
				   {0,8,0,7,0,4,0,0,2},
				   {0,0,7,0,9,14,0,0,0},
				   {0,0,0,9,0,10,0,0,0},
				   {0,0,4,14,10,0,2,0,0},
				   {8,11,0,0,0,0,0,1,6},
				   {0,0,2,0,0,0,6,7,0}};
		
		PrimMST mst = new PrimMST(G, 0);
        mst.minimumSpanningTree();
	}
}
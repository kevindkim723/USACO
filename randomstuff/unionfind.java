
public class unionfind {
	/*
	 * union data structure, determines if two nodes are connected on a path using 1d array.
	 */
	static class unionstruct{
		private int[] nodes;
		private int[] heights;
		
		public unionstruct(int n)
		{
			heights = new int[n];
			nodes = new int[n];
			for (int i = 0; i < n; i++)
			{
				nodes[i]=i;
				heights[i] = 0;
			}
		}
		/*
		 * returns true if node i and node j are interconnected by 
		 * checking to see if they share a root node
		 */
		public boolean connected(int i, int j)
		{
			return find(i) == find(j);
		}
		/*
		 * returns the root node with path compression
		 * in which when finding the root, every node that gets traversed has the root value.
		 */
		public int find(int i)
		{
			int height = 0;
			int root = i;
			while (root != nodes[root])
			{
				root = nodes[root];
				height++;
			}
			while (i != root)
			{
				int nextnode = nodes[i];
				nodes[i] = root;
				i = nextnode;
				height--;
				

			}
			heights[root] = height;
			return i;
		}
		
		/*
		 * merges the subtrees that node i and node j are apart of by setting their roots equal
		 */
		public void merge(int i, int j)
		{
			int root_i = find(i);
			int root_j = find(j);
			
			int height_i = heights[root_i];
			int height_j = heights[root_j];
			
			if (height_i > height_j)
			{
				nodes[root_j] = root_i;
			}
			else if (height_j > height_i)
			{
				nodes[root_i] = root_j;
			}
			else
			{
				nodes[root_i] = root_j;
			}
			
			
		}
		public String toString()
		{
			String l1 = "";
			String l2 = "";
			for (int i = 0; i < nodes.length;i++)
			{
				l1 += " " + i;
				l2 += " " + nodes[i];
			}
			return l1 + "\n" + l2;
		}
	}
	public static void main(String[] args)
	{
		unionstruct tree = new unionstruct(10);
		
		tree.merge(0,1);
		tree.merge(2, 3);
		tree.merge(3, 4);
		tree.merge(2, 5);
		tree.merge(1, 2);
		System.out.println(tree);
		
		
	}
}

import java.io.*;
import java.util.*;
public class milkvisits2 {
	public static void main(String[] args) throws Exception
	{
		BufferedReader fin = new BufferedReader(new FileReader("milkvisits.in"));
		PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
		StringTokenizer st = new StringTokenizer(fin.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		String[] s = fin.readLine().split("");
		boolean[][] arr = new boolean[n][n];
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		ArrayList<HashSet<Integer>> map = new ArrayList<HashSet<Integer>>();

		//construct adjacency matrix of graph representation
		for (int i = 0; i < n; i++)
		{
			
			adj.add(new ArrayList<Integer>());
			map.add(new HashSet<Integer>());

		}
		for (int i = 0; i < n-1; i++)
		{
			st = new StringTokenizer(fin.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj.get(a-1).add(b-1);
			adj.get(b-1).add(a-1);
			
			
		}
		//System.out.println(adj);
		//printMat(arr);
		

		
		
		for (int i = 0; i < adj.size() && !map.contains(i); i++)
		{
			HashSet<Integer> visited = new HashSet<Integer>();
			
		
			DFS(map, adj, s,visited, i, i);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++)
		{
			st = new StringTokenizer(fin.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			String c = st.nextToken();
			
			if (a==b)
			{
				sb.append( (s[a-1].equals(c) ? 1 : 0) );
			}
			else
			{
				if (map.get(a-1).contains(b-1))
				{
					sb.append( (s[a-1].equals(c) ? 1 : 0) );
				}
				else
				{
					sb.append(1);
				}
			}
		}
		fout.println(sb.toString());
		//System.out.println(map);
		//System.out.println(sb.toString());
		fout.close();
		
		
	}
	/*public static void DFS(HashMap<Integer,HashSet<Integer>> map, boolean[][] arr, String[] s, HashSet<Integer> visited, int node, int prev)
	{
		if (visited.contains(node))
		{
			return;
		}
		visited.add(node);
		for (int i = 0; i < arr[0].length; i++)
		{
			if (arr[node][i] == true && s[i].equals(s[prev]))
			{
				//System.out.println("NODE: " + node);
				//System.out.println("I: " + i);
				map.get(prev).add(i);
				map.get(i).add(node);
				map.get(node).add(i);
				DFS(map, arr, s, visited, i, prev);
			}
		}
	}*/
	public static void DFS(ArrayList<HashSet<Integer>> map, ArrayList<ArrayList<Integer>> adj, String[] s, HashSet<Integer> visited, int node, int prev)
	{
		
		if (visited.contains(node))
		{
			return;
		}
		visited.add(node);
		for (int j : adj.get(node))
		{
			if (j==prev)
			{
				continue;
			}
				
			if (s[j].equals(s[prev]))
			{
				map.get(prev).add(j);
				map.get(j).add(prev);

				DFS(map, adj, s, visited, j, prev);
				
			}
		}
		
		
	}
	
	public static void printMat(boolean[][] mat)
	{
		for (int i = 0; i < mat.length;i++)
		{
			for (int j = 0; j < mat[0].length; j++)
			{
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}
}

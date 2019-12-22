import java.io.*;
import java.util.*;

//solution uses adjacency matrix to represent a graph and traverses every node with a DFS
public class silver3 {
	public static void main(String[] args) throws IOException {
		BufferedReader fin = new BufferedReader(new FileReader("moocast.in"));
		PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));

		int n = Integer.parseInt(fin.readLine());
		int[] x = new int[n];
		int[] y = new int[n];
		int[] r = new int[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(fin.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
			r[i] = Integer.parseInt(st.nextToken());

		}
		//filling adjacency matrix
		boolean[][] transmit = new boolean[n][n];
		//both i and j must start from 0 to properly fill the 2d array to the limit
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if ((x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j]) <= r[i] * r[i] || i==j) {
					transmit[i][j] = true;
				}
				else
				{
					transmit[i][j] = false;
				}
			}
		}
		int pathHigh = 1;
		for (int i = 0; i < n; i++)
		{
			HashSet<Integer> visited = new HashSet<Integer>();
			pathHigh = Math.max(pathHigh, dfs(visited,transmit, i));
		}
		fout.println(pathHigh);
		System.out.println(pathHigh);
		fout.close();
		
		
		
	}
	
	public static int dfs(HashSet<Integer> visited, boolean[][] matrix, int node)
	{
		//if you are at a visited node return 0;
		if(visited.contains(node))
		{
			return 0;
		}
		//if this node isn't visited add this to visited and recurse
		visited.add(node);
		int pathLength = 1;
		for (int i = 0; i < matrix[node].length; i++)
		{
			if (matrix[node][i] == true)
			{
				pathLength += dfs(visited, matrix, i);
			}
		}
		return pathLength;
	}
}

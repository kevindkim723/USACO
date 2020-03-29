import java.io.*;
import java.util.*;


public class clocktree {
	static int total= 0;
	public static void main(String[] args) throws IOException
	{
		BufferedReader fin = new BufferedReader(new FileReader("clocktree.in"));
		PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("clocktree.out")));

		int n = Integer.parseInt(fin.readLine());
		
		StringTokenizer st = new StringTokenizer(fin.readLine());
		int[] weights = new int[n];
		System.out.println(n);
		for (int i = 0; i < n; i++)
		{
			weights[i] = Integer.parseInt(st.nextToken());
		}
		LinkedList<Integer> adj[] = new LinkedList[n];
		for(int i = 0; i < n; i++)
		{
			adj[i]=(new LinkedList<Integer>());
		}
		
		for (int i  = 0 ; i < n-1; i++)
		{
			st = new StringTokenizer(fin.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			//System.out.printf("%s + %s\n" , a,b);
			adj[a].add(b);
			adj[b].add(a);
		}
	
		//dfs(adj, weights, 0, visited);
		//System.out.println(Arrays.toString(weights));
		for (int i = 0 ; i <n ;i++)
		{
			// System.out.println(adj.clone());

			//LinkedList<LinkedList<Integer>> clone =  adj.clone();
			boolean[] visited = new boolean[n];
			boolean[] clear = new boolean[n];
			int[] arr = weights.clone();
			arr[i] = time(arr[i]-1);	
			dfs(adj, arr,i,visited,clear, n);
			System.out.println(Arrays.toString(arr));
		}
		System.out.println(total);
		fout.close();
		/*int[] weightcopy = weights.clone();
		weights[1]--;
		//dfs(adj,weights, 1,visited,cleared);
		weightcopy[3]--;
		System.out.println(Arrays.toString(weights));
		System.out.println("DFS 2");
		//dfs2(adj, weightcopy, 3, visited,n);
		System.out.println(Arrays.toString(weightcopy));*/
	}
	public static void dfs(LinkedList<Integer> adj[], int[] weights, int pos, boolean[] visited, boolean[] clear, int left)
	{
	
		if (visited[pos] == true) // if this node has already been visited we do not want to process that node again.
		{
			return;
		}
		//System.out.println(pos);
		visited[pos] = true; // mark as visited
		weights[pos] = time(weights[pos]+1);//add 1 to the node since cow visited
		//System.out.println("Visited " + pos + " it is now " + weights[pos]);
		if (left == 1)
		{
			if (weights[pos]-1 == 0)
			{
				total+=1;
			}
			else System.out.println("Mmoo");
			return;
		}
		Iterator<Integer> itr = adj[pos].iterator();
		while(itr.hasNext())
		{
			dfs(adj, weights,itr.next(), visited,clear,left);
		}
		//System.out.println("its a fucking leaf/ended");	
		//assuming we reached the end of the search, we must be at a leaf
		itr = adj[pos].iterator();
		while (itr.hasNext())
		{//we iterate its adjacent nodes again to find the root nodes (assuming it's a leaf/ all other nodes are cleared)
			int node = itr.next();
			if (!clear[node]) //if the adjacent node has not been cleared
			{
				clear[pos] = true; // we clear this NOT ROOT node
				//System.out.printf("leaf pos:%s,weight: %s\nroot pos: %s, weight:%s\n", pos, weights[pos], node, weights[node]);
				weights[node] = time(weights[node] + 12 - weights[pos]);
				//System.out.printf("UPDATE\nleaf pos:%s,weight: %s\nroot pos: %s, weight:%s\n", pos, weights[pos], node, weights[node]);
				weights[pos] = 12; //this node is 12, we are good.
				left--;
				//adj[node].remove(Integer.valueOf(pos)); //remove the leaf
				visited[node] = false; //we can visit the root again!
				dfs(adj, weights, node, visited, clear,left);
			}
		}
		
		
		
		
	}
	/*public static void dfs2(LinkedList<Integer> adj[], int[] weights, int pos, boolean[] visited, int left)
	{
		
		if (visited[pos] == true) // if this node has already been visited we do not want to process that node again.
		{
			return;
		}
		System.out.println(pos);
		visited[pos] = true; // mark as visited
		weights[pos] = time(weights[pos]+1);//add 1 to the node since cow visited
		if(left==1)
		{
			if(weights[pos]==12)
			{
				System.out.println("yessirrr");
			}
			else
			{
				System.out.println("nah");
			}
			return;
		}
		if (adj[pos].size() == 1) //we are assuming we are at a leaf
		{
			int root = adj[pos].get(0); // the root is the only node connected to the leaf
			weights[root] = time(weights[root] + 12 - weights[pos]);
			weights[pos] = 12;
			adj[root].remove(Integer.valueOf(pos)); //remove the leaf
			//adj.remove(pos);
			left--;
			visited[root] = false; //we can visit the root again!
			dfs2(adj, weights, root, visited,left);

		}
		else //assuming we are not at a leaf. we want to run dfs on all its nodes
		{
			Iterator<Integer> itr = adj[pos].iterator();
			while(itr.hasNext())
			{
				dfs2(adj, weights,itr.next(), visited,left);
			}
		}
		
	}*/
	public static int time(int n)
	{
		return n%12 == 0 ? 12 : n%12;
	}



		
			

		

}

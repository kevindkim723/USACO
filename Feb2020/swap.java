import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;
public class swap {
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new FileReader("swap.in"));
	
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("swap.out")));
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int k = Integer.parseInt(s[1]);
		int m = Integer.parseInt(s[2]);
		int[] arr = new int[100001];	
		for (int i = 0; i < n; i++)
		{
			arr[i] = i+1; 
		}
		StringTokenizer st = null;

		for (int i = 0; i < k;i++)
		{
			st = new StringTokenizer(br.readLine());

			int l = Integer.parseInt(st.nextToken())-1;
			int r = Integer.parseInt(st.nextToken())-1;

			for (int j = 0; j <= (r-l)/2; j++)
			{
				int temp = arr[l+j];
				arr[l+j] = arr[r-j];
				arr[r-j] = temp;
				
			}
		}
		
		LinkedList<Integer> cycles = new LinkedList<Integer>();

		boolean[] visited = new boolean[n+1];
		for (int i = 1; i <= n; i++) {
			
			if (!visited[i])
			{
				cycles.clear();
				visited[i] = true;
				int start = arr[i-1];
				cycles.add(i);
				while (start != i)
				{
					visited[start] = true;
					cycles.add(start);
					
					start = arr[start-1];

				}
				int mod = m%cycles.size();
				for (int j = 0; j < cycles.size(); j++)
				{
					arr[cycles.get(j)-1] =cycles.get((j+mod)%cycles.size());
				}
				

				
			}
		}
		for (int i = 0; i < n; i++)
		{
			out.println(arr[i]);
		}
		out.close();
		br.close();
		
		


	}


}

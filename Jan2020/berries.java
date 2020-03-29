import java.io.*;
import java.util.*;

public class berries {

	public static void main(String[] args) throws Exception {
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("berries.out")));

		BufferedReader br = new BufferedReader(new FileReader("berries.in"));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		LinkedList<Integer> arr = new LinkedList<Integer>();
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens())
		{
			arr.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(arr);
		
		int counter = arr.get(n-1-k/2);
		//System.out.println(counter);
		
		LinkedList<Integer> arr2 = new LinkedList<Integer>();
		
		for (int i = n-k/2; i < n; i++)
		{
			arr.add(arr.get(i) - counter);
			arr.set(i, counter);
		}
		Collections.sort(arr);
		//System.out.println(arr);
		int sum = 0;
		for (int i = arr.size()-k; i < arr.size()-k/2;i++)
		{
			sum+=arr.get(i);
		}
		System.out.println(sum);
		out.close();
	}

}

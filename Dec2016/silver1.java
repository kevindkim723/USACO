import java.io.*;
import java.util.*;
public class silver1 {
	public static void main(String[] args) throws IOException
	{
		BufferedReader fin = new BufferedReader(new FileReader("haybales.in"));
		PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("haybales.out")));
		
		StringTokenizer st = new StringTokenizer(fin.readLine());
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		st = new StringTokenizer(fin.readLine());
		for (int i = 0; i < n; i++)
		{
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		
		for (int i = 0; i < q; i++)
		{
			st = new StringTokenizer(fin.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			System.out.println(search(arr, b) - search(arr,a-1));
			
		}
		fout.close();
	}
	public static int search(int[] arr, int n) //gives numbers before this number in the array
	{
		if (arr[0] > n)
		{
			return 0;
		}
		int l = 0, r = arr.length - 1; 
        while (l != r)
        {
        	int mid = (l+r+1)/2;
        	if (arr[mid] <= n)
        	{
        		l = mid;
        	}
        	else
        	{
        		r = mid-1;
        	}
        }
        return l+1;
	}
}

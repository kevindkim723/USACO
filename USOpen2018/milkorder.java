package USOpen2018;
import java.io.*;
import java.util.*;

public class milkorder {
	public static void main(String[] args) throws IOException
	{
		BufferedReader fin = new BufferedReader(new FileReader("milkorder.in"));
		PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("milkorder.out")));
		String[] arr = fin.readLine().split(" ");
		int first = Integer.parseInt(arr[0]);
		int second = Integer.parseInt(arr[1]);
		int third = Integer.parseInt(arr[2]);
		String[] arr2 = fin.readLine().split(" ");
		int[] line = new int[first];
		Arrays.fill(line, 0);
		for (int i = 0; i < third; i++)
		{
			String[] input = fin.readLine().split(" ");
			line[Integer.parseInt(input[1])-1] = Integer.parseInt(input[0]);
		}
		ArrayList<Integer> selective = new ArrayList<Integer>();
		for (int i = 0; i < second; i++ )
		{
			 selective.add(Integer.parseInt(arr2[i]));
		}
		ArrayList<Integer> line2 = new ArrayList<Integer>();
		for (int i : line)
		{
			line2.add(i);
		}
		System.out.println(line2);
		System.out.println(selective);
		for (int i = 0; i < second; i++)
		{
			if (line2.contains(selective.get(i)))
			{
				int w = i;
				for (int k = line2.indexOf(selective.get(i));k >=0 && w>=0;k--, w--)
				{
					line2.set(k, selective.get(w));
				}
				
			}
				
		}
		System.out.println(line2);
		fout.println(line2.indexOf(0)+1);
		fout.close();
		fin.close();
		
		
	}
}

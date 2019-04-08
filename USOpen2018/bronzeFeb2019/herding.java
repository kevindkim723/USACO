//package bronzeFeb2019;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class herding {
	public static void main(String[] args) throws IOException
	{
		int ans1 =0, ans2=0;
		BufferedReader fin = new BufferedReader(new FileReader("herding.in"));
		PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("herding.out")));
		String[] arr = 	fin.readLine().split(" ");
		int[] x = new int[3];
		for (int i = 0; i < 3; i++ )
		{
			x[i] = Integer.parseInt(arr[i]);
		}
		Arrays.sort(x);
		//base case all consecutive
		if (isConsecutive(x))
		{
			ans1 = 0;
			ans2 = 0;
		}
		else
		{
			Integer diff1 = x[1]-x[0];
			Integer diff2 = x[2] - x[1];
			
			if (diff1 == 2 || diff2 == 2)
			{
				ans1 = 1;
			}
			else
			{
				ans1 = 2;
			}
			if (diff1.compareTo(diff2) == 1)
			{
				ans2 = diff1 -1;
			}
			else
			{
				ans2 = diff2 -1;
			}
			
		}
		fout.println(ans1);
		fout.println(ans2);
		fout.close();
		
		
		
		
	}
	private static boolean isConsecutive(int[] a)
	{
		if(a[0]==(a[1]-1) && a[1] == (a[2]-1))
		{
			return true;
		}
		return false;
	}
}

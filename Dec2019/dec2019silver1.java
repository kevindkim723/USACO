package Dec2019;
import java.io.*;
import java.util.*;

public class dec2019silver1 {
	public static void main(String[] args) throws IOException {
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moobuzz.out")));

		BufferedReader br = new BufferedReader(new FileReader("moobuzz.in"));
		int a = Integer.parseInt(br.readLine())-1;
		int[] arr = {1,2,3,1,3,2,1,2};
		int number = 1;
		for (int i = 0; i < a; i++)
		{
			number += arr[i%8];
		}
		out.println(number);
		
		out.close();
	
	}
}

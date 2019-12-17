package bronzeDec2018;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class billboard {
	public static void main(String[] args) throws IOException
	{
		BufferedReader fin = new BufferedReader(new FileReader("teleport.in"));
		PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("teleport.out")));
		StringTokenizer st = new StringTokenizer(fin.readLine());
		
		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());
		int x2 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(fin.readLine());		
		int bx1 = Integer.parseInt(st.nextToken());
		int by1 = Integer.parseInt(st.nextToken());
		int bx2 = Integer.parseInt(st.nextToken());
		int by2 = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(fin.readLine());
		int truckx1 = Integer.parseInt(st.nextToken());
		int trucky1 = Integer.parseInt(st.nextToken());
		int truckx2 = Integer.parseInt(st.nextToken());
		int trucky2= Integer.parseInt(st.nextToken());
		
		int a1 = Math.abs((x1-x2)*(y1-y2));
		int a2 = Math.abs((bx1-bx2)*(by1-by2));
		
		int c1, c2;
		if (truckx1 >= x2 || trucky1>= y2 || truckx2 <= x1 || trucky2 <= y1)
		{
			c1 = 0;
		}
		if (truckx1 >= bx2 || trucky1>= by2 || truckx2 <= bx1 || trucky2 <= by1)
		{
			c2 = 0;
		}
		if (inBetween(truckx1,))
		
		
	}

	public static boolean inBetween(int a, int b, int c) {
		return (a > b && a < c);
	}
}

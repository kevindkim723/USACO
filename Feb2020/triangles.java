import java.util.*;
import java.io.*;

public class triangles {
	public static void main(String[] args) throws Exception
	{
		BufferedReader fin = new BufferedReader(new FileReader("triangles.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("triangles.out")));
		int n = Integer.parseInt(fin.readLine());
		ArrayList<Integer> xcoords = new ArrayList<Integer>();
		ArrayList<Integer> ycoords = new ArrayList<Integer>();

		LinkedList<Integer> arrx[] = new LinkedList[100000];
		LinkedList<Integer> arry[] = new LinkedList[100000];
		for (int i = 0; i < n; i++)
		{
			StringTokenizer st = new StringTokenizer(fin.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if (!xcoords.contains(x))
			{
				xcoords.add(x);
			}
			arrx[x].add(y);
			arry[y].add(x); 
			if (!ycoords.contains(y))
			{   
				ycoords.add(y)
			}
		}
		for (int i : xcoords)
		{
			Collections.sort(arrx[i]);
		}
		for (int i : ycoords)
		{
			
			Collections.sort(arry[i]);
		}

		for (int i = 
		for (int i = 0; i < xcoords.size(); i++)
		{
					

		
			

}

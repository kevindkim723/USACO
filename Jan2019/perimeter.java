import java.io.*;
import java.util.*;
public class perimeter {
	public static void main(String[] args) throws IOException
	{
		BufferedReader fin = new BufferedReader(new FileReader("perimeter.in"));
		PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("perimeter.out")));

		int n = Integer.parseInt(fin.readLine());
		int[][] grid = new int[n][n];
		
		for (int i = 0; i < n; i++)
		{
			String[] s = fin.readLine().split("");
			for (int j = 0; j < n; j++)
			{
				grid[i][j] = (s[j].equals("#") ? 1 : 0);
			}
		}
		
		//System.out.println(Arrays.deepToString(grid));
		int maxp = 0;
		int maxa = 0;
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if (grid[i][j] != 0 && grid[i][j] !=2)
				{
					int[] x = fill(grid, i, j);
					if (maxa == x[0])
					{
						maxp = Math.min(maxp, x[1]);
					}
					else
					{
						maxa = Math.max(maxa, x[0]);
						if (maxa == x[0])
						{
							maxp = x[1];
						}
					}
			
					
						
							
				}
			}
		}
		fout.println(maxa + " " + maxp);
		fout.close();
	}
	public static int[] fill(int[][] grid, int i, int j)
	{
		//int[] x is in the form {area, perimeter}
		//if this new grid is outside boundaries then perimeter will be increased by 1
		if (i < 0 || i >= grid.length|| j < 0 || j>= grid[0].length)
		{
			int[] x = {0,1};
			return x;
		}
		//if this new grid is not ice cream then increase perimeter by 1
		if (grid[i][j] == 0)
		{
			int[] x = {0,1};
			return x;
		}
		if (grid[i][j] == 2)
		{
			int[] x = {0,0};
			return x;
		}
		//if this current tile is true (1), then increase the area by one
		int[] x = {1,0};
		grid[i][j] = 2;

		int[] up = fill(grid, i-1,j);
		int[] down = fill(grid, i+1,j);
		int[] left = fill(grid, i,j-1);
		int[] right = fill(grid, i, j+1);
		x[0] += up[0] + down[0] + left[0] + right[0];
		x[1] += up[1] + down[1] + left[1] + right[1];
		return x;

		
	}
	
}

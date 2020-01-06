import java.io.*;
import java.util.*;

public class multimoo {
	public static void main(String[] args) throws IOException {
		BufferedReader fin = new BufferedReader(new FileReader("multimoo.in"));
		PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("multimoo.out")));

		int n = Integer.parseInt(fin.readLine());
		int[][] grid = new int[n][n];
		int[][] gridoriginal = new int[n][n];
		ArrayList<Integer> names = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			String[] s = fin.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				grid[i][j] = (int) Math.pow(Integer.parseInt(s[j])+1,2);
				gridoriginal[i][j] = (int) Math.pow(Integer.parseInt(s[j])+1,2);

				if (!names.contains(grid[i][j])) names.add(grid[i][j]);

			}
		}
		Collections.sort(names);

		//print(grid);
		int maxa = 0;
		int maxb = 0;
		//for only one cow 
		for (int z : names)
		{
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
						if (grid[i][j] == z)
						{
							maxa = Math.max(maxa, fill(grid, i,j,z));
						}
				}
			}
		}
		

		//for double cows
		for (int i = 0; i < names.size()-1; i++)
		{
			int n1 = names.get(i);

			for (int j = i+1; j < names.size(); j++)
			{
				int n2 = names.get(j);
				int[][] gridcopy = copy(gridoriginal);

				System.out.println("n1: " + n1 + " n2: " + n2);
				for (int k = 0; k < n; k++) {
					for (int l = 0; l < n; l++) {
							if (gridcopy[k][l] == n1 || gridcopy[k][l] == n2)
							{
								//print(gridcopy);
								//System.out.println(gridcopy[k][l]);
								//System.out.println("AT " + k + ", " + l);
								maxb = Math.max(maxb, fill2(gridcopy,k,l,n1,n2));
								//System.out.println("MAX AREA: " + maxb);
							}
					}
				}
			}
		}
		System.out.println(maxa);
		System.out.println(maxb);
		fout.println(maxa);
		fout.println(maxb);
		fout.close();

		
		
	}

	public static int fill(int[][] grid, int i, int j, int num) {
		// int[] x is in the form {area, perimeter}
		// if this new grid is outside boundaries then perimeter will be increased by 1
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
			
			return 0;
		}
		// if this new grid is not ice cream then increase perimeter by 1
		if (grid[i][j] != num) {
			return 0;
		}
		if (grid[i][j] == num+1) {
			
			return 0;
		}
		// if this current tile is true (1), then increase the area by one
		int x = 1;
		grid[i][j] = num + 1;

		x +=  fill(grid, i - 1, j,num) + fill(grid, i + 1, j,num) + fill(grid, i, j - 1,num) + fill(grid, i, j + 1,num);

		return x;

	}
	public static int fill2(int[][] grid, int i, int j, int num1, int num2) {
		// int[] x is in the form {area, perimeter}
		// if this new grid is outside boundaries then perimeter will be increased by 1
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
			
			return 0;
		}
		// if this new grid is not ice cream then increase perimeter by 1
		if (grid[i][j] != num1 && grid[i][j] != num2) {
			return 0;
		}
		if (grid[i][j] == num1+1 || grid[i][j] == num2+1) {
			
			return 0;
		}
		// if this current tile is true (1), then increase the area by one
		int x = 1;
		grid[i][j] = grid[i][j]+1;

		x +=  fill2(grid, i - 1, j,num1,num2) + fill2(grid, i + 1, j,num1,num2) + fill2(grid, i, j - 1,num1,num2) + fill2(grid, i, j + 1,num1,num2);

		return x;

	}
	public static void print(int[][] arr)
	{
		for (int i = 0 ; i < arr.length; i++)
		{
			System.out.println();
			for (int j = 0; j < arr.length; j++)
			{
				System.out.print(arr[i][j]+ " ");
			}
		}
	}
	public static int[][] copy(int[][] arr)
	{
		int[][] copy = new int[arr.length][arr.length];
		for (int i = 0 ; i < arr.length; i++)
		{
			copy[i] =arr[i].clone();
		}
		return copy;
	}

}

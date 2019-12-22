

import static java.lang.System.out;
import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class moocryption {
	static String s = "";

	public static void main(String[] args) throws IOException {
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		BufferedReader fin = new BufferedReader(new FileReader("/root/moocryption.in"));
		String l = fin.readLine();
		int rows = Integer.parseInt(l.split(" ")[0]);
		int cols = Integer.parseInt(l.split(" ")[1]);
		// out.println(cols);
		String[][] grid = new String[rows][cols];
		for (int i = 0; i < rows; i++) {
			grid[i] = fin.readLine().split("");
		}

		for (int i = 0; i < rows; i++) {
			for (int k = 0; k <= cols - 3; k++) {
				String x = grid[i][k] + grid[i][k + 1] + grid[i][k + 2];
				String reverseX = reverse(x);
				if (doubleO(x)) {
					out.println("put horizontal");
					hm.put(x, (hm.containsKey(x)) ? hm.get(x) + 1 : 1);
				}
				if (doubleO(reverseX)) {
					hm.put(x, (hm.containsKey(reverseX)) ? hm.get(reverseX) + 1 : 1);
				}

			}
		}

		for (int i = 0; i < cols; i++) {
			// out.println(i);
			for (int k = 0; k <= rows - 3; k++) {
				String x = grid[k][i] + grid[k + 1][i] + grid[k + 2][i];
				// out.println(x);
				String reverseX = reverse(x);
				if (doubleO(x)) {
					out.println("put vertical");
					hm.put(x, (hm.containsKey(x)) ? hm.get(x) + 1 : 1);
				}
				if (doubleO(reverseX)) {
					hm.put(x, (hm.containsKey(reverseX)) ? hm.get(reverseX) + 1 : 1);
				}

			}
		}

		try {
			printDiags(grid, 0, 0);

		} catch (Exception e) {
			for (int i = 0; i < s.length() / 3; i += 3) {
				String x = s.substring(i, i + 3);
				String reverseX = reverse(x);
				if (doubleO(x)) {
					out.println("put DIAGONAL1");
					hm.put(x, (hm.containsKey(x)) ? hm.get(x) + 1 : 1);
				}
				if (doubleO(reverseX)) {
					hm.put(x, (hm.containsKey(reverseX)) ? hm.get(reverseX) + 1 : 1);
				}
			}
		}
		String[][] grid2 = rotate(grid);
		s = "";
		try {
			printDiags(grid2, 0, 0);

		} catch (Exception e) {
			for (int i = 0; i < s.length() / 3; i += 3) {
				String x = s.substring(i, i + 3);
				String reverseX = reverse(x);
				if (doubleO(x)) {
					out.println("put DIAGONAL");
					hm.put(x, (hm.containsKey(x)) ? hm.get(x) + 1 : 1);
				}
				if (doubleO(reverseX)) {
					hm.put(reverseX, (hm.containsKey(reverseX)) ? hm.get(reverseX) + 1 : 1);
				}
			}
		}
		int biggest = 0;
		for (String s : hm.keySet()) {
			biggest = (hm.get(s) > biggest) ? hm.get(s) : biggest;
		}
		out.println(biggest);
		out.println(hm);
		out.println("***");
		printArray(grid);

	}

	public static void printArray(String[][] arr) {

		for (int i = 0; i < arr.length; i++) {
			for (int k = 0; k < arr[i].length; k++) {
				out.print(arr[i][k]);
			}
			out.println();
		}
	}

	public static String reverse(String s) {
		StringBuilder sb = new StringBuilder(s);
		sb = sb.reverse();
		return sb.toString();

	}

	public static boolean doubleO(String x) {
		return (x.charAt(0) == x.charAt(1) && x.charAt(0) != x.charAt(2)
				|| x.charAt(0) == x.charAt(2) && x.charAt(2) != x.charAt(1)
				|| x.charAt(2) == x.charAt(1) && x.charAt(2) != x.charAt(0));

	}

	public static String[][] rotate(String[][] arr) {
		String[][] newArr = new String[arr[0].length][arr.length];
		for (int i = 0; i < arr[0].length; i++) {
			for (int k = 0; k < arr.length; k++) {
				newArr[arr[0].length - i - 1][k] = arr[k][i];
			}
		}
		return newArr;
	}

	public static void printDiags(String[][] grid, int row, int col) throws Exception {

		int i = col;
		if (row > grid.length - 1) {
			if (col > grid[0].length - 1) {
				throw new Exception();
			} else {
				for (int j = row - 1; j >= 0 && i < grid[0].length; j--) {

					s += grid[j][i];

					i++;
				}

				printDiags(grid, row, col + 1);
			}
		}
		for (int j = row; j >= 0 && i < grid[0].length; j--) {
			s += grid[j][i];
			i++;
		}
		printDiags(grid, row + 1, col);

	}

}

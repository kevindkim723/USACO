package Dec2019;
import java.io.*;
import java.util.*;

public class dec2019p1 {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new FileReader("gymnastics.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gymnastics.out")));
		int k = scanner.nextInt();
		int n = scanner.nextInt();

		int total = k * n * (n -1) / 2;

		int[][] matrix = new int[k][n];
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = scanner.nextInt();
			}
		}
		for (int i = 0; i < matrix[0].length - 1; i++) {
			for (int j = i + 1; j < matrix[0].length; j++) {
				for (int a = 0; a < matrix.length; a++) {
					if (search(matrix[a], matrix[0][i]) > search(matrix[a], matrix[0][j])) {
						total -= k;
						break;
					}
				}

			}

		}
		total /= k;
		out.println(total);
		out.close();
	}

	public static int search(int[] array, int i) {
		for (int x = 0; x < array.length; x++) {
			if (array[x] == i) {
				return x;
			}
		}
		return -1;
	}

}

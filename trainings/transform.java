package trainings;
/*
ID: dodocan1
LANG: JAVA
TASK: transform
*/
import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class transform {
	public static void main(String[] args) throws IOException {
		BufferedReader fin = new BufferedReader(new FileReader("transform.in"));
		PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
		int l = Integer.parseInt(fin.readLine());
		String[][] orig = new String[l][l];

		for (int i = 0; i < l; i++) {
			orig[i] = fin.readLine().split("");
		}
		String[][] trans = new String[l][l];
		for (int i = 0; i < l; i++) {
			trans[i] = fin.readLine().split("");
		}
		
		if (matchR(orig, trans, 0)) {
			if (same(orig, rotate(trans))) {
				fout.println("1");
			} else if (same(orig, rotate(rotate(trans)))) {
				fout.println("2");
			} else {
				fout.println("3");
			}
		} else if (matchR(orig, reflected(trans), 0)) {
			fout.println("5");
		} else {
			if (same(orig, trans)) {
				fout.println("6");
			} else if (same(orig, reflected(trans))) {
				fout.println("4");
			} else {
				fout.println("7");
			}
		}
		fout.close();
		fin.close();
	}

	// rotates 90 degrees clockwise
	public static String[][] rotate(String[][] arr) {
		int length = arr.length;
		String[][] newArr = new String[length][length];
		for (int i = length - 1; i >= 0; i--) {
			for (int k = 0; k < length; k++) {
				newArr[k][length - i - 1] = arr[i][k];
			}
		}
		return newArr;
	}

	// 1st parameter, template
	// 2nd parameter, rotated
	// 3rd parameter input 0
	public static boolean matchR(String[][] arr, String[][] arr2, int x) {
		if (x == 2) {
			return same(arr, rotate(arr2));
		}
		String[][] arr3 = rotate(arr2);
		return same(arr, arr3) || matchR(arr, arr3, x + 1);
	}
	//helper method to print 2d array out
	public static void printArray(String[][] arr) {
		int l = arr.length;
		for (int i = 0; i < l; i++) {
			for (int k = 0; k < l; k++) {
				out.print(arr[i][k]);
			}
			out.println();
		}
	}

	public static boolean same(String[][] arr, String[][] arr2) {
		String a = "";
		String b = "";
		for (int i = 0; i < arr.length; i++) {
			for (int k = 0; k < arr.length; k++) {
				a += arr[i][k];
				b += arr2[i][k];
			}
		}
		return a.equals(b);
	}

	public static String[][] reflected(String[][] arr2) {
		String[][] arr = new String[arr2.length][arr2.length];
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				
				arr[i][arr2.length - j - 1] = arr2[i][j];
				arr[i][j] = arr2[i][arr2.length - j - 1];
			}
		}
		return arr;
	}
}

package bronzeFeb2018;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class hoofball {
	public static void main(String[] args) throws IOException {
		BufferedReader fin = new BufferedReader(new FileReader("hoofball.in"));
		PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("hoofball.out")));
		int tokens = Integer.parseInt(fin.readLine());
		int[] arr = new int[tokens];
		StringTokenizer st = new StringTokenizer(fin.readLine());
		for (int i = 0; i < tokens; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int size = arr.length;
		int balls = 0;
		int lastLeft = 1;
		if (oscillateLeft(arr[lastLeft], arr[lastLeft - 1], arr[lastLeft + 1])) {
			balls++;
		}
		int lastRight = arr.length - 2;
		if (oscillateRight(arr[lastRight], arr[lastRight - 1], arr[lastRight + 1])) {
			balls++;
		}
		lastLeft--;
		lastRight++;

		while (true) {
			for (int i = lastLeft + 2; i < arr.length - 1; i++) {
				if (oscillateLeft(arr[i], arr[i - 1], arr[i + 1])) {
					System.out.println("oscillated@ " + i);
					// pos.add(i);
					lastLeft = i;
					balls++;
					break;

				}

			}
			if (lastRight - lastLeft == 0 || lastRight - lastLeft == 1 || lastRight - lastLeft == 2) {
				break;
			}
			for (int i = lastRight - 2; i > 0; i--) {

				if (oscillateRight(arr[i], arr[i - 1], arr[i + 1])) {
					System.out.println("OscillatedRoigh@ " + i);
					lastRight = i;
					balls++;
					break;
				}

			}
			if (lastRight - lastLeft == 2 || lastRight - lastLeft == 1) {
				break;
			}
		}

		System.out.println(lastLeft + " " + lastRight);
		if (Math.abs(lastLeft - lastRight) == 1 || Math.abs(lastLeft - lastRight) == 0 || lastRight < lastLeft) {
			fout.println(balls);
		} else {
			fout.println(balls + 1);
		}
		fout.close();

	}

	public static boolean oscillateLeft(int mid, int left, int right) {
		if (mid - left <= right - mid) {
			return true;
		}
		return false;
	}

	public static boolean oscillateRight(int mid, int left, int right) {
		if (right - mid <= mid - left) {
			return true;
		}
		return false;
	}
}
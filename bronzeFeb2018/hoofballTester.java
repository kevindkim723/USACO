package bronzeFeb2018;

import java.io.*;
//import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class hoofballTester {
	public static void main(String[] args) throws IOException {

		int[] arr = { 1, 2, 3, 4, 5, 6 };
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
			lastRight++;
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
			System.out.println(balls);
		} else {
			System.out.println("ssss");
			System.out.println(balls + 1);
		}

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

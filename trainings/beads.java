
/*
ID: dodocan1
LANG: JAVA
TASK: beads
*/
import java.util.ArrayList;

import java.io.*;

public class beads {

	public static void main(String[] args) throws IOException {
		BufferedReader fin = new BufferedReader(new FileReader("beads.in"));
		PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
		fin.readLine();
		String input = fin.readLine();
		fin.close();

		int[] arr = cut(input);

		fout.println(determine(arr, input));
		fout.close();

		// System.out.println(determine(arr,input));

	}

	private static int[] cut(String input) {
		char prev = input.charAt(0);
		ArrayList<Integer> container = new ArrayList<Integer>();
		container.add(0);
		for (int i = 1; i < input.length(); i++) {
			if (input.charAt(i) != prev) {
				container.add(i);
				prev = input.charAt(i);
			}
		}
		int[] arr = new int[container.size()];
		for (int i = 0; i < container.size(); i++) {
			arr[i] = container.get(i);
		}
		return arr;

	}

	private static int determine(int[] arr, String input) {
		int highestLength = -1;
		for (int i : arr) {
			boolean w = false;
			String s = "";
			s += input.substring(i, input.length());
			s += input.substring(0, i);
			int sum = 2;
			char first = s.charAt(0);
			if (first == 'w') {
				w = true;
			}
			for (int k = 1; k < input.length(); k++) {
				if (s.charAt(k) == 'w' || s.charAt(k) == first) {
					sum++;
				} else if (w == true) {
					sum++;
					w = false;
					first = s.charAt(k);
				} else {
					break;
				}

			}

			char last = s.charAt(s.length() - 1);
			if (last == 'w') {
				w = true;
			}
			for (int k = input.length() - 2; k > 0; k--) {

				if (s.charAt(k) == 'w' || s.charAt(k) == last) {
					sum++;
				} else if (w == true) {
					sum++;
					w = false;
					last = s.charAt(k);
				} else {
					break;
				}
			}

			if (sum > input.length()) {

				return input.length();
			}
			if (sum > highestLength) {

				highestLength = sum;
			}
		}
		return highestLength;
	}
}

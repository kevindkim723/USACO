
// bronzeFeb2019;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

class cow {
	public int a, b;

	public cow(String x) {

		this.a = Integer.parseInt(x.split(" ")[0]);
		this.b = Integer.parseInt(x.split(" ")[1]);
	}

	public boolean overlap(cow c) {
		if (a == c.a || a == c.b || b == c.a || b == c.b) {
			return true;
		}
		return false;
	}
}

public class reveg {
	public static void main(String[] args) throws IOException {
		// BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader fin = new BufferedReader(new FileReader("revegetate.in"));
		PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("revegetate.out")));
		String fline = fin.readLine();
		int pastures = Integer.parseInt(fline.split(" ")[0]);
		int cows = Integer.parseInt(fline.split(" ")[1]);
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();

		for (int i = 0; i < cows; i++) {
			String[] s = fin.readLine().split(" ");
			int[] array = { Integer.parseInt(s[0]), Integer.parseInt(s[1]) };
			Arrays.sort(array);
			if (map.containsKey(array[1])) {
				map.get(array[1]).add(array[0]);

			} else {
				map.put(array[1], new ArrayList<Integer>());
				map.get(array[1]).add(array[0]);
			}

		}
		HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();
		// map2.put(1, 1);

		// System.out.println(1);
		for (int i = 1; i < cows; i++) {
			if (map.containsKey(i)) {
				ArrayList<Integer> currlist = map.get(i);
				int high = -1;
				for (int j = 0; j < currlist.size(); j++) {

					if (map2.get(currlist.get(j)) > high) {
						high = map2.get(currlist.get(j));
					}
				}
				map2.put(i, high + 1);
				// System.out.print(map2.get(Collections.max(map.get(i+2)))+1);
				// map2.put(i+2, map2.get(Collections.max(map.get(i+2)))+1);
				// int minimum = Collections.max(map.get(i+2));

			} else {
				// System.out.print(1);
				// map.put(i+2, new ArrayList<Integer>());
				// map.get(i+2).add(0);
				map2.put(i, 1);
				// System.out.println(i);
			}
		}
		for (int i : map2.keySet()) {
			fout.print(map2.get(i));
		}
		fout.close();

	}
}



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

public class revegetation {
	public static void main(String[] args) throws IOException {
		BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader fin = new BufferedReader(new FileReader("revegetate.in"));
		PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("revegetate.out")));
		String fline = fin.readLine();
		int pastures = Integer.parseInt(fline.split(" ")[0]);
		int cows = Integer.parseInt(fline.split(" ")[1]);

		ArrayList<cow> list = new ArrayList<cow>();
		for (int i = 0; i < pastures; i++) {
			list.add(new cow(fin.readLine()));
		}
		ArrayList<Integer> pasturelist = new ArrayList<Integer>();

		for (int i = 0; i < pastures; i++) {
			ArrayList<Integer> arr = new ArrayList<Integer>();

			if (i == 0) {
				pasturelist.add(1);
			} else {
				for (cow dick : list) {
					if (dick.a == i) {
						arr.add(dick.b);
					} else if (dick.b == i) {
						arr.add(dick.a);
					}
				}
				for (int k = 0; k < arr.size(); k++) {
					ArrayList<Integer> x = new ArrayList<Integer>();

					if (arr.get(k) < i) {
						x.add(pasturelist.get(k));
					}
					int min = 1;
					for (int j = 0; j < x.size(); j++) {
						if (x.get(j) == min) {
							min++;
						}
					}
					pasturelist.add(min);

				}

			}
		}
		for (int i = 0; i < pasturelist.size(); i++) {
			System.out.print(pasturelist.get(i));
		}

	}
}

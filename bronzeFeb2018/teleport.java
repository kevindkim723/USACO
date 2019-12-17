package bronzeFeb2018;

import java.io.*;
import java.util.StringTokenizer;

public class teleport {
	public static void main(String[] args) throws IOException {
		BufferedReader fin = new BufferedReader(new FileReader("teleport.in"));
		PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("teleport.out")));
		StringTokenizer st = new StringTokenizer(fin.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		if (a == b) {
			fout.print(0);
		}
		int raw = Math.abs(b - a);
		int min = closestTo(a, c, d);
		int max = closestTo(b, c, d);
		int tele = Math.abs(min - a) + Math.abs(b - max);
		if (tele < raw) {
			fout.print(tele);
		} else {
			fout.print(raw);
		}
		fout.println();
		fout.close();
	}

	public static int closestTo(int a, int b, int c) {
		if (Math.abs(a - b) > Math.abs(a - c)) {
			return c;

		} else {
			return b;
		}
	}
}


/*
ID: dodocan1
LANG: JAVA
TASK: dualpal
*/
import java.io.*;
import static java.lang.System.*;

public class dualpal {
	public static void main(String[] args) throws IOException {
		BufferedReader fin = new BufferedReader(new FileReader("dualpal.in"));
		PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
		String[] l = fin.readLine().split(" ");
		int max = Integer.parseInt(l[0]);
		int min = Integer.parseInt(l[1]) + 1;

		fin.close();
		int found = 0;
		while (found < max) {
			if (ispaltwo(min)) {
				fout.println(min);
				found++;
			}
			min++;

		}
		fout.close();
	}

	public static String base(int n, int b) {
		if (n < b) {
			return Integer.toString(n % b);
		}
		return base(n / b, b) + n % b;
	}

	public static boolean ispal(String x) {
		if (x.charAt(0) == '0' || x.charAt(x.length() - 1) == '0') {
			return false;
		}
		StringBuilder sb = new StringBuilder(x);
		if (x.equals(sb.reverse().toString())) {
			return true;
		}
		return false;
	}

	public static boolean ispaltwo(int a) {
		int pals = 0;
		for (int i = 2; i <= 10; i++) {
			if (ispal(base(a, i))) {
				out.println("a: " + base(a, i) + "in base " + i);
				pals++;
			}
			if (pals == 2) {
				return true;
			}

		}
		return false;

	}
}

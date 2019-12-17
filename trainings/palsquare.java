
/*
ID: dodocan1
LANG: JAVA
TASK: palsquare
*/
import java.io.*;

public class palsquare {
	static String[] alpha = "0123456789ABCDEFGHIJ".split("");

	public static void main(String[] args) throws IOException {

		BufferedReader fin = new BufferedReader(new FileReader("palsquare.in"));
		PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
		int x = Integer.parseInt(fin.readLine());
		for (int i = 1; i <= 300; i++) {
			String base = convertBase(i, x);

			String sq = convertBase((int) Math.pow(i, 2), x);

			if (isPal(sq)) {
				fout.println(base + " " + sq);
				System.out.println(i);
			}
		}
		fout.close();
		fin.close();

	}

	public static String convertBase(int a, int b) {
		StringBuilder sb = new StringBuilder();
		if (a < b) {
			return alpha[a % b];
		}
		return sb.insert(0, convertBase(a / b, b) + alpha[a % b]).toString();
	}

	public static int baseTen(String num, int base) {
		int x = Integer.parseInt(num);
		int l = num.length();
		if (l == 1) {
			return (int) (Math.pow(base, l - 1) * Integer.parseInt(num));
		}

		return (int) (Math.pow(base, l - 1) * Integer.parseInt(num.substring(0, 1))
				+ baseTen(num.substring(1, l), base));
	}

	public static boolean isPal(String s) {
		if (s.length() == 1) {
			return true;
		} else if (s.length() == 2) {
			if (s.charAt(0) == s.charAt(1)) {
				return true;
			}
			return false;
		}
		return (s.charAt(0) == s.charAt(s.length() - 1)) && isPal(s.substring(1, s.length() - 1));
	}
}

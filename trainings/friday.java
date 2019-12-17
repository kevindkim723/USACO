/*
ID: dodocan1
LANG: JAVA
TASK: friday
*/

import java.io.*;
import java.util.Arrays;

public class friday {
	public static void main(String[] args) throws IOException {
		int[] months = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int[] days = new int[7];
		int calendarDay = 0;
		Arrays.fill(days, 0);
		BufferedReader in = new BufferedReader(new FileReader("friday.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
		int yearBy = Integer.parseInt(in.readLine()) + 1900;
		in.close();
		for (int i = 1900; i < yearBy; i++) {
			for (int j = 0; j < 12; j++) {
				days[(calendarDay + 13) % 7]++;
				if (j == 1) {
					calendarDay += (!isLp(i)) ? 28 : 29;
				}
				calendarDay += months[j];
			}
		}
		out.print(days[6] + " " + days[0] + " " + days[1] + " " + days[2] + " " + days[3] + " " + days[4] + " "
				+ days[5]);
		out.println();
		out.close();
	}

	public static boolean isLp(int year) {
		if (year % 100 == 0) {
			if (year % 400 == 0) {
				return true;
			}
			return false;
		} else if (year % 4 == 0) {
			return true;
		} else {
			return false;
		}
	}
}
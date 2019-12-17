
//package trainings;
import static java.lang.System.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class namenumTester {
	static ArrayList<String> possibleCombos = new ArrayList<String>();

	public static void main(String[] args) throws FileNotFoundException {

		String[][] arr = new String[][] { {}, {}, { "A", "B", "C" }, { "D", "E", "F" }, { "G", "H", "I" },
				{ "J", "K", "L" }, { "M", "N", "O" }, { "P", "R", "S" }, { "T", "U", "V" }, { "W", "X", "Y" } };

		int num = 4734;

		Scanner scan = new Scanner(new File("/root/dict.txt"));
		ArrayList<String> dict = new ArrayList<String>();
		while (scan.hasNextLine()) {
			dict.add(scan.nextLine());
		}
		System.out.print(dict);
	}

	public void mutate(StringBuilder sb, int length, String[][] arr, int index) {

	}

}

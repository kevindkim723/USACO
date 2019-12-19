
//package trainings;
import static java.lang.System.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class namenumTester {
	static ArrayList<String> possibleCombos = new ArrayList<String>();
	static String[][] arr = new String[][] { {}, {}, { "A", "B", "C" }, { "D", "E", "F" }, { "G", "H", "I" },
			{ "J", "K", "L" }, { "M", "N", "O" }, { "P", "R", "S" }, { "T", "U", "V" }, { "W", "X", "Y" } };

	public static void main(String[] args) throws FileNotFoundException {
		
		int[] arr = { 4, 7, 3, 4 };
		int num = 4734;

		Scanner scan = new Scanner(new File("dict.txt"));
		ArrayList<String> dict = new ArrayList<String>();
		while (scan.hasNextLine()) {
			dict.add(scan.nextLine());
		}
		String permutations = permute(arr, 0,"");
		out.println(permutations);
		
	}

	public static String permute(int[] code, int index,String unfinished) {
		String all = "";
		if (index == code.length - 1) // if the index is the last in the code, we want to return that with the
		// specified permute plus the previous string.
		{
			all += unfinished + arr[code[index]][0] +" ";
			all += unfinished + arr[code[index]][1] +" ";
			all += unfinished + arr[code[index]][2] +" ";

			return all;
			//return unfinished + arr[code[index]][permutenum] +"\n";
		
		}
		for (int i = 0; i < 3; i++) {
			
				all += permute(code, index + 1, unfinished + arr[code[index]][i]);
				
			

		}
		return all;

		
		// if index is not last, we want to continue the permute

	}

}

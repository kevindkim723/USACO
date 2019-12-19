/*
ID: dodocan1
LANG: JAVA
TASK: namenum
*/
import static java.lang.System.*;

import java.util.*;
import java.util.*;
import java.io.*;
public class namenum {
	static ArrayList<String> corrects = new ArrayList<String>();
	static String[][] arr = new String[][] { {}, {}, { "A", "B", "C" }, { "D", "E", "F" }, { "G", "H", "I" },
			{ "J", "K", "L" }, { "M", "N", "O" }, { "P", "R", "S" }, { "T", "U", "V" }, { "W", "X", "Y" } };

	public static void main(String[] args) throws IOException {
		BufferedReader fin = new BufferedReader(new FileReader("namenum.in"));
		PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
		
		String input = fin.readLine();
		//out.println(input);
		int[] matrix = new int[input.length()];
		for (int i = 0; i < input.length();i++)
		{
			//out.println(input.charAt(i));
			matrix[i] = Character.getNumericValue(input.charAt(i));
		}
		BufferedReader scan = new BufferedReader(new FileReader("dict.txt"));
		ArrayList<String> dict = new ArrayList<String>();
		String line = null;
		while ((line = scan.readLine()) != null) {
			dict.add(line);
		}
		//out.println(Arrays.toString(matrix));
		permute(matrix,0,"",dict);
		//out.println(dict.contains("GREG"));
		//String[] permutationsArr = permutations.split(" ");
		//ArrayList<String> correct = new ArrayList<String>();
		/*for (String s : permutationsArr)
		{
			if (dict.contains(s))
			{
				correct.add(s);
			}
		}*/
		//out.println(corrects);
		//Collections.sort(corrects);
		if (corrects.size()==0)
		{
			fout.println("NONE");
		}
		else
		{
			Collections.sort(corrects);
		
			for (String s : corrects)
			{
				//out.println(s);
				fout.println(s);
			}
		}
		fout.close();
		
		
	}

	public static void permute(int[] code, int index,String unfinished, ArrayList<String> dictionary) {
		//out.println(dictionary);
		if (index == code.length - 1) // if the index is the last in the code, we want to return that with the
		// specified permute plus the previous string.
		{
			String perm1 = unfinished + arr[code[index]][0];
			String perm2 = unfinished + arr[code[index]][1];
			String perm3 = unfinished + arr[code[index]][2];
			out.println(perm1);
			out.println(perm2);
			out.println(perm3);
			if (dictionary.contains(perm1.trim()))
			{
				corrects.add(perm1);
			}
			if (dictionary.contains(perm2.trim()))
			{
				corrects.add(perm2);
			}
			if (dictionary.contains(perm3.trim()))
			{
				corrects.add(perm3);
			}

			return;
		
		}
		for (int i = 0; i < 3; i++) {
				 permute(code, index + 1, unfinished + arr[code[index]][i],dictionary);
		}
		return;
	}

}

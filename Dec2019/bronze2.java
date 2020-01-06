import java.io.*;
import java.util.*;

public class bronze2 {
	public static void main(String[] args) throws IOException {
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("whereami.out")));

		Scanner scanner = new Scanner(new FileReader("whereami.in"));
		int a = scanner.nextInt();
		String s = scanner.next();
		
		ArrayList<String> uniques = new ArrayList<String>();
		int length = 0;
		
		boolean dupe = true;
		
		while(dupe)
		{
			uniques.clear();
			length++;
			int duplications = 0;
			for (int i =0; i <= s.length()-length; i++)
			{
				if (uniques.contains(s.substring(i,i+length)))
				{
					duplications++;
				}
				uniques.add(s.substring(i, i+length));
				
			}
			if (duplications ==0)
			{
				dupe = false;
			}
		}
		
		
		out.println(length);
		out.close();
	
	}
}

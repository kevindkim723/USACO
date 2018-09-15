package trainings;
/*
ID: dodocannon
LANG: JAVA
TASK: ride
*/
import java.util.*;
import java.io.*;
public class ride {
	private static String alphabet = "abcdefghijklmnopqrstuvwxyz";
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader("ride.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
		String line1 = br.readLine();
		String line2 = br.readLine();
		int comet = 1, group  = 1;
		for (int i = 0; i < line1.length(); i++)
		{
			comet *= (alphabet.indexOf(Character.toLowerCase(line1.charAt(i))) + 1);
		}
		for (int i  = 0 ; i < line2.length(); i++)
		{
			group *= (alphabet.indexOf(Character.toLowerCase(line2.charAt(i)))+1);
		}
		if (comet%47==group%47)
		{
			out.println("GO");
		}
		else
		{
			out.println("STAY");
		}
		out.close();
	}
}

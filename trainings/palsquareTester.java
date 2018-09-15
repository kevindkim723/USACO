package trainings;
/*
ID: dodocan1
LANG: JAVA
TASK: palsquare
*/
import java.io.*;
import static java.lang.System.*;
public class palsquareTester {
	public static void main(String[] args) throws IOException
	{
		
		//BufferedReader fin = new BufferedReader(new FileReader("palsquare.in"));
		out.println(baseTen("10", 2));
		//int x = Integer.parseInt(fin.readLine());
		/*for (int i = 1; i<= 300; i++)
		{
			String base = convertBase(i, x);
			int basei = Integer.parseInt(base);
			String sq = Integer.toString((int) Math.pow(basei, 2));
			if (isPal(sq))
			{
				out.println(base + " " + sq);
			}
		}*/
		
		//fin.close();
		
	}
	public static String convertBase(int a, int b)
	{
		if (a < b)
		{
			return Integer.toString(a%b);
		}
		return convertBase(a/b,b) + a%b;
	}
	public static int baseTen(String num, int base)
	{
		int x = Integer.parseInt(num);
		int l = num.length();
		if (l == 1)
		{
			return (int) (Math.pow(base, l-1) * Integer.parseInt(num));
		}
		
		return (int) (Math.pow(base, l-1) * Integer.parseInt(num.substring(0,1)) + baseTen(num.substring(1,l),base));
	}
	public static boolean isPal(String s)
	{
		if (s.length() == 1)
		{
			return true;
		}
		else if (s.length() == 2)
		{
			if (s.charAt(0) == s.charAt(1))
			{
				return true;
			}
			return false;
		}
		return (s.charAt(0) == s.charAt(s.length()-1)) && isPal(s.substring(1, s.length()-1));
	}
}

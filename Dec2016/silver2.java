import java.io.*;
import java.util.*;
public class silver2 {
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader fin = new BufferedReader(new FileReader("citystate.in"));
		PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("citystate.out")));

		int n = Integer.parseInt(fin.readLine());
		String[] city = new String[n];
		String[] state = new String[n];
		ArrayList<String> citystate = new ArrayList<String>();
		HashMap<String, Integer> map = new HashMap<String,Integer>();
		HashMap<String, Integer> map2 = new HashMap<String,Integer>();

		for (int i = 0; i < n; i++)
		{
			StringTokenizer st = new StringTokenizer(fin.readLine());
			city[i] = st.nextToken().substring(0,2).toLowerCase();
			state[i] = st.nextToken().substring(0,2).toLowerCase();
			String com = city[i] +state[i];
			String rev = state[i] + city[i];
			if (map.containsKey(com) && map2.containsKey(com)) //if reverses and norm both contain the string
			{
				map.put(com, map.get(com) == 0 ? 0 : map.get(com)+1);
				map2.put(com, map2.get(com) == 0 ? 0 : map2.get(com)+1);

				
			}
			else
			{
				if (map.containsKey(com)) //if it contains the duplicate then add on the dupe list
				{
					map.put(com, map.get(com)+1);

				}
				else if (map2.containsKey(com))//if the reverses contain the string then add on to the reverse list
				{
					map2.put(com, map2.get(com)+1);
				}
				else
				{
					map.put(com, 1);
					map2.put(rev, 0);
				}
				
			}
			

		}
		int total = 0;
		System.out.println(map);
		System.out.println(map2);
		for (String s : map.keySet())
		{
			total += map.get(s) * (map2.containsKey(reverse(s)) ? map2.get(reverse(s)) : 0);
		}

		System.out.println(total);
		fout.println(total);
		fout.close();
		
		
	}
	public static String reverse(String s)
	{
		
		return s.substring(2,4) + s.substring(0,2);
	}
}

package trainings;
/*
 ID: dodocan1
 LANG: JAVA
 TASK: milk2
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
	class milk implements Comparable<milk>
	{
		private int start;
		private int end;
		public milk(int start, int end)
		{
			this.start = start;
			this.end = end;
		}
		public int getStart()
		{
			return start;
		}
		public int getEnd()
		{
			return end;
		}
		public int getTime()
		{
			return end - start;
		}
		
		public int compareTo(milk other) {
			if (other.getStart() > start)
			{
				return -1;
			}
			else if (other.getStart() < start)
			{
				return 1;
			}
			else
			{
				return 0;
			}
			
		}
		public boolean isCont(milk other)
		{
			if (end >= other.getStart() )
			{
				return true;
			}
			return false;
		}
		public String toString()
		{
			return start + ", " + end;
		}
		
		public int hashCode()
		{
			return start * 31 + end * 31;
		}
		public boolean equals(Object o)
		{
			milk m = (milk) o;
			if (this.start == m.start && this.end == m.end)
			{
				return true;
			}
			return false;
		}
	}
public class milk2 {
	
	public static void main(String[] args) throws IOException
	
	{
		BufferedReader fin = new BufferedReader(new FileReader("milk2.in"));
		PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
		HashSet<milk> uniq = new HashSet<milk>();
		
		fin.readLine();
		String input = null;
		while ((input = fin.readLine())!=null)
		{
			String[] nums = input.split(" ");
			uniq.add( new milk(Integer.parseInt(nums[0]),Integer.parseInt(nums[1])));
		}
		ArrayList<milk> list = new ArrayList<milk>(uniq);
		Collections.sort(list); 	
		int cont = getCont(list);
		int dis = getDis(list);
		fout.println(cont + " " + dis);
		fin.close();
		fout.close();
		
		
		
	}
	//this method assumes the list is sorted
	public static int getCont(ArrayList<milk> list)
	{
		int most = -1;
		int start = list.get(0).getStart();
		int end = list.get(0).getEnd();
		milk longest = new milk(start, end);
		most = longest.getTime();
		for (int i = 1; i < list.size(); i++)
		{
			milk curr = list.get(i);
			if (longest.isCont(curr))
			{
				if (longest.getEnd() < curr.getEnd())
				{
					longest = new milk(longest.getStart(), curr.getEnd());
				}
				continue;
			}
			else
			{
				if (longest.getTime() > most)
				{
					most = longest.getTime();
				}
				longest = curr;
			}
			
			
		}
		return most;
	}
	public static int getDis(ArrayList<milk> list)
	{
		int most = 0;
		int start = list.get(0).getStart();
		int end = list.get(0).getEnd();
		milk longest = new milk(start, end);
		
		for (int i = 1; i < list.size(); i++)
		{
			milk curr = list.get(i);
			if (longest.isCont(curr))
			{
				if (longest.getEnd() < curr.getEnd())
				{
					longest = new milk(longest.getStart(), curr.getEnd());
				}
				continue;
			}
			else
			{
				if (curr.getStart() - longest.getEnd() > most)
				{
					most = curr.getStart() - longest.getEnd();
				}
				longest = curr;
			}
		}
		return most;
	
	}
}


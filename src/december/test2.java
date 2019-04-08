package december;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
class cow 
{
	public int t1,t2,b;
	public cow(int t1, int t2, int b)
	{
		this.t1 = t1;
		this.t2 = t2;
		this.b = b;
	}
	public boolean overlap(cow o)
	{
		if (o.t1 > t1 && o.t1 < t2)
		{
			return true;
		}
		return false;
	}
	public String toString()
	{
		return "" +t1;
	}
	
	
}
class sorter implements Comparator<cow>
{
	public int compare(cow arg0, cow arg1) {
		return (arg0.t1 - arg1.t1);
	}
}
public class test2 {
	public static void main(String[] args) throws IOException
	{
		//new FileReader("blist.in")
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("blist.out")));
	    ArrayList<cow> cows = new ArrayList<cow>();
	    int num = Integer.parseInt(in.readLine());
	    for (int i = 0; i < num; i++)
	    {
	    	String[] a = in.readLine().split(" ");
	    	cows.add(new cow(Integer.parseInt(a[0]), Integer.parseInt(a[1]), Integer.parseInt(a[2])));
	    }
	    Collections.sort(cows, new sorter());
	    System.out.println(cows);
	    int buckets = 0;
	    int pool = 0;
	    ArrayList<Integer> endtimes = new ArrayList<Integer>();
	    for (int i = 0; i < cows.size(); i++)
	    {
	    	cow curr = cows.get(i);
	    	if (i == 0)
	    	{
	    		buckets = curr.b;
	    		endtimes.add(curr.t2);
	    		continue;
	    	}
	    	for (int k : endtimes)
	    	{
	    		if (curr.t1 < k)
	    		{
	    			buckets += curr.b - pool;
	    			pool -= 
	    		}
	    		if (curr.t2 < k)
	    		{
	    			pool+= curr.b;
	    		}
	    		if (curr.t2 > k)
	    		{
	    			
	    		}
	    		
	    	}
	    	
	    }
	   
	    
	}
	
	

}

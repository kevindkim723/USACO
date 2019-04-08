//package december;
import java.io.*;
public class test {
	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new FileReader("mixmilk.in"));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mixmilk.out")));
	    String[] a = in.readLine().split(" ");
	    String[] b = in.readLine().split(" ");
	    String[] c = in.readLine().split(" ");
	    
	    int b1, b2, b3, c1,c2,c3;
	    
	    b1 = Integer.parseInt(a[0]);
	    b2 = Integer.parseInt(b[0]);
	    b3 = Integer.parseInt(c[0]);
	    
	    c1 = Integer.parseInt(a[1]);
	    c2 = Integer.parseInt(b[1]);
	    c3 = Integer.parseInt(c[1]);
	    
	    int[] buckets = new int[3];
	    buckets[0] = c1;
	    buckets[1] = c2;
	    buckets[2] = c3;
	    
	    int[] capacities = new int[3];
	    capacities[0] = b1;
	    capacities[1] = b2;
	    capacities[2] = b3;
	    
	    
	    for (int i = 1; i <= 100; i++)
	    {
	    	int d = i % 3;
	    	int x = d-1;
	    	if (d == 0)
	    	{
	    		x = 2;
	    	}
	    		
	    	
	    		int sum = buckets[d] + buckets[x];
	    		if (sum > capacities[d])
	    		{
	    			int d1 = sum - capacities[d];
		    		
		    		buckets[d] = capacities[d];
		    		buckets[x] = d1;
		    		
	    		}
	    		else
	    		{
	    			buckets[d] = sum;
	    			buckets[x] = 0;
	    		}
	    		
	    
		    
	    	
	    	
	    	
	    }
	    for (int k : buckets)
    	{
    		out.println(k);
    	}
	    out.close();
	    
	}
}

import java.io.*;
import java.util.*;


public class dec2019silver2 {
	static class cow
	{
		int weight;
		double pos;
		int vel;
		
		public cow(int weight, double pos, int vel)
		{
			this.weight = weight;
			this.pos = pos;
			this.vel = vel;
		}
		
		public boolean iscrash(cow other)
		{
			return other.pos == pos;
		}
		public void crash()
		{
			vel = -vel;
		}
		public void move()
		{
			pos += vel *.5;
		}
		public void barn()
		{
			vel = 0;
		}
		
	}
	public static void main(String[] args) throws IOException {
		
		int crashes = 0;
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("meetings.out")));

		BufferedReader br = new BufferedReader(new FileReader("meetings.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int barn2 = Integer.parseInt(st.nextToken());
		
		ArrayList<cow> allcows = new ArrayList<cow>();
		
		
		String currLine = null;
		int sumweights = 0; //weight of all cows
		int sumcrash = 0; // weight of barned cows
		while ((currLine = br.readLine()) != null)
		{
			st = new StringTokenizer(currLine);
			int w = Integer.parseInt(st.nextToken());
			double x = Double.parseDouble(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			sumweights +=w;
			allcows.add(new cow(w,x,v));
		}
		double time = 0;
		while (sumcrash <= (double)sumweights/2)
		{
			for (cow c : allcows)
			{
				c.move();
			}
			for (int i = 0; i < allcows.size()-1; i++)
			{
				cow currcow = allcows.get(i);
				cow nextcow = allcows.get(i+1);
				
				if (currcow.iscrash(nextcow)) // if these cows crash, then we can skip to the next cow.
				{
					currcow.crash();
					nextcow.crash();
					crashes++;
					i++;
				}
				//if the cows dont crash then you have to look at the next cow
			}
			for(Iterator<cow> itr = allcows.iterator(); itr.hasNext();){            
	            cow c = itr.next();            
	            if(c.pos == 0 || c.pos == barn2){
	                sumcrash +=c.weight;
	                itr.remove(); 
	                
	            }
	        }
	        
			/*for (cow c: allcows)
			{
				if (c.pos == 0 || c.pos == barn2)
				{
					sumcrash += c.weight;
					allcows.remove(c);
				}
			}*/
			
			time +=.5;
		}
		out.println(crashes);
		out.close();
		
		
		
		
		
		
	}
}

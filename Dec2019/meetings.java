import java.io.*;
import java.util.*;



public class meetings {
	static class cow implements Comparable<cow>
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
		
		public void move()
		{
			pos += vel *.5;
		}
		public void barn()
		{
			vel = 0;
		}
		public int compareTo(cow other)
		{
			return (int) (this.pos - other.pos);
		}
		public String toString()
		{
			return "\n******************\npos: " + this.pos + "\nweight: " + this.weight + "\nvel: " + this.vel;
		}
	}
	public static void main(String[] args) throws IOException {
		
		int crashes = 0;
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("meetings.out")));

		BufferedReader br = new BufferedReader(new FileReader("meetings.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int barn2 = Integer.parseInt(st.nextToken());
		
		LinkedList<cow> allcows = new LinkedList<cow>();
		LinkedList<cow> lefts = new LinkedList<cow>();
		LinkedList<cow> rights = new LinkedList<cow>();
		
		
		String currLine = null;
		int sumweights = 0; //weight of all cows
		int sumcrash = 0; // weight of barned co
		while ((currLine = br.readLine()) != null)
		{
			
			st = new StringTokenizer(currLine);
			int w = Integer.parseInt(st.nextToken());
			double x = Double.parseDouble(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			sumweights +=w;
			allcows.add(new cow(w,x,v));
			if (v==-1)
			{
				lefts.add(new cow(w,x,v));
			}
			else
			{
				rights.add(new cow(w,x,v));
			}
		}
		Collections.sort(allcows);
		Collections.sort(lefts);
		Collections.sort(rights);
		System.out.println(allcows);
		
		
		System.out.println("OOH OOH LEFTS: " + lefts);
	
		System.out.println("OOH OOH RIGHTS: " + rights);
		while (sumcrash < sumweights/2)
		{
			if (lefts.peek().pos > (barn2 - rights.peekLast().pos)) //if rightward velocity cow is closer to right 
			{
				cow c = allcows.removeLast();
				sumcrash += c.weight;
				if (c != rights.peekLast()) crashes++;
				rights.remove();
			}
			else if (lefts.peek().pos < (barn2 - rights.peekLast().pos))//if leftward velocity cow is closer to left
			{
				cow c = allcows.removeFirst();
				if (c != lefts.peek()) crashes++;
				lefts.remove();
				sumcrash+=c.weight;
			}
			else
			{
				
			}
		}
		out.println(crashes);
		out.close();
		
		
		
		
		
		
	}
}

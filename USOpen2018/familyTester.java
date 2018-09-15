package USOpen2018;
import java.io.*;
import java.util.*;
class mother
{
	private String name;
	private HashSet<mother> children = new HashSet<mother>();
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		mother other = (mother) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	public mother(String name)
	{
		this.name = name;
	}
	public void addChild(mother childName)
	{
		children.add(childName);
	}
	public String getName()
	{
		return name;
	}
	public HashSet<mother> getChildren()
	{
		return children;
	}
	public boolean hasChild(String name)
	{
		for (mother m : children)
		{
			if (m.getName().equals(name))
			{
				return true;
			}
		}
		return false;
	}
	@Override
	public String toString() {
		return "mother [name=" + name + ", children=" + children + "]";
	}
	public boolean hasDeep(String m)
	{
		if (m.equals(name))
		{
			return true;
		}
		for (mother r : children)
		{
			if (r.getName()==m)
			{
				return true;
			}
		}
		if (children.isEmpty())
		{
			return false;
		}
		
		else
		{
			for (mother o : children)
			{
				return o.hasDeep(m);
			}
		}
		return false;
	}
	public mother findChild(String x)
	{
		if (x.equals(name))
		{
			return this;
		}
		if (children.size()==0)
		{
			return null;
		}
		for (mother m : children)
		{
			if (m.getName().equals(x))
			{
				return m;
			}
		}
		for (mother m : children)
		{
			return m.findChild(x);
		}
		return null;
	}

	
}
public class familyTester {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader("/root/family.in"));
		String[] arr = br.readLine().split(" ");
		int lines = Integer.parseInt(arr[0]);
		String first = arr[1];
		String last = arr[2];
		HashSet<mother> listOfMothers = new HashSet<mother>();
		HashSet<String> motherNames = new HashSet<String>();
		for (int i = 0; i < lines; i++)
		{
			String[] array = br.readLine().split(" ");
			String mom = array[0];
			String daughter = array[1];
			if (listOfMothers.isEmpty())
			{
				mother m = new mother(mom);
				m.addChild(new mother(daughter));
				listOfMothers.add(m);
				continue;
			}
			for (mother o : listOfMothers)
			{
				
				if (o.hasDeep(mom))
				{
					o.findChild(mom).addChild(new mother(daughter));
				}
				if (daughter.equals(o.getName()))
				{
					
					mother m = new mother(mom);
					m.addChild(o);
					listOfMothers.remove(o);
					listOfMothers.add(m);
				}
				
			}
			
			
		}
		System.out.println(motherNames);
		System.out.println(listOfMothers);
		
		
	}
	
}

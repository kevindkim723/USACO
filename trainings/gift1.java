
/*
 ID: dodocan1
 LANG: JAVA
 TASK: gift1
 */
import java.io.*;
import java.util.*;
import java.math.*;

class person {
	protected String name;
	protected int money;

	public person(String name, int money) {
		this.name = name;
		this.money = money;
	}

}

public class gift1 {
	public static void main(String[] args) throws IOException {
		// BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader in = new BufferedReader(new FileReader("gift1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
		int numPeople = Integer.parseInt(in.readLine());

		ArrayList<person> people = new ArrayList<person>();
		for (int i = 0; i < numPeople; i++) {
			people.add(new person(in.readLine(), 0));

		}

		while (true) {
			String s = in.readLine();
			if (s == null) {
				break;
			}
			// System.out.println(s);
			person giver = getPerson(people, s);

			StringTokenizer st = new StringTokenizer(in.readLine());
			int loan = Integer.parseInt(st.nextToken());
			giver.money -= loan;
			// System.out.println(giver.money);
			int peopleToLoanTo = Integer.parseInt(st.nextToken());
			if (peopleToLoanTo != 0) {
				giver.money += loan % peopleToLoanTo;
				// System.out.println(giver.name + " " + giver.money);
			}

			for (int i = 0; i < peopleToLoanTo; i++) {
				person reciever = getPerson(people, in.readLine());
				reciever.money += loan / peopleToLoanTo;
				// System.out.println(reciever.name + " " + reciever.money);
			}
		}
		for (person p : people) {
			out.println(p.name + " " + p.money);
		}
		out.close();

	}

	public static person getPerson(ArrayList<person> arr, String name) {
		for (person p : arr) {
			if (p.name.equals(name)) {
				return p;
			}
		}
		return null;
	}
}

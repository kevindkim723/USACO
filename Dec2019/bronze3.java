import java.io.*;
import java.util.*;

public class bronze3 {
	static class line {
		String tail;
		String head;
		ArrayList<String> body = new ArrayList<String>();

		public line(String tail, String head) {
			this.tail = tail;
			this.head = head;
		}

		public void merge(line l) {
			if (head.equals(l.tail)) {
				body.add(head);
				head = l.head;
				for (String s : l.body) {
					body.add(s);
				}

			} else if (tail.equals(l.head)) {
				body.add(0, tail);
				tail = l.tail;
				for (int i = l.body.size() - 1; i >= 0; i--) {
					body.add(0, l.body.get(i));
				}
			} else if (head.equals(l.head)) {
				body.add(head);
				head = l.tail;
				for (int i = l.body.size() - 1; i >= 0; i--) {
					body.add(l.body.get(i));
				}

			} else if (tail.equals(l.tail)) {
				String holder = tail;
				body.add(0, tail);
				tail = l.head;
				for (int i = 0; i < l.body.size(); i++) {
					body.add(0, l.body.get(i));

				}

			}
		}

		public boolean mergeable(line l) {
			return head.equals(l.tail) || tail.equals(l.head) || tail.equals(l.tail) || head.equals(l.head);
		}

		public String toString() {
			return "||" + tail + "||" + body + "||" + head + "||";
		}

		public void reorder() {
			if (tail.compareTo(head) > 0) {
				String a = head;
				head = tail;
				tail = a;
				body = reverseArray(body);

			}
		}
	}

	public static void main(String[] args) throws IOException {

		FileReader fr = new FileReader("lineup.in");
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lineup.out")));

		Scanner sc = new Scanner(fr);
		int a = sc.nextInt();
		sc.nextLine();
		ArrayList<String> cows = new ArrayList<String>();
		cows.add("Bessie");
		cows.add("Buttercup");
		cows.add("Belinda");
		cows.add("Beatrice");
		cows.add("Bella");
		cows.add("Blue");
		cows.add("Betsy");
		cows.add("Sue");

		ArrayList<line> l = new ArrayList<line>();
		for (int i = 0; i < a; i++) {
			String[] arr = sc.nextLine().split(" ");
			String n1 = arr[0];
			String n2 = arr[5];
			cows.remove(n1);
			cows.remove(n2);
			l.add(new line(n1, n2));

		}
		for (int i = 0; i < l.size(); i++) {
			for (int j = 0; j < l.size(); j++) {
				if (i == j) {
					continue;
				}
				if (l.get(i).mergeable(l.get(j))) {
					l.get(i).merge(l.get(j));
					l.remove(l.get(j));
					i = 0;
					j = 0;

				}
			}
		}
		for (line s : l) {
			s.reorder();
			cows.add(s.tail);
		}
		// System.out.println(l.toString());

		java.util.Collections.sort(cows);
		System.out.println(cows);
		ArrayList<String> correct = new ArrayList<String>();
		for (String s : cows) {
			correct.add(s);
			for (line aline : l) {
				if (aline.tail.equals(s)) {
					for (String bodyparts : aline.body) {
						correct.add(bodyparts);
					}
					correct.add(aline.head);

				}

			}

		}
		for (String s : correct) {
			out.println(s);
		}
		out.close();
	}

	public static ArrayList<String> reverseArray(ArrayList<String> a) {
		ArrayList<String> b = new ArrayList<String>();

		for (String s : a) {
			b.add(0, s);
		}
		return b;
	}
}